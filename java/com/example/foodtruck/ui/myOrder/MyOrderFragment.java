package com.example.foodtruck.ui.myOrder;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.foodtruck.R;
import com.example.foodtruck.adapters.MyOrderAdapter;
import com.example.foodtruck.models.MyOrderModel;

import java.util.ArrayList;
import java.util.List;

public class MyOrderFragment extends Fragment {
    private RecyclerView myOrderRecyclerView;


    public MyOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_order, container, false);

        myOrderRecyclerView = view.findViewById(R.id.my_order_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        myOrderRecyclerView.setLayoutManager(layoutManager);

        List<MyOrderModel>myOrderModelList = new ArrayList<>();
        myOrderModelList.add(new MyOrderModel(R.drawable.phone ,4 ,  "Redmi A1(Crystal Blue)" , "Cancelled"));
        myOrderModelList.add(new MyOrderModel(R.drawable.phone , 4 ,"Redmi A1(Crystal Blue)" , "Delivered on Mon , 21 June 2021"));
        myOrderModelList.add(new MyOrderModel(R.drawable.phone , 2 ,"Redmi A1(Crystal Blue)" , "Delivered on Mon , 21 June 2021"));
        myOrderModelList.add(new MyOrderModel(R.drawable.phone ,1 , "Redmi A1(Crystal Blue)" , "Cancelled"));
        myOrderModelList.add(new MyOrderModel(R.drawable.phone , 5 ,"Redmi A1(Crystal Blue)" , "Delivered on Mon , 21 June 2021"));
        myOrderModelList.add(new MyOrderModel(R.drawable.phone , 3 ,"Redmi A1(Crystal Blue)" , "Delivered on Mon , 21 June 2021"));
        myOrderModelList.add(new MyOrderModel(R.drawable.phone , 5 ,"Redmi A1(Crystal Blue)" , "Cancelled"));
        myOrderModelList.add(new MyOrderModel(R.drawable.phone , 2 ,"Redmi A1(Crystal Blue)" , "Delivered on Mon , 21 June 2021"));
        myOrderModelList.add(new MyOrderModel(R.drawable.phone , 4 ,"Redmi A1(Crystal Blue)" , "Delivered on Mon , 21 June 2021"));
        myOrderModelList.add(new MyOrderModel(R.drawable.phone , 1 ,"Redmi A1(Crystal Blue)" , "Delivered on Mon , 21 June 2021"));
        myOrderModelList.add(new MyOrderModel(R.drawable.phone , 3 , "Redmi A1(Crystal Blue)" , "Cancelled"));

        MyOrderAdapter myOrderAdapter = new MyOrderAdapter(myOrderModelList);
        myOrderRecyclerView.setAdapter(myOrderAdapter);
        myOrderAdapter.notifyDataSetChanged();




        return view;
    }


}