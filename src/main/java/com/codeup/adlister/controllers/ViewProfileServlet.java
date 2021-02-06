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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputUsername = req.getParameter("inputUsername");
        String inputEmail = req.getParameter("inputEmail");

        User user1 = DaoFactory.getUsersDao().findByUsername(inputUsername);
        User user2 = DaoFactory.getUsersDao().findByEmail(inputEmail);
        if (user1 != null || user2 != null) {
            req.setAttribute("validationFail", true);
            String validationFailMessage = "There was an error trying to save your profile changes:";
            req.setAttribute("validationFailMsg", validationFailMessage);
            if (user1 != null) {
                String usernameValidationFail = "-That username is already taken-";
                req.setAttribute("userValidation", usernameValidationFail);
            } if (user2 !=null) {
                String emailValidationFail = "-That email address is already taken-";
                req.setAttribute("emailValidation", emailValidationFail);
            }
            List<Ad> allAdsWithoutCat = DaoFactory.getAdsDao().allUserAds(((User) req.getSession().getAttribute("user")).getId());
            HashMap<Ad, Object> allAdsWithCat = DaoFactory.getAd_CategoriesDao().addCategoriesToListAll(allAdsWithoutCat);
            req.setAttribute("ads", allAdsWithoutCat);
            req.setAttribute("adsCategory", allAdsWithCat);
            req.getRequestDispatcher("/WEB-INF/profile.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/ads");
        }
    }
}
