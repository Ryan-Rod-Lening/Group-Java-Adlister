package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

public interface Categories {

    void matchParamToId(String category);
    void insert(Category category);
    Category selectMatchingCategories(String category);
}
