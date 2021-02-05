package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.ListAdsDao;
import com.codeup.adlister.dao.MySQLAdsDao;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {



    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ad> allAdsWithoutCat = DaoFactory.getAdsDao().all();
        HashMap<Ad, Object> allAdsWithCat = DaoFactory.getAd_CategoriesDao().addCategoriesToListAll(allAdsWithoutCat);
        req.setAttribute("ads", allAdsWithoutCat);
        req.setAttribute("adsCategory", allAdsWithCat);
        System.out.println(allAdsWithCat);
        req.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(req, resp);

    }
}
