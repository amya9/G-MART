package com.example.foodtruck.ui.myReward;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodtruck.R;
import com.example.foodtruck.adapters.MyRewardsAdapter;
import com.example.foodtruck.models.MyRewardsModel;

import java.util.ArrayList;
import java.util.List;


public class MyRewardFragment extends Fragment {
    private RecyclerView rewardRecyclerView;

    public MyRewardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_reward, container, false);
        rewardRecyclerView = view.findViewById(R.id.my_rewards_recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rewardRecyclerView.setLayoutManager(layoutManager);

        List<MyRewardsModel>myRewardsModelList = new ArrayList<>();
        myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
        myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
        myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
        myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
        myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
        myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
        myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
        myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
        myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
        myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
        myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
        myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
        myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
        myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
        myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
        myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));

        MyRewardsAdapter myRewardsAdapter  = new MyRewardsAdapter(myRewardsModelList , false);
        rewardRecyclerView.setAdapter(myRewardsAdapter);
        myRewardsAdapter.notifyDataSetChanged();

        return view;
    }
}