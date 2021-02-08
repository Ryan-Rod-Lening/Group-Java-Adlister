package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "SingleAdServlet", urlPatterns = "/ads/single")
public class SingleAdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long singleAdId = Long.parseLong(req.getParameter("id"));
        List<Ad> searchedAd = DaoFactory.getAdsDao().getAdById(singleAdId);
        if (searchedAd != null) {
            HashMap<Ad, Object> allAdsWithCat = DaoFactory.getAd_CategoriesDao().addCategoriesToListAll(searchedAd);
            req.setAttribute("ads", searchedAd);
            req.setAttribute("adsCategory", allAdsWithCat);
        }
        req.getRequestDispatcher("/WEB-INF/ads/singleAd.jsp").forward(req, resp);
    }
}

