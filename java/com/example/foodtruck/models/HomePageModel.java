package com.example.foodtruck.models;

import java.util.List;

public class HomePageModel {

    public static final int bannerSlider = 0;
    public static final int STRIP_AD = 1;
    public static final int HORIZONTAL_SCROLL_VIEW = 2;
    public static final int GRID_PRODUCT_VIEW = 3;


    private int type;
    //////////////////banner slider
    private List<SliderModel> sliderModelList;

    public HomePageModel(int type, List<SliderModel> sliderModelList) {
        this.type = type;
        this.sliderModelList = sliderModelList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<SliderModel> getSliderModelList() {
        return sliderModelList;
    }

    public void setSliderModelList(List<SliderModel> sliderModelList) {
        this.sliderModelList = sliderModelList;
    }
    //////////////////banner slider


    /////////strip ad
    private String resources;
    private String color;

    public HomePageModel(int type, String resources, String color) {
        this.type = type;
        this.resources = resources;
        this.color = color;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    /////////strip ad


    private String horizontalScrollTitle;
    private List<HorizontalProductScrollModel> horizontalProductScrollModelList;
    /////////////////grid product view all
    private List<MyWishListModel>viewAllProductLists;
    public HomePageModel(int type, String layoutBackground, String horizontalScrollTitle, List<HorizontalProductScrollModel> horizontalProductScrollModelList ,List<MyWishListModel> viewAllProductLists) {
        this.type = type;
        this.layoutBackground = layoutBackground;
        this.horizontalScrollTitle = horizontalScrollTitle;
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
        this.viewAllProductLists = viewAllProductLists;
    }

    public List<MyWishListModel> getViewAllProductLists() {
        return viewAllProductLists;
    }

    public void setViewAllProductLists(List<MyWishListModel> viewAllProductLists) {
        this.viewAllProductLists = viewAllProductLists;
    }

    private String layoutBackground;

    /////////////////horizontal scroll

    public HomePageModel(int type, String layoutBackground, String horizontalScrollTitle, List<HorizontalProductScrollModel> horizontalProductScrollModelList) {
        this.type = type;
        this.layoutBackground = layoutBackground;
        this.horizontalScrollTitle = horizontalScrollTitle;
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    public String getLayoutBackground() {
        return layoutBackground;
    }

    public void setLayoutBackground(String layoutBackground) {
        this.layoutBackground = layoutBackground;
    }

    public String getHorizontalScrollTitle() {
        return horizontalScrollTitle;
    }

    public void setHorizontalScrollTitle(String horizontalScrollTitle) {
        this.horizontalScrollTitle = horizontalScrollTitle;
    }

    public List<HorizontalProductScrollModel> getHorizontalProductScrollModelList() {
        return horizontalProductScrollModelList;
    }

    public void setHorizontalProductScrollModelList(List<HorizontalProductScrollModel> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }
    /////////////////horizontal scroll

    ////////////grid product layout
    private String gridProductTitle;
    private String gridBackground;

    public HomePageModel(int type, String gridProductTitle) {
        this.type = type;
        this.gridProductTitle = gridProductTitle;
    }

    public String getGridProductTitle() {
        return gridProductTitle;
    }

    public void setGridProductTitle(String gridProductTitle) {
        this.gridProductTitle = gridProductTitle;
    }
////////////grid product layout


}
