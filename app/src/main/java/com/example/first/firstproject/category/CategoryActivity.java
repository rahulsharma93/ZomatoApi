package com.example.first.firstproject.category;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import com.example.first.firstproject.FirstApplication;
import com.example.first.firstproject.R;
import java.util.ArrayList;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends AppCompatActivity implements CategoryView {

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.category_recycler_view)
    RecyclerView categoryRecyclerView;

    private CategoryAdapter categoryAdapter;

    @Inject
    CategoryPresenter categoryPresenter;

    private ArrayList<CategoryDAO> categoryModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);
        FirstApplication.get(this).createCategoryComponent().inject(this);
        init();
       // categoryPresenter = new CategoryPresenterImpl(new CategoryInteractorImpl(FirstApplication.get(this).getZomatoService()));
        categoryPresenter.setView(this);
        categoryPresenter.showList();

    }

    private void init(){
        categoryRecyclerView.setHasFixedSize(true);
        categoryAdapter = new CategoryAdapter(categoryModelArrayList, this);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showList(ArrayList<CategoryDAO> categoryModelArrayList) {
        this.categoryModelArrayList.clear();
        this.categoryModelArrayList.addAll(categoryModelArrayList);
        categoryAdapter.notifyDataSetChanged();
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onCategoryClicked(CategoryModel category) {


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        categoryPresenter.destroy();
    }
}
