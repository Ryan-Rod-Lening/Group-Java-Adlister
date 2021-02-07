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

@WebServlet(name = "SingleAdServlet", urlPatterns = "/ads/single")
public class SingleAdServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String singleAd = req.getParameter("viewbtn");
              List<Ad> ads = DaoFactory.getAdsDao().individualAd(singleAd);
        req.setAttribute("single", ads);
        req.getRequestDispatcher("/WEB-INF/ads/singleAd.jsp").forward(req, resp);
    }

    }

