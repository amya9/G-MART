package com.example.foodtruck.models;

public class HorizontalProductScrollModel {

    private String horizontalProductId;
    private String horizontalProductName;  ;
    private String horizontalProductDescription;
    private String horizontalProductPrice;
    private String horizontalProductImage;


    public HorizontalProductScrollModel(String horizontalProductId , String horizontalProductImage, String horizontalProductName, String horizontalProductDescription, String horizontalProductPrice) {
        this.horizontalProductId = horizontalProductId;
        this.horizontalProductImage = horizontalProductImage;
        this.horizontalProductName = horizontalProductName;
        this.horizontalProductDescription = horizontalProductDescription;
        this.horizontalProductPrice = horizontalProductPrice;
    }


    public String getHorizontalProductId() {
        return horizontalProductId;
    }

    public void setHorizontalProductId(String horizontalProductId) {
        this.horizontalProductId = horizontalProductId;
    }

    public String getHorizontalProductImage() {
        return horizontalProductImage;
    }

    public void setHorizontalProductImage(String horizontalProductImage) {
        this.horizontalProductImage = horizontalProductImage;
    }

    public String getHorizontalProductName() {
        return horizontalProductName;
    }

    public void setHorizontalProductName(String horizontalProductName) {
        this.horizontalProductName = horizontalProductName;
    }

    public String getHorizontalProductDescription() {
        return horizontalProductDescription;
    }

    public void setHorizontalProductDescription(String horizontalProductDescription) {
        this.horizontalProductDescription = horizontalProductDescription;
    }

    public String getHorizontalProductPrice() {
        return horizontalProductPrice;
    }

    public void setHorizontalProductPrice(String horizontalProductPrice) {
        this.horizontalProductPrice = horizontalProductPrice;
    }
}
