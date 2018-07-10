package com.example.first.firstproject.category;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.first.firstproject.R;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private ArrayList<CategoryDAO> categories;
    private Context context;
    private CategoryView view;


    public CategoryAdapter(ArrayList<CategoryDAO> categories, CategoryView view) {
        this.categories = categories;
        this.view = view;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(holder);
        holder.categoryText.setText(categories.get(position).getCategoryModel().getName());
        setTextBackground(holder);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    private void setTextBackground(ViewHolder holder){
        Random r = new Random();
        int red=r.nextInt(255 - 0 + 1)+0;
        int green=r.nextInt(255 - 0 + 1)+0;
        int blue=r.nextInt(255 - 0 + 1)+0;

        GradientDrawable draw = new GradientDrawable();
        draw.setColor(Color.rgb(red,green,blue));
        holder.itemView.setBackground(draw);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CategoryModel category;
        @BindView(R.id.category_text_view)
        TextView categoryText;

        public ViewHolder(View root) {
            super(root);
            ButterKnife.bind(this, root);
        }

        @Override
        public void onClick(View view) {
            CategoryAdapter.this.view.onCategoryClicked(category);
        }
    }


}
