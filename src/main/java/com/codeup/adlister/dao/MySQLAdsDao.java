package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT ad_category.ad_id, ad_category.category_id, ads.id, ads.user_id, ads.title, ads.description, categories.id, GROUP_CONCAT(categories.name) as 'categories.name' FROM ad_category JOIN categories ON categories.id = ad_category.category_id JOIN ads ON ads.id = ad_category.ad_id GROUP BY ads.id;");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    public List<Ad> allUserAds(long userId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT ad_category.ad_id, ad_category.category_id, ads.id, ads.user_id, ads.title, ads.description, categories.id, GROUP_CONCAT(categories.name) as 'categories.name' FROM ad_category JOIN categories ON categories.id = ad_category.category_id JOIN ads ON ads.id = ad_category.ad_id WHERE ads.user_id = ? GROUP BY ads.id;");
            stmt.setLong(1, userId);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all user's ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    public Long getAdById(long userId, String title) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT id FROM ads WHERE title = ? AND user_id = ?");
            stmt.setString(1, title);
            stmt.setLong(2, userId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
        return null;
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("ads.id"),
            rs.getLong("ads.user_id"),
            rs.getString("ads.title"),
            rs.getString("ads.description"),
            rs.getString("categories.name")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    @Override
    public List<Ad> SearchedAd(String userInput) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads where title LIKE CONCAT('%', ?, '%')");
            stmt.setString(1,userInput);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving matching ads.", e);
        }
    }
}
