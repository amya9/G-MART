package com.example.foodtruck.models;

public class ProductSpecificationFeaturesModel {

    public static final int PRODUCT_FEATURES_TYPE_VIEW = 0;
    public static final int PRODUCT_FEATURES_VALUE_VIEW = 1;
    public int type;

    public ProductSpecificationFeaturesModel(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private String productFeaturesName;
    private String productFeaturesValue;

    //////////////////product feature type
    private  String productFeaturesType;
    public ProductSpecificationFeaturesModel(int type, String productFeaturesType) {
        this.type = type;
        this.productFeaturesType = productFeaturesType;
    }
    public String getProductFeaturesType() {
        return productFeaturesType;
    }
    public void setProductFeaturesType(String productFeaturesType) {
        this.productFeaturesType = productFeaturesType;
    }
    //////////////////product feature type

    //////////////////product feature value
    public ProductSpecificationFeaturesModel(int type, String productFeaturesName, String productFeaturesValue) {
        this.type = type;
        this.productFeaturesName = productFeaturesName;
        this.productFeaturesValue = productFeaturesValue;
    }
    public String getProductFeaturesName() {
        return productFeaturesName;
    }
    public void setProductFeaturesName(String productFeaturesName) {
        this.productFeaturesName = productFeaturesName;
    }
    public String getProductFeaturesValue() {
        return productFeaturesValue;
    }
    public void setProductFeaturesValue(String productFeaturesValue) {
        this.productFeaturesValue = productFeaturesValue;
    }
    //////////////////product feature value

}
