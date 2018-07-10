package com.example.first.firstproject.category;

import java.util.List;
import io.reactivex.Observable;

public interface CategoryInteractor {

    Observable<List<CategoryDAO>> getCategories();
}
