package com.example.foodtruck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import com.example.foodtruck.adapters.GridProductAdapter;
import com.example.foodtruck.adapters.MyWishListAdapter;
import com.example.foodtruck.models.HorizontalProductScrollModel;
import com.example.foodtruck.models.MyWishListModel;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {
    private RecyclerView viewAllRecyclerView;
    private GridView viewAllGridView;
    public static List<HorizontalProductScrollModel>horizontalProductScrollModelList;
    public static List<MyWishListModel> myWishListModelList ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(getIntent().getStringExtra("title"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        int layoutCode = getIntent().getIntExtra("layout_code", -1);
        if (layoutCode == 0) {
            /////////////////////////////////////recycler view
            viewAllRecyclerView = findViewById(R.id.view_all_recyclerView);
            viewAllRecyclerView.setVisibility(View.VISIBLE);

            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            viewAllRecyclerView.setLayoutManager(layoutManager);

            MyWishListAdapter myWishListAdapter = new MyWishListAdapter(myWishListModelList, false);
            viewAllRecyclerView.setAdapter(myWishListAdapter);
            myWishListAdapter.notifyDataSetChanged();
            ///////////////////////////////////////////////recycler view
        } else if (layoutCode == 1) {
            /////////////////////////////////grid view
            viewAllGridView = findViewById(R.id.view_all_grid_view);
            viewAllGridView.setVisibility(View.VISIBLE);

            GridProductAdapter gridProductAdapter = new GridProductAdapter(horizontalProductScrollModelList);
            viewAllGridView.setAdapter(gridProductAdapter);
            gridProductAdapter.notifyDataSetChanged();
            /////////////////////////////////grid view
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}