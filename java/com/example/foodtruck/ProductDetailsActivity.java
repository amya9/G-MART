package com.example.foodtruck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.foodtruck.adapters.MyRewardsAdapter;
import com.example.foodtruck.adapters.ProductImageAdapter;
import com.example.foodtruck.adapters.productDescriptionViewPagerAdapter;
import com.example.foodtruck.models.MyRewardsModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {

    private ViewPager productImageViewPager;
    private TabLayout productImageIndicator;
    private FloatingActionButton addToWishList;
    public static boolean ADDED_TO_WISHLIST = false;
    private  TabLayout productDescriptionTabLayout;
    private ViewPager productDescriptionViewPager;
    private LinearLayout rateNowSystemContainer;
    private Button buyNowBtn;
    private Button redeemCouponBtn;

    /////////////////reward dialog
    public static TextView couponTitle;
    public static TextView couponBody;
    public static TextView couponExpiryDate;
    private static RecyclerView couponContainerRecyclerView;
    private static LinearLayout priceContainerLinearLayout;
    /////////////////reward dialog

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String productName = getIntent().getStringExtra("ProductName");
        getSupportActionBar().setTitle(productName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productImageViewPager = findViewById(R.id.product_image_viewPager);
        productImageIndicator = findViewById(R.id.product_image_tabLayout);
        addToWishList = findViewById(R.id.add_product_to_wishList);

        productDescriptionTabLayout = findViewById(R.id.product_description_tabLayout);
        productDescriptionViewPager = findViewById(R.id.product_description_viewPager);

        List<Integer>productImages = new ArrayList<>();
        productImages.add(R.drawable.product);
        productImages.add(R.mipmap.app_icon);
        productImages.add(R.mipmap.cart_black);
        productImages.add(R.mipmap.my_account);
        productImages.add(R.mipmap.my_account_signout);
        productImages.add(R.drawable.product);
        productImages.add(R.drawable.product);
        ProductImageAdapter productImageAdapter = new ProductImageAdapter(productImages);
        productImageViewPager.setAdapter(productImageAdapter);

        productImageIndicator.setupWithViewPager(productImageViewPager , true);


        addToWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ADDED_TO_WISHLIST){
                    ADDED_TO_WISHLIST = false;
                    addToWishList.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#989898")));
                }else {
                    ADDED_TO_WISHLIST = true;
                    addToWishList.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#ce0000")));

                }

            }
        });
        buyNowBtn = findViewById(R.id.buy_now_btn);
        buyNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderSummeryIntent = new Intent(ProductDetailsActivity.this , OrderSummeryActivity.class);
                startActivity(orderSummeryIntent);
            }
        });
        ///////////////////////////////reward Dialog
        redeemCouponBtn = findViewById(R.id.product_coupon_redeem_btn);
        redeemCouponBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog rewardDialog = new Dialog(ProductDetailsActivity.this);
                rewardDialog.setContentView(R.layout.reward_dialog);
                rewardDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rewardDialog.setCancelable(true);
                ImageView hamIcon = rewardDialog.findViewById(R.id.coupon_dialog_ham_menu_icon);
                 couponContainerRecyclerView = rewardDialog.findViewById(R.id.coupon_dialog_recyclerview);
                TextView originalPrice = rewardDialog.findViewById(R.id.coupon_dialog_originalprice);
                TextView discountedPrice = rewardDialog.findViewById(R.id.coupon_dialog_price_after_coupon_applied);
                 priceContainerLinearLayout = rewardDialog.findViewById(R.id.coupon_dialog_coupon_desc_ll);
                 couponTitle = rewardDialog.findViewById(R.id.my_reward_title);
                 couponBody = rewardDialog.findViewById(R.id.my_rewards_description);
                 couponExpiryDate = rewardDialog.findViewById(R.id.my_rewards_validity_date_tv);


                LinearLayoutManager layoutManager = new LinearLayoutManager(ProductDetailsActivity.this);
                layoutManager.setOrientation(RecyclerView.VERTICAL);
                couponContainerRecyclerView.setLayoutManager(layoutManager);
                List<MyRewardsModel>myRewardsModelList = new ArrayList<>();
                myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
                myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
                myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
                myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
                myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
                myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
                myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));
               myRewardsModelList.add(new MyRewardsModel("Cashback" , "till 3rd, August 2018" , "GET 20% OFF on any product above Rs.500/- and below Rs.2500/-"));

                MyRewardsAdapter myRewardsAdapter  = new MyRewardsAdapter(myRewardsModelList , true);
                couponContainerRecyclerView.setAdapter(myRewardsAdapter);
                myRewardsAdapter.notifyDataSetChanged();

                hamIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                           setVisible();
                    }
                });
                rewardDialog.show();
            }
        });
        

        ///////////////////////////////reward Dialog


        productDescriptionViewPager.setAdapter(new productDescriptionViewPagerAdapter(getSupportFragmentManager() ,productDescriptionTabLayout.getTabCount() ));
        productDescriptionViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDescriptionTabLayout));
        productDescriptionTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDescriptionViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        /////////////////rating layout
        rateNowSystemContainer = findViewById(R.id.rate_now_stars_container_linearLayout);
        for (int i = 0; i<rateNowSystemContainer.getChildCount() ; i++){
            final int starPosition = i;
            rateNowSystemContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setRatingColor(starPosition);
                }
            });
        }
        /////////////////rating layout
    }

    public static void setVisible() {
        if (couponContainerRecyclerView.getVisibility() == View.GONE){
            couponContainerRecyclerView.setVisibility(View.VISIBLE);
            priceContainerLinearLayout.setVisibility(View.GONE);
        }else {
            couponContainerRecyclerView.setVisibility(View.GONE);
            priceContainerLinearLayout.setVisibility(View.VISIBLE);
        }
    }

    private void setRatingColor(int starPos){
        for (int y= 0 ;y<rateNowSystemContainer.getChildCount() ; y++){
            ImageView starBtn = (ImageView)rateNowSystemContainer.getChildAt(y);
            starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#989898")));
            if (y<=starPos){
                starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffff00")));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_cart_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
            return true;
        }else if (id == R.id.main_action_search){
            //todo search code
            return true;
        }else if (id == R.id.main_action_cart){
            //todo cart code
//            Intent cartIntent = new Intent(ProductDetailsActivity.this , MainActivity.class);
//            showCart = true;
//            startActivity(cartIntent);
//            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}