package com.example.foodtruck.ui.home;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodtruck.R;
import com.example.foodtruck.adapters.CategoryAdapter;
import com.example.foodtruck.adapters.HomePageAdapter;
import com.example.foodtruck.models.HomePageModel;

import java.util.ArrayList;

import static com.example.foodtruck.firebase.FirebaseQueries.categoryModelList;

import static com.example.foodtruck.firebase.FirebaseQueries.loadCategoriesData;
import static com.example.foodtruck.firebase.FirebaseQueries.loadHomeFragmentView;
import static com.example.foodtruck.firebase.FirebaseQueries.loadedListName;
import static com.example.foodtruck.firebase.FirebaseQueries.mainLists;

public class HomeFragment extends Fragment {

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private ImageView noInternetConnection;
    private GridView myGridView;
    private HomePageAdapter homePageAdapter;

//    private List<HorizontalProductScrollModel> horizontalProductScrollModelList;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        noInternetConnection = root.findViewById(R.id.no_internet_connection);
//        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//        if (networkInfo != null && networkInfo.isConnected() == true) {
//             noInternetConnection.setVisibility(View.GONE);
//        } else {
//            Glide.with(root.getContext()).load(R.drawable.forgot_password_image).into(noInternetConnection);
//            noInternetConnection.setVisibility(View.VISIBLE);
//        }
        categoryRecyclerView = root.findViewById(R.id.category_recyclerView);
        myGridView = root.findViewById(R.id.grid_product_container);

        ////////////////////////////////categories item
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        if (categoryModelList.size() == 0) {
            loadCategoriesData(categoryAdapter, root.getContext());
        } else {
            categoryAdapter.notifyDataSetChanged();
        }
        ////////////////////////////////categories item

        /////////////////////load home fragment view
        RecyclerView homeContainerRecyclerView = root.findViewById(R.id.home_fragment_container_recyclerView);
        LinearLayoutManager testingLayout = new LinearLayoutManager(getContext());
        testingLayout.setOrientation(LinearLayoutManager.VERTICAL);
        homeContainerRecyclerView.setLayoutManager(testingLayout);
        if (mainLists.size() == 0) {
            loadedListName.add("Home");
            mainLists.add(new ArrayList<HomePageModel>());
            homePageAdapter = new HomePageAdapter(mainLists.get(0));
            loadHomeFragmentView(homePageAdapter, root.getContext(), 0 , "Home");
        } else {
            homePageAdapter = new HomePageAdapter(mainLists.get(0));
            homePageAdapter.notifyDataSetChanged();
        }
        homeContainerRecyclerView.setAdapter(homePageAdapter);


        return root;
    }
}