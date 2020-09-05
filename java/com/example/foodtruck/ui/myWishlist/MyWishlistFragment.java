package com.example.foodtruck.ui.myWishlist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodtruck.R;
import com.example.foodtruck.adapters.MyWishListAdapter;
import com.example.foodtruck.models.MyWishListModel;

import java.util.ArrayList;
import java.util.List;


public class MyWishlistFragment extends Fragment {

    private RecyclerView myWishListRecyclerView;


    public MyWishlistFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_wishlist, container, false);

        myWishListRecyclerView = view.findViewById(R.id.my_wishlist_recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        myWishListRecyclerView.setLayoutManager(layoutManager);

        List<MyWishListModel> myWishListModelList = new ArrayList<>();

        MyWishListAdapter myWishListAdapter = new MyWishListAdapter(myWishListModelList, true);
        myWishListRecyclerView.setAdapter(myWishListAdapter);
        myWishListAdapter.notifyDataSetChanged();
        return view;
    }
}