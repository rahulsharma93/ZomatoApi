package com.example.first.firstproject.category;

import com.example.first.firstproject.Utils;
import com.example.first.firstproject.network.ZomatoService;

import java.util.List;

import io.reactivex.Observable;

public class CategoryInteractorImpl implements CategoryInteractor {

    private ZomatoService zomatoService;

    public CategoryInteractorImpl(ZomatoService zomatoService){
        this.zomatoService = zomatoService;
    }

    @Override
    public Observable<List<CategoryDAO>> getCategories() {
        return zomatoService.getCategories(Utils.API_KEY).map(CategoryWraper :: getCategories);
    }
}
