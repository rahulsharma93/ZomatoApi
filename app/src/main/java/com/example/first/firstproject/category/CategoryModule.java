package com.example.first.firstproject.category;
import com.example.first.firstproject.network.ZomatoService;

import dagger.Module;
import dagger.Provides;

@Module
public class CategoryModule {

    @Provides
    @CategoryScope
    CategoryInteractor provideInteractor(ZomatoService zomatoService) {
        return new CategoryInteractorImpl(zomatoService);
    }

    @Provides
    @CategoryScope
    CategoryPresenter providePresenter(CategoryInteractor categoryInteractor) {
        return new CategoryPresenterImpl(categoryInteractor);
    }
}
