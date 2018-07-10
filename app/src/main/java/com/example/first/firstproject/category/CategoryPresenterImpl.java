package com.example.first.firstproject.category;

import com.example.first.firstproject.RxUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CategoryPresenterImpl implements CategoryPresenter {

    private CategoryView view;
    private CategoryInteractor categoryInteractor;
    private Disposable categorySubscription;

    public CategoryPresenterImpl(CategoryInteractor categoryInteractor) {
        this.categoryInteractor = categoryInteractor;
    }

    @Override
    public void showList() {
        view.showLoading();

        categorySubscription = categoryInteractor.getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetCategorySuccess,t -> onGetCategoryFailure());

    }

    private void onGetCategorySuccess(List<CategoryDAO> categories){
        if (isViewAttached()) {
            view.hideLoading();
            view.showList((ArrayList<CategoryDAO>) categories);
        }
    }

    private void onGetCategoryFailure(){
        //Do nothing
    }

    private boolean isViewAttached() {
        return view != null;
    }
    @Override
    public void destroy() {
        view = null;
        RxUtils.unsubscribe(categorySubscription);
    }

    @Override
    public void setView(CategoryView view) {
        this.view = view;
    }
}
