package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

public interface Ad_Categories {
    void insertAdCategory(long ad, long category);
}
