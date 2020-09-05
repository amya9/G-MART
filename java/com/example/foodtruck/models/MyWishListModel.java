package com.example.foodtruck.models;

public class MyWishListModel {
    private String productImage;
    private long offersNumber;
    private String averageRating;
    private String totalRating;
    private String productName;
    private String productOriginalPrice;
    private String productDiscountedPrice;

    public MyWishListModel(String productImage,  String averageRating, String totalRating, String productName, String productOriginalPrice, String productDiscountedPrice) {
        this.productImage = productImage;
//        this.offersNumber = offersNumber;
        this.averageRating = averageRating;
        this.totalRating = totalRating;
        this.productName = productName;
        this.productOriginalPrice = productOriginalPrice;
        this.productDiscountedPrice = productDiscountedPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public long getOffersNumber() {
        return offersNumber;
    }

    public void setOffersNumber(long offersNumber) {
        this.offersNumber = offersNumber;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    public String getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(String totalRating) {
        this.totalRating = totalRating;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductOriginalPrice() {
        return productOriginalPrice;
    }

    public void setProductOriginalPrice(String productOriginalPrice) {
        this.productOriginalPrice = productOriginalPrice;
    }

    public String getProductDiscountedPrice() {
        return productDiscountedPrice;
    }

    public void setProductDiscountedPrice(String productDiscountedPrice) {
        this.productDiscountedPrice = productDiscountedPrice;
    }
}
