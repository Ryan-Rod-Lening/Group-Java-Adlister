package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "searchAdsServlet", urlPatterns = "/ads/search")
public class categorySearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categorySearch = req.getParameter("searchbar");
        List<Ad> ads2 = DaoFactory.getAdsDao().CategorySearch(categorySearch);
        req.setAttribute("search", ads2);

        req.getRequestDispatcher("/WEB-INF/ads/search.jsp").forward(req, resp);
    }
}
