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
            stmt = connection.prepareStatement("SELECT ad_category.ad_id, ad_category.category_id, ads.id, ads.user_id, ads.title, ads.description, categories.id, GROUP_CONCAT(categories.name) as 'categories.name' FROM ad_category JOIN categories ON categories.id = ad_category.category_id JOIN ads ON ads.id = ad_category.ad_id AND active = 1 GROUP BY ads.id;");
            ResultSet rs = stmt.executeQuery();
            return createConcatAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    public List<Ad> allUserAds(long userId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT ad_category.ad_id, ad_category.category_id, ads.id, ads.user_id, ads.title, ads.description, categories.id, GROUP_CONCAT(categories.name) as 'categories.name' FROM ad_category JOIN categories ON categories.id = ad_category.category_id JOIN ads ON ads.id = ad_category.ad_id WHERE ads.user_id = ? AND active = 1 GROUP BY ads.id;");
            stmt.setLong(1, userId);
            ResultSet rs = stmt.executeQuery();
            return createConcatAdsFromResults(rs);
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
            stmt = connection.prepareStatement("SELECT id FROM ads WHERE title = ? AND user_id = ? AND active = 1");
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

    public List<Ad> getAdById(long adId) {
        try {
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement("SELECT ad_category.ad_id, ad_category.category_id, ads.id, ads.user_id, ads.title, ads.description, categories.id, GROUP_CONCAT(categories.name) as 'categories.name' FROM ad_category JOIN categories ON categories.id = ad_category.category_id JOIN ads ON ads.id = ad_category.ad_id WHERE ads.id = ? AND active = 1 GROUP BY ads.id;");
            stmt.setLong(1, adId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                return createConcatSingleAdFromResults(rs);            }
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
                rs.getString("ads.description")
        );
    }

    private Ad extractAdConcat(ResultSet rs) throws SQLException {
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

    private List<Ad> createConcatAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAdConcat(rs));
        }
        return ads;
    }

    private List<Ad> createConcatSingleAdFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
            ads.add(extractAdConcat(rs));
        return ads;
    }

    @Override
    public List<Ad> SearchedAd(String userInput) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads where title LIKE CONCAT('%', ?, '%') AND active = 1");
            stmt.setString(1,userInput);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving matching ads.", e);
        }
    }
    @Override
    public List<Ad>CategorySearch(String userInput){
        System.out.println(userInput);
        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("SELECT ads.title, ads.description, GROUP_CONCAT(categories.name) as 'categories.name' FROM ad_category JOIN categories ON categories.id = ad_category.category_id JOIN ads ON ads.id = ad_category.ad_id where ads.title LIKE CONCAT('%',?,'%') OR categories.name LIKE CONCAT('%',?,'%') OR ads.description LIKE CONCAT('%',?,'%')");
            stmt.setString(1,userInput);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs);
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving matching ads.", e);
        }
    }


    @Override
    public List<Ad> individualAd(String singleAd) {
        System.out.println("single ad = " + singleAd);
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement("SELECT * FROM ads WHERE ads.id = ? AND active = 1");
            pst.setString(1, singleAd);
            ResultSet rs = pst.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving specific add", e);
        }
    }

    @Override
    public void deleteAd(Ad ad) {
        String query = "UPDATE ads SET active = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setByte(1, (byte) 0);
            stmt.setLong(2, ad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating existing user", e);
        }
    }

    public void editAd(Ad ad) {
        String query = "UPDATE ads SET title = ?, description = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.setLong(3, ad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating existing user", e);
        }
    }

}
