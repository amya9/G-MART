package com.example.foodtruck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.foodtruck.adapters.CartItemAdapter;
import com.example.foodtruck.models.CartItemModel;

import java.util.ArrayList;
import java.util.List;

public class OrderSummeryActivity extends AppCompatActivity {
    private RecyclerView orderSummeryRecyclerView;
    private Button changeOrAddNewAddress;
    private ConstraintLayout cartBalanceLayout;
    public static final int SELECT_ADDRESS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summry);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Order Summery");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        orderSummeryRecyclerView = findViewById(R.id.order_summery_recyclerView);
        changeOrAddNewAddress = findViewById(R.id.shipping_address_change_or_add_address_btn);
        cartBalanceLayout = findViewById(R.id.cart_balance_constraint_layout);
        cartBalanceLayout.setVisibility(View.GONE);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        orderSummeryRecyclerView.setLayoutManager(layoutManager);

        List<CartItemModel> cartItemModelList = new ArrayList<>();
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
        orderSummeryRecyclerView.setAdapter(cartItemAdapter);
        cartItemAdapter.notifyDataSetChanged();

        changeOrAddNewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myAddressActivity = new Intent(OrderSummeryActivity.this , MyAddressActivity.class);
                myAddressActivity.putExtra("MODE" , SELECT_ADDRESS);
                startActivity(myAddressActivity);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}