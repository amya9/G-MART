package com.example.foodtruck.models;

public class SliderModel {
    private String sliderBanner;
    private String backgroundColor;

    public SliderModel(String sliderBanner, String backgroundColor) {
        this.sliderBanner = sliderBanner;
        this.backgroundColor = backgroundColor;
    }

    public String getSliderBanner() {
        return sliderBanner;
    }

    public void setSliderBanner(String  sliderBanner) {
        this.sliderBanner = sliderBanner;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
