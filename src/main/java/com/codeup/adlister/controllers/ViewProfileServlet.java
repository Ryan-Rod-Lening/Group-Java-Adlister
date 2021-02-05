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

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        List<Ad> allAdsWithoutCat = DaoFactory.getAdsDao().allUserAds(((User) request.getSession().getAttribute("user")).getId());
        HashMap<Ad, Object> allAdsWithCat = DaoFactory.getAd_CategoriesDao().addCategoriesToListAll(allAdsWithoutCat);
        request.setAttribute("ads", allAdsWithoutCat);
        request.setAttribute("adsCategory", allAdsWithCat);
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
