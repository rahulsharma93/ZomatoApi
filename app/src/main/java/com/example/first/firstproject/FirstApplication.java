package com.example.first.firstproject;

import android.app.Activity;
import android.app.Application;

import com.example.first.firstproject.network.GithubService;
import com.example.first.firstproject.network.ZomatoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FirstApplication extends Application {

    private GithubService githubService;
    private ZomatoService zomatoService;

    public static FirstApplication get(Activity activity) {
        return (FirstApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();


        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {

            }
        });

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Picasso picasso = new Picasso.Builder(this)
                .build();

        /*Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("https://api.github.com/")
                .build();*/

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(BuildConfig.ZOMATO_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        //githubService = retrofit.create(GithubService.class);
        zomatoService = retrofit.create(ZomatoService.class);


    }

    public GithubService getGithubService() {
        return githubService;
    }

    public ZomatoService getZomatoService() {
        return zomatoService;
    }
}
