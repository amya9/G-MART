package com.example.foodtruck.ProductDetailsFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodtruck.R;
import com.example.foodtruck.adapters.ProductSpecificationFeaturesAdapter;
import com.example.foodtruck.models.ProductSpecificationFeaturesModel;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecificationFragment extends Fragment {

    public ProductSpecificationFragment() {
        // Required empty public constructor
    }

    private RecyclerView productSpecificationRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_product_specification, container, false);

        productSpecificationRecyclerView = view.findViewById(R.id.product_specification_recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        productSpecificationRecyclerView.setLayoutManager(linearLayoutManager);

        List<ProductSpecificationFeaturesModel>productSpecificationFeaturesModelList = new ArrayList<>();
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel(0, "General"));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel(0, "Display"));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));

        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel(0, "Battery"));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel(0, "Material"));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));
        productSpecificationFeaturesModelList.add(new ProductSpecificationFeaturesModel( 1 ,"RAM" , "8 GB" ));


        ProductSpecificationFeaturesAdapter productSpecificationFeaturesAdapter = new ProductSpecificationFeaturesAdapter(productSpecificationFeaturesModelList);
        productSpecificationRecyclerView.setAdapter(productSpecificationFeaturesAdapter);
        productSpecificationFeaturesAdapter.notifyDataSetChanged();

        return view;
    }
}