package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.HashMap;
import java.util.List;

public interface Ad_Categories {
    void insertAdCategory(long ad, long category);
    HashMap<Ad, Object> addCategoriesToListAll(List<Ad> adList);
}
