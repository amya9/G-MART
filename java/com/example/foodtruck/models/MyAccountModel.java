package com.example.foodtruck.models;

public class MyAccountModel {

    public static final int MY_ACCOUNT_IMAGE_PLACEHOLDER_VIEW = 0;
    public static final int MY_ACCOUNT_BODY_CARD_VIEW = 1;
    public static final int MY_ACCOUNT_FOOTER_CARD_VIEW = 2;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    ////////////////////my account image placeholder view
    private int imagePlaceholder;
    private String myAccountName;
    private String myAccountEmail;
    private String myAccountMobileNo;

    public MyAccountModel(int type, int imagePlaceholder, String myAccountName, String myAccountEmail , String myAccountMobileNo) {
        this.type = type;
        this.imagePlaceholder = imagePlaceholder;
        this.myAccountName = myAccountName;
        this.myAccountEmail = myAccountEmail;
        this.myAccountMobileNo = myAccountMobileNo;
    }

    public int getImagePlaceholder() {
        return imagePlaceholder;
    }

    public void setImagePlaceholder(int imagePlaceholder) {
        this.imagePlaceholder = imagePlaceholder;
    }

    public String getMyAccountName() {
        return myAccountName;
    }

    public void setMyAccountName(String myAccountName) {
        this.myAccountName = myAccountName;
    }

    public String getMyAccountEmail() {
        return myAccountEmail;
    }

    public void setMyAccountEmail(String myAccountEmail) {
        this.myAccountEmail = myAccountEmail;
    }

    public String getMyAccountMobileNo() {
        return myAccountMobileNo;
    }

    public void setMyAccountMobileNo(String myAccountMobileNo) {
        this.myAccountMobileNo = myAccountMobileNo;
    }

    ////////////////////my account image placeholder view
    ////////////////////my account body card view
    private String bodyCardTitle;
    private String bodyCardViewAllLink;

    public MyAccountModel(int type, String bodyCardTitle, String bodyCardViewAllLink) {
        this.type = type;
        this.bodyCardTitle = bodyCardTitle;
        this.bodyCardViewAllLink = bodyCardViewAllLink;
    }

    public String getBodyCardTitle() {
        return bodyCardTitle;
    }

    public void setBodyCardTitle(String bodyCardTitle) {
        this.bodyCardTitle = bodyCardTitle;
    }

    public String getBodyCardViewAllLink() {
        return bodyCardViewAllLink;
    }

    public void setBodyCardViewAllLink(String bodyCardViewAllLink) {
        this.bodyCardViewAllLink = bodyCardViewAllLink;
    }
    ////////////////////my account body card view
    ////////////////////my account footer link view
    private int footerCardImage;
    private String footerCardTitle;

    public MyAccountModel(int type, int footerCardImage, String footerCardTitle) {
        this.type = type;
        this.footerCardImage = footerCardImage;
        this.footerCardTitle = footerCardTitle;
    }

    public int getFooterCardImage() {
        return footerCardImage;
    }

    public void setFooterCardImage(int footerCardImage) {
        this.footerCardImage = footerCardImage;
    }

    public String getFooterCardTitle() {
        return footerCardTitle;
    }

    public void setFooterCardTitle(String footerCardTitle) {
        this.footerCardTitle = footerCardTitle;
    }
    ////////////////////my account footer link view
}
