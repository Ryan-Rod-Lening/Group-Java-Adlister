package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

public interface Categories {

    Category selectMatchingCategories(String category);
}
