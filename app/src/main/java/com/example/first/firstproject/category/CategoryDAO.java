package com.example.first.firstproject.category;

import com.google.gson.annotations.SerializedName;

public class CategoryDAO {

    @SerializedName(value = "categories")
    private CategoryModel categoryModel;

    public CategoryModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }
}
