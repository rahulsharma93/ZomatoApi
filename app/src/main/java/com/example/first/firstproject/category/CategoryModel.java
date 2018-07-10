package com.example.first.firstproject.category;

import com.google.gson.annotations.SerializedName;

public class CategoryModel {

    @SerializedName(value = "id")
    private int id;

    @SerializedName(value = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
