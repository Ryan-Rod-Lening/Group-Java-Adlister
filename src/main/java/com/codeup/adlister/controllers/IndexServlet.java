package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "controllers.IndexServlet", urlPatterns = "")
public class IndexServlet extends HttpServlet {



    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ad> allAdsWithoutCat = DaoFactory.getAdsDao().all();
        if (allAdsWithoutCat != null) {
            HashMap<Ad, Object> allAdsWithCat = DaoFactory.getAd_CategoriesDao().addCategoriesToListAll(allAdsWithoutCat);
            req.setAttribute("ads", allAdsWithoutCat);
            req.setAttribute("adsCategory", allAdsWithCat);
            System.out.println(allAdsWithCat);
        }
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);

    }
}