package com.codeup.adlister.dao;

import com.codeup.adlister.controllers.AdsIndexServlet;
import com.codeup.adlister.models.Ad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DaoFactory extends AdsIndexServlet {
    private static Ads adsDao;
    private static Users usersDao;



    private static Categories categoriesDao;
    private static Ad_Categories ad_categoriesDao;

    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }
    public static Categories getCategoriesDao() {
        if (categoriesDao == null) {
            categoriesDao = new MySQLCategoriesDao(config);
        }
        return categoriesDao;
    }
    public static Ad_Categories getAd_CategoriesDao() {
        if (ad_categoriesDao == null) {
            ad_categoriesDao = new MySQLAd_CategoryDao(config);
        }
        return ad_categoriesDao;
    }
}
