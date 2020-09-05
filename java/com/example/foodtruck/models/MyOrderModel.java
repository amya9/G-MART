package com.example.foodtruck.models;

public class MyOrderModel {

    private int myOrderProductImage;
    private int myOrderProductRating;
    private String myOrderProductName;
    private String myOrderProductDeliveryStatus;

    public MyOrderModel(int myOrderProductImage, int myOrderProductRating, String myOrderProductName, String myOrderProductDeliveryStatus) {
        this.myOrderProductImage = myOrderProductImage;
        this.myOrderProductRating = myOrderProductRating;
        this.myOrderProductName = myOrderProductName;
        this.myOrderProductDeliveryStatus = myOrderProductDeliveryStatus;
    }

    public int getMyOrderProductImage() {
        return myOrderProductImage;
    }

    public void setMyOrderProductImage(int myOrderProductImage) {
        this.myOrderProductImage = myOrderProductImage;
    }

    public int getMyOrderProductRating() {
        return myOrderProductRating;
    }

    public void setMyOrderProductRating(int myOrderProductRating) {
        this.myOrderProductRating = myOrderProductRating;
    }

    public String getMyOrderProductName() {
        return myOrderProductName;
    }

    public void setMyOrderProductName(String myOrderProductName) {
        this.myOrderProductName = myOrderProductName;
    }

    public String getMyOrderProductDeliveryStatus() {
        return myOrderProductDeliveryStatus;
    }

    public void setMyOrderProductDeliveryStatus(String myOrderProductDeliveryStatus) {
        this.myOrderProductDeliveryStatus = myOrderProductDeliveryStatus;
    }
}
