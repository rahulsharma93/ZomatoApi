package com.example.first.firstproject.category;

import java.util.ArrayList;

public interface CategoryView {

    void showLoading();
    void hideLoading();
    void showList(ArrayList<CategoryDAO> categoryModelArrayList);
    void onCategoryClicked(CategoryModel categoryModel);
}
