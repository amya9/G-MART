package com.example.foodtruck.adapters;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodtruck.ProductDetailsActivity;
import com.example.foodtruck.R;
import com.example.foodtruck.models.HorizontalProductScrollModel;

import java.util.List;

public class GridProductAdapter extends BaseAdapter {
    private int PRODUCT_NUMBER = 4;
    List<HorizontalProductScrollModel> horizontalProductScrollModelList;

    public GridProductAdapter(List<HorizontalProductScrollModel> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    @Override
    public int getCount() {
        return horizontalProductScrollModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        final View view;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout, parent, false);
            view.setElevation(0);
            view.setBackgroundColor(Color.parseColor("#ffffff"));

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDetailsIntent = new Intent(view.getContext(), ProductDetailsActivity.class);
                    view.getContext().startActivity(productDetailsIntent);
                }
            });

            ImageView productImage = view.findViewById(R.id.horizontal_scroll_product_image);
            TextView productName = view.findViewById(R.id.horizontal_scroll_product_name);
            TextView productDescription = view.findViewById(R.id.horizontal_scroll_product_description);
            TextView productPrice = view.findViewById(R.id.horizontal_scroll_product_price);

            Glide.with(view.getContext()).load(horizontalProductScrollModelList.get(position).getHorizontalProductImage())
                    .apply(new RequestOptions().placeholder(R.mipmap.my_home)).into(productImage);
            productName.setText(horizontalProductScrollModelList.get(position).getHorizontalProductName());
            productDescription.setText(horizontalProductScrollModelList.get(position).getHorizontalProductDescription());
            productPrice.setText("Rs."+horizontalProductScrollModelList.get(position).getHorizontalProductPrice()+"/-");

        } else {
            view = convertView;

        }
        return view;
    }
}
