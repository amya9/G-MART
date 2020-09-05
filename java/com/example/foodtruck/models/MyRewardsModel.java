package com.example.foodtruck.models;

public class MyRewardsModel {
    private String title;
    private String rewardsValidityDate;
    private String rewardsDescription;

    public MyRewardsModel(String title, String rewardsValidityDate, String rewardsDescription) {
        this.title = title;
        this.rewardsValidityDate = rewardsValidityDate;
        this.rewardsDescription = rewardsDescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRewardsValidityDate() {
        return rewardsValidityDate;
    }

    public void setRewardsValidityDate(String rewardsValidityDate) {
        this.rewardsValidityDate = rewardsValidityDate;
    }

    public String getRewardsDescription() {
        return rewardsDescription;
    }

    public void setRewardsDescription(String rewardsDescription) {
        this.rewardsDescription = rewardsDescription;
    }
}
