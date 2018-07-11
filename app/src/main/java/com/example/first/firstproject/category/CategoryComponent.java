package com.example.first.firstproject.category;
import dagger.Subcomponent;

@CategoryScope
@Subcomponent(modules = {CategoryModule.class})
public interface CategoryComponent {

    void inject(CategoryActivity categoryActivity);
}
