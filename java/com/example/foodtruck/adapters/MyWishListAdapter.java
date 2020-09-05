package com.example.foodtruck.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodtruck.ProductDetailsActivity;
import com.example.foodtruck.R;
import com.example.foodtruck.models.MyWishListModel;

import java.util.List;

public class MyWishListAdapter extends RecyclerView.Adapter<MyWishListAdapter.ViewHolder> {
    private List<MyWishListModel> myWishListModelList;
    private Boolean comesFromWishList;

    public MyWishListAdapter(List<MyWishListModel> myWishListModelList, Boolean comesFromWishList) {
        this.myWishListModelList = myWishListModelList;
        this.comesFromWishList = comesFromWishList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_wishlist_product_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String image = myWishListModelList.get(position).getProductImage();
        String name = myWishListModelList.get(position).getProductName();
        String oPrice = myWishListModelList.get(position).getProductOriginalPrice();
        String dPrice = myWishListModelList.get(position).getProductDiscountedPrice();
//        long offerNum = myWishListModelList.get(position).getOffersNumber();
        String avgRating = myWishListModelList.get(position).getAverageRating();
        String totalRating = myWishListModelList.get(position).getTotalRating();

        holder.setWishListData(image, name, oPrice, dPrice, avgRating , totalRating);

    }

    @Override
    public int getItemCount() {
        return myWishListModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView myWishListProductImage;
        private ImageView myWishListProductCouponsIndicator;
        private TextView myWishListProductName;
        private TextView myWishListProductOriginalPrice;

        private TextView myWishListProductRating;
        private TextView myWishListProductTotalRating;

        private TextView myWishListProductDiscountedPrice;
        private TextView myWishListProductOffersAppliedText;
        private LinearLayout removeBtnContainer;
        private LinearLayout myWishListProductMoveToCart;
        private LinearLayout myWishListProductRemoveItem;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            myWishListProductImage = itemView.findViewById(R.id.my_wishlist_product_image_tv);
            myWishListProductCouponsIndicator = itemView.findViewById(R.id.my_wishlist_product_offers_indicator_iv);
            myWishListProductName = itemView.findViewById(R.id.my_wishlist_product_name_tv);
            myWishListProductOriginalPrice = itemView.findViewById(R.id.my_wishlist_product_original_price_tv);
            myWishListProductDiscountedPrice = itemView.findViewById(R.id.my_wishlist_product_discounted_price_tv);
            myWishListProductOffersAppliedText = itemView.findViewById(R.id.my_wishlist_product_offers_tv);

            myWishListProductRating = itemView.findViewById(R.id.product_mini_product_rating_tv);
            myWishListProductTotalRating = itemView.findViewById(R.id.product_mini_view_total_rating);

            removeBtnContainer = itemView.findViewById(R.id.my_wishlist_remove_ll);
            myWishListProductMoveToCart = itemView.findViewById(R.id.my_wishlist_move_to_cart);
            myWishListProductRemoveItem = itemView.findViewById(R.id.cart_move_product_from_cart_btn);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDetailsIntent = new Intent(itemView.getContext(), ProductDetailsActivity.class);
                    itemView.getContext().startActivity(productDetailsIntent);
                }
            });
        }

        private void setWishListData(String image, String Name, String originalPrice, String discountPrice
                                                   ,  String  avgRating, String totalRating) {
            Glide.with(itemView.getContext()).load(image).apply(new RequestOptions().placeholder(R.mipmap.my_home)).into(myWishListProductImage);
            myWishListProductRating.setText( avgRating);

            myWishListProductTotalRating.setText("("+ totalRating+")ratings");
            myWishListProductName.setText(Name);
            myWishListProductOriginalPrice.setText("Rs."+originalPrice+"/-");
            myWishListProductDiscountedPrice.setText("Rs."+discountPrice+"/-");
//            if (offerNo > 0) {
//                myWishListProductCouponsIndicator.setVisibility(View.VISIBLE);
//                myWishListProductOffersAppliedText.setVisibility(View.VISIBLE);
//                if (offerNo == 1) {
//                    myWishListProductOffersAppliedText.setText(offerNo + " offer available");
//                } else {
//                    myWishListProductOffersAppliedText.setText(offerNo + " offers available");
//
//                }
//            } else {
//                myWishListProductCouponsIndicator.setVisibility(View.INVISIBLE);
//                myWishListProductOffersAppliedText.setVisibility(View.INVISIBLE);
//            }
            ////linear layout container visibility
            if (comesFromWishList) {
                removeBtnContainer.setVisibility(View.VISIBLE);
            } else {
                removeBtnContainer.setVisibility(View.GONE);
            }

            myWishListProductRemoveItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Delete item from wishList", Toast.LENGTH_LONG).show();
                }
            });
            myWishListProductMoveToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Moved to Cart", Toast.LENGTH_LONG).show();

                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDetailsIntent = new Intent(itemView.getContext(), ProductDetailsActivity.class);
                    itemView.getContext().startActivity(productDetailsIntent);
                }
            });

        }
    }
}
