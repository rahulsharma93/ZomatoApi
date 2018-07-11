package com.example.first.firstproject;

import com.example.first.firstproject.category.CategoryComponent;
import com.example.first.firstproject.category.CategoryModule;
import com.example.first.firstproject.network.NetworkModule;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    CategoryComponent plus(CategoryModule categoryModule);

}
