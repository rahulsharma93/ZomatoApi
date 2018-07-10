package com.example.first.firstproject.network;

import com.example.first.firstproject.category.CategoryWraper;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ZomatoService {

    @GET("categories")
    Observable<CategoryWraper> getCategories(@Header("user-key") String apiKey);

}
