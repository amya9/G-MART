package com.example.foodtruck.models;

public class CartItemModel {

    public static final int CART_ITEM_VIEW = 0;
    public static  final int BALANCE_DETAILS_VIEW = 1;

    private int type;
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    ////////////////cart item view
    private int cartProductImage;
    private int freeCouponNumber;
    private int freeCouponsApplied;
    private int offersApplied;
    private int  productQuantity;
    private String cartProductName;
    private String originalProductPrice;
    private String  discountedProductPrice;

    public CartItemModel(int type, int cartProductImage, int freeCouponNumber, int freeCouponsApplied, int offersApplied, int productQuantity, String cartProductName, String originalProductPrice, String discountedProductPrice) {
        this.type = type;
        this.cartProductImage = cartProductImage;
        this.freeCouponNumber = freeCouponNumber;
        this.freeCouponsApplied = freeCouponsApplied;
        this.offersApplied = offersApplied;
        this.productQuantity = productQuantity;
        this.cartProductName = cartProductName;
        this.originalProductPrice = originalProductPrice;
        this.discountedProductPrice = discountedProductPrice;
    }
    public int getCartProductImage() {
        return cartProductImage;
    }
    public void setCartProductImage(int cartProductImage) {
        this.cartProductImage = cartProductImage;
    }
    public int getFreeCouponNumber() {
        return freeCouponNumber;
    }
    public void setFreeCouponNumber(int freeCouponNumber) {
        this.freeCouponNumber = freeCouponNumber;
    }
    public int getFreeCouponsApplied() {
        return freeCouponsApplied;
    }
    public void setFreeCouponsApplied(int freeCouponsApplied) {
        this.freeCouponsApplied = freeCouponsApplied;
    }
    public int getOffersApplied() {
        return offersApplied;
    }
    public void setOffersApplied(int offersApplied) {
        this.offersApplied = offersApplied;
    }
    public int getProductQuantity() {
        return productQuantity;
    }
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
    public String getCartProductName() {
        return cartProductName;
    }
    public void setCartProductName(String cartProductName) {
        this.cartProductName = cartProductName;
    }
    public String getOriginalProductPrice() {
        return originalProductPrice;
    }
    public void setOriginalProductPrice(String originalProductPrice) {
        this.originalProductPrice = originalProductPrice;
    }
    public String getDiscountedProductPrice() {
        return discountedProductPrice;
    }
    public void setDiscountedProductPrice(String discountedProductPrice) {
        this.discountedProductPrice = discountedProductPrice;
    }
    ////////////////cart item view


    ////////////////balance details view
    private String totalItem;
    private String singleProductPrice;
    private String deliveryCharge;
    private String amountSaved;
    private String totalBalance;

    public CartItemModel(int type, String totalItem, String singleProductPrice, String deliveryCharge, String amountSaved, String totalBalance) {
        this.type = type;
        this.totalItem = totalItem;
        this.singleProductPrice = singleProductPrice;
        this.deliveryCharge = deliveryCharge;
        this.amountSaved = amountSaved;
        this.totalBalance = totalBalance;
    }

    public String getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(String totalItem) {
        this.totalItem = totalItem;
    }

    public String getSingleProductPrice() {
        return singleProductPrice;
    }

    public void setSingleProductPrice(String singleProductPrice) {
        this.singleProductPrice = singleProductPrice;
    }

    public String getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(String deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public String getAmountSaved() {
        return amountSaved;
    }

    public void setAmountSaved(String amountSaved) {
        this.amountSaved = amountSaved;
    }

    public String getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(String totalBalance) {
        this.totalBalance = totalBalance;
    }
    ////////////////balance details view

}
