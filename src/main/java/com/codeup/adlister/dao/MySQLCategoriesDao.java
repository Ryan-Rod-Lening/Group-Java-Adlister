package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLCategoriesDao implements Categories {
    private Connection connection = null;

    public MySQLCategoriesDao(Config config) {
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

    public void insert(Category category){
//        try {
//            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
//            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
//            stmt.setLong(1, ad.getUserId());
//            stmt.setString(2, ad.getTitle());
//            stmt.setString(3, ad.getDescription());
//            stmt.executeUpdate();
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//        } catch (SQLException e) {
//            throw new RuntimeException("Error updating ad category.", e);
//        }
    }
}
