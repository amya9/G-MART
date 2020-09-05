package com.example.foodtruck.adapters;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodtruck.MyOrderDetailsActivity;
import com.example.foodtruck.R;
import com.example.foodtruck.models.MyOrderModel;

import java.util.List;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {
    private List<MyOrderModel>myOrderModelList;

    public MyOrderAdapter(List<MyOrderModel> myOrderModelList) {
        this.myOrderModelList = myOrderModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_order_layout , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int image = myOrderModelList.get(position).getMyOrderProductImage();
        int rating = myOrderModelList.get(position).getMyOrderProductRating();
        String name = myOrderModelList.get(position).getMyOrderProductName();
        String status = myOrderModelList.get(position).getMyOrderProductDeliveryStatus();
        holder.setMyOrdersData(image , name , status ,  rating );

    }

    @Override
    public int getItemCount() {
        return myOrderModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView myOrderProductImage , myOrderProductDeliveryIndicator;
        private TextView myOrderProductName , myOrderProductDeliveryDetails ;
        private LinearLayout rateNowSystemContainer;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            myOrderProductImage = itemView.findViewById(R.id.myOrder_product_image_iv);
            myOrderProductName = itemView.findViewById(R.id.myOrder_product_name_tv);
            myOrderProductDeliveryDetails = itemView.findViewById(R.id.myOrder_product_delivery_date_details_tv);
            myOrderProductDeliveryIndicator = itemView.findViewById(R.id.myOrder_product_delivery_indicator);
            rateNowSystemContainer = itemView.findViewById(R.id.order_details_rate_now_stars_container_linearLayout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent orderDetailsIntent = new Intent(itemView.getContext() , MyOrderDetailsActivity.class);
                    itemView.getContext().startActivity(orderDetailsIntent);
                }
            });

        }
        private void setMyOrdersData(int image , String name , String deliveryStatus , int rating){
            myOrderProductImage.setImageResource(image);
            myOrderProductName.setText(name);
            if (deliveryStatus.equals("Cancelled")){
                myOrderProductDeliveryIndicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.errorColor)));
                myOrderProductDeliveryDetails.setText(deliveryStatus);
            }else {
                myOrderProductDeliveryIndicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.successColor)));

                myOrderProductDeliveryDetails.setText(deliveryStatus);

                /////////////////rating layout
                setRatingColor(rating);
                for (int i = 0; i<(int) rateNowSystemContainer.getChildCount() ; i++){
                    final int starPosition = i;
                    rateNowSystemContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setRatingColor(starPosition);
                        }
                    });
                }
                /////////////////rating layout
            }

        }
        private void setRatingColor(int starPos){
            for (int y= 0 ;y<rateNowSystemContainer.getChildCount() ; y++){
                ImageView starBtn = (ImageView)rateNowSystemContainer.getChildAt(y);
                starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#989898")));
                if (y<=starPos){
                    starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffff00")));
                }
            }
        }
    }
}
