package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.HashMap;
import java.util.List;

public class MySQLAd_CategoryDao implements Ad_Categories{
    private Connection connection;

    public MySQLAd_CategoryDao(Config config) {
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

    public void insertAdCategory(long adId, long catId) {
        String query = "INSERT INTO ad_category(ad_id, category_id) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, adId);
            stmt.setLong(2, catId);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new ad_category", e);
        }
    }
    public HashMap<Ad, Object> addCategoriesToListAll(List<Ad> adList){
        HashMap<Ad, Object> newAdMap = new HashMap<>();
        for (Ad ad : adList) {
            try {
                PreparedStatement stmt = null;
                stmt = connection.prepareStatement("SELECT JSON_ARRAYAGG(name) FROM ad_category JOIN categories ON categories.id = ad_category.category_id JOIN ads ON ads.id = ad_category.ad_id WHERE ads.id = ?");
                stmt.setLong(1, ad.getId());
                ResultSet rs = stmt.executeQuery();
                rs.first();
                newAdMap.put(ad, rs.getObject(1));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return newAdMap;
    }
}
