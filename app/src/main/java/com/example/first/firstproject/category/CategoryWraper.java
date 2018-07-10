package com.example.first.firstproject.category;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryWraper {

    @SerializedName(value = "categories")
    private List<CategoryDAO> categories;

    public List<CategoryDAO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDAO> categories) {
        this.categories = categories;
    }
}
