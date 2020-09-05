package com.example.foodtruck.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodtruck.ProductDetailsActivity;
import com.example.foodtruck.R;
import com.example.foodtruck.models.MyRewardsModel;

import java.util.List;

public class MyRewardsAdapter extends RecyclerView.Adapter<MyRewardsAdapter.ViewHolder> {
    private List<MyRewardsModel> myRewardsModelList;
    private Boolean selectCouponLayout;

    public MyRewardsAdapter(List<MyRewardsModel> myRewardsModelList, Boolean selectCouponLayout) {
        this.myRewardsModelList = myRewardsModelList;
        this.selectCouponLayout = selectCouponLayout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (selectCouponLayout) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reward_dialog_item_layout, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_reward_item_layout, parent, false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = myRewardsModelList.get(position).getTitle();
        String description = myRewardsModelList.get(position).getRewardsDescription();
        String date = myRewardsModelList.get(position).getRewardsValidityDate();

        holder.setRewardsData(title, description, date);


    }

    @Override
    public int getItemCount() {
        return myRewardsModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView rewardsDate;
        private TextView rewardsDescription;
        private TextView rewardTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rewardTitle = itemView.findViewById(R.id.my_reward_title);
            rewardsDate = itemView.findViewById(R.id.my_rewards_validity_date_tv);
            rewardsDescription = itemView.findViewById(R.id.my_rewards_description);
        }

        private void setRewardsData(final String title, final String description, final String expiryDate) {
            rewardTitle.setText(title);
            rewardsDescription.setText(description);
            rewardsDate.setText(expiryDate);

            if (selectCouponLayout) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        ProductDetailsActivity.couponTitle.setText(title);
                      ProductDetailsActivity.couponBody.setText(description);
                       ProductDetailsActivity.couponExpiryDate.setText(expiryDate);
                      ProductDetailsActivity.setVisible();
                    }
                });

            }

        }
    }
}
