package com.example.foodtruck.ui.myCart;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.foodtruck.OrderSummeryActivity;
import com.example.foodtruck.R;
import com.example.foodtruck.adapters.CartItemAdapter;
import com.example.foodtruck.models.CartItemModel;

import java.util.ArrayList;
import java.util.List;

public class MyCartFragment extends Fragment {
    private RecyclerView cartRecyclerView;
    private Button continueToOrderSummery;


    public MyCartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view;
        view =  inflater.inflate(R.layout.fragment_my_cart, container, false);
        continueToOrderSummery = view.findViewById(R.id.continue_to_checkout_btn);


        cartRecyclerView = view.findViewById(R.id.my_cart_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        cartRecyclerView.setLayoutManager(layoutManager);

        List<CartItemModel>cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0 , R.drawable.phone , 2 , 1 , 3 , 4 , "One plus Nord" , "Rs.49,999/-" ,"Rs.28,999/-"));
        cartItemModelList.add(new CartItemModel(0 , R.drawable.phone , 2 , 1 , 3 , 4 , "One plus Nord" , "Rs.49,999/-" ,"Rs.28,999/-"));
        cartItemModelList.add(new CartItemModel(0 , R.drawable.phone , 2 , 1 , 3 , 4 , "One plus Nord" , "Rs.49,999/-" ,"Rs.28,999/-"));
        cartItemModelList.add(new CartItemModel(0 , R.drawable.phone , 2 , 1 , 3 , 4 , "One plus Nord" , "Rs.49,999/-" ,"Rs.28,999/-"));
        cartItemModelList.add(new CartItemModel(0 , R.drawable.phone , 2 , 1 , 3 , 4 , "One plus Nord" , "Rs.49,999/-" ,"Rs.28,999/-"));
        cartItemModelList.add(new CartItemModel(0 , R.drawable.phone , 2 , 1 , 3 , 4 , "One plus Nord" , "Rs.49,999/-" ,"Rs.28,999/-"));
        cartItemModelList.add(new CartItemModel(0 , R.drawable.phone , 2 , 1 , 3 , 4 , "One plus Nord" , "Rs.49,999/-" ,"Rs.28,999/-"));
        cartItemModelList.add(new CartItemModel(0 , R.drawable.phone , 2 , 1 , 3 , 4 , "One plus Nord" , "Rs.49,999/-" ,"Rs.28,999/-"));
        cartItemModelList.add(new CartItemModel(0 , R.drawable.phone , 2 , 1 , 3 , 4 , "One plus Nord" , "Rs.49,999/-" ,"Rs.28,999/-"));
        cartItemModelList.add(new CartItemModel(0 , R.drawable.phone , 2 , 1 , 3 , 4 , "One plus Nord" , "Rs.49,999/-" ,"Rs.28,999/-"));

        cartItemModelList.add(new CartItemModel(1 , "5", "Rs.45,000/-" , "Rs.50/-" ,"Rs.8,999/-" , ""));



        CartItemAdapter cartItemAdapter = new CartItemAdapter(cartItemModelList);
        cartRecyclerView.setAdapter(cartItemAdapter);
        cartItemAdapter.notifyDataSetChanged();


        continueToOrderSummery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderSummeryIntent = new Intent(view.getContext() , OrderSummeryActivity.class);
                view.getContext().startActivity(orderSummeryIntent);
            }
        });


        return view;
    }


}