package com.example.foodtruck.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodtruck.R;
import com.example.foodtruck.models.ProductSpecificationFeaturesModel;

import java.util.List;

public class ProductSpecificationFeaturesAdapter extends RecyclerView.Adapter<ProductSpecificationFeaturesAdapter.ViewHolder> {
    private List<ProductSpecificationFeaturesModel> productSpecificationFeaturesModelList;

    public ProductSpecificationFeaturesAdapter(List<ProductSpecificationFeaturesModel> productSpecificationFeaturesModelList) {
        this.productSpecificationFeaturesModelList = productSpecificationFeaturesModelList;
    }

    @NonNull
    @Override
    public int getItemViewType(int position) {
        switch (productSpecificationFeaturesModelList.get(position).getType()) {
            case 0:
                return ProductSpecificationFeaturesModel.PRODUCT_FEATURES_TYPE_VIEW;
            case 1:
                return ProductSpecificationFeaturesModel.PRODUCT_FEATURES_VALUE_VIEW;
            default:
                return -1;
        }
    }

    @Override
    public ProductSpecificationFeaturesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case ProductSpecificationFeaturesModel.PRODUCT_FEATURES_TYPE_VIEW:
                TextView featuresTitle = new TextView(parent.getContext());
                featuresTitle.setTypeface(null, Typeface.BOLD);
                featuresTitle.setTextColor(Color.parseColor("#000000"));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(convertDpIntoPixels(16, parent.getContext()), convertDpIntoPixels(16, parent.getContext())
                        , convertDpIntoPixels(16, parent.getContext()), convertDpIntoPixels(8, parent.getContext()));
                featuresTitle.setLayoutParams(layoutParams);
                return new ViewHolder(featuresTitle);
            case ProductSpecificationFeaturesModel.PRODUCT_FEATURES_VALUE_VIEW:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_specification_features, parent, false);
                return new ViewHolder(view);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ProductSpecificationFeaturesAdapter.ViewHolder holder, int position) {
        switch (productSpecificationFeaturesModelList.get(position).getType()) {
            case ProductSpecificationFeaturesModel.PRODUCT_FEATURES_TYPE_VIEW:
                 holder.setFeaturesTitle(productSpecificationFeaturesModelList.get(position).getProductFeaturesType());
                break;
            case ProductSpecificationFeaturesModel.PRODUCT_FEATURES_VALUE_VIEW:
                String featureName = productSpecificationFeaturesModelList.get(position).getProductFeaturesName();
                String featureValue = productSpecificationFeaturesModelList.get(position).getProductFeaturesValue();
                holder.setFeatureName(featureName);
                holder.setFeatureValue(featureValue);
                break;
            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return productSpecificationFeaturesModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView featureName, featureValue, featuresTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }

        private void setFeaturesTitle(String title) {
            featuresTitle = (TextView) itemView;
            featuresTitle.setText(title);

        }

        private void setFeatureName(String name) {
            featureName = itemView.findViewById(R.id.producr_features_name);
            featureName.setText(name);
        }

        private void setFeatureValue(String value) {
            featureValue = itemView.findViewById(R.id.product_features_value);
            featureValue.setText(value);
        }
    }

    private int convertDpIntoPixels(int dp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }
}
