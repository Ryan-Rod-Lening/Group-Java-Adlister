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

@WebServlet (name = "searchAdsServlet", urlPatterns = "/ads/search")
public class SearchAdsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInput = req.getParameter("searchbar");
       //        req.setAttribute("ads", DaoFactory.getAdsDao().SearchedAd(userInput));
        List<Ad> ads = DaoFactory.getAdsDao().SearchedAd(userInput);
        req.setAttribute("search", ads);
        req.getRequestDispatcher("/WEB-INF/ads/search.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}


    //    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (req.getSession().getAttribute("user") == null) {
//            resp.sendRedirect("/login");
//            return;
//        }
//        req.getRequestDispatcher("/WEB-INF/profile.jsp").forward(req, resp);
//    }


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       String userInput = req.getParameter("searchbar");
//        req.setAttribute("ads", DaoFactory.getAdsDao().SearchedAd(userInput));
//        req.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(req,resp);

//    }
