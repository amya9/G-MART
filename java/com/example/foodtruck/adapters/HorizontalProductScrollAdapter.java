package com.example.foodtruck.adapters;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodtruck.ProductDetailsActivity;
import com.example.foodtruck.R;
import com.example.foodtruck.models.HorizontalProductScrollModel;

import java.util.List;

public class HorizontalProductScrollAdapter extends RecyclerView.Adapter<HorizontalProductScrollAdapter.ViewHolder> {
    private List<HorizontalProductScrollModel> horizontalProductScrollModelList;

    public HorizontalProductScrollAdapter(List<HorizontalProductScrollModel> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    @NonNull
    @Override
    public HorizontalProductScrollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalProductScrollAdapter.ViewHolder holder, int position) {

        String productImageUrl = horizontalProductScrollModelList.get(position).getHorizontalProductImage();
        String productName = horizontalProductScrollModelList.get(position).getHorizontalProductName();
        String productDescription = horizontalProductScrollModelList.get(position).getHorizontalProductDescription();
        String productPrice = horizontalProductScrollModelList.get(position).getHorizontalProductPrice();
        holder.setProductData(productImageUrl, productName, productDescription, productPrice);
    }

    @Override
    public int getItemCount() {
        if (horizontalProductScrollModelList.size() > 8) {
            return 8;
        } else {
            return horizontalProductScrollModelList.size();
        }
    }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView productImage;
            private TextView productName, productDescription, productPrice;


            public ViewHolder(@NonNull final View itemView) {
                super(itemView);
                productImage = itemView.findViewById(R.id.horizontal_scroll_product_image);
                productName = itemView.findViewById(R.id.horizontal_scroll_product_name);
                productDescription = itemView.findViewById(R.id.horizontal_scroll_product_description);
                productPrice = itemView.findViewById(R.id.horizontal_scroll_product_price);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent productDetailIntent = new Intent(itemView.getContext() , ProductDetailsActivity.class);
                        itemView.getContext().startActivity(productDetailIntent);

                    }
                });

            }

            private void setProductData(String  imageUrl, String name, String description, String price ) {

                Glide.with(itemView.getContext()).load(imageUrl).apply(new RequestOptions().placeholder(R.mipmap.my_home)).into(productImage);
                productName.setText(name);
                productDescription.setText(description);
                productPrice.setText("Rs."+price+"/-");

            }
        }
    }
