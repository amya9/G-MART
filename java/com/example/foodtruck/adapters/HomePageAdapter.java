package com.example.foodtruck.adapters;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.gridlayout.widget.GridLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodtruck.ProductDetailsActivity;
import com.example.foodtruck.R;
import com.example.foodtruck.ViewAllActivity;
import com.example.foodtruck.models.HomePageModel;
import com.example.foodtruck.models.HorizontalProductScrollModel;
import com.example.foodtruck.models.MyWishListModel;
import com.example.foodtruck.models.SliderModel;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomePageAdapter extends RecyclerView.Adapter {
    private List<HomePageModel> homePageModelList;
    private RecyclerView.RecycledViewPool recycledViewPool;

    public HomePageAdapter(List<HomePageModel> homePageModelList) {
        this.homePageModelList = homePageModelList;
        recycledViewPool = new RecyclerView.RecycledViewPool();
    }

    @Override
    public int getItemViewType(int position) {
        switch (homePageModelList.get(position).getType()) {
            case 0:
                return HomePageModel.bannerSlider;
            case 1:
                return HomePageModel.STRIP_AD;
            case 2:
                return HomePageModel.HORIZONTAL_SCROLL_VIEW;
            case 3:
                return HomePageModel.GRID_PRODUCT_VIEW;
            default:
                return -1;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case HomePageModel.bannerSlider:
                View bannerSliderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_pager_layout, parent, false);
                return new bannerSliderViewHolder(bannerSliderView);
            case HomePageModel.STRIP_AD:
                View stripAdView = LayoutInflater.from(parent.getContext()).inflate(R.layout.strip_ad_layout, parent, false);
                return new stripAdViewHolder(stripAdView);
            case HomePageModel.HORIZONTAL_SCROLL_VIEW:
                View horizontalScrollView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_product_layout, parent, false);
                return new horizontalScrollProductView(horizontalScrollView);
            case HomePageModel.GRID_PRODUCT_VIEW:
                View gridProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_product_layout, parent, false);
                return new gridProductViewHolder(gridProductView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (homePageModelList.get(position).getType()) {
            case HomePageModel.bannerSlider:
                List<SliderModel> sliderModelList = homePageModelList.get(position).getSliderModelList();
                ((bannerSliderViewHolder) holder).setBannerSliderPager(sliderModelList);
                break;
            case HomePageModel.STRIP_AD:
                String resources = homePageModelList.get(position).getResources();
                String color = homePageModelList.get(position).getColor();
                ((stripAdViewHolder) holder).setStripAd(resources, color);
                break;
            case HomePageModel.HORIZONTAL_SCROLL_VIEW:
                String title = homePageModelList.get(position).getHorizontalScrollTitle();
                List<MyWishListModel>viewAllProducts = homePageModelList.get(position).getViewAllProductLists();
                String layoutBackground = homePageModelList.get(position).getLayoutBackground();
                List<HorizontalProductScrollModel> horizontalProductScrollModelList = homePageModelList.get(position).getHorizontalProductScrollModelList();
                ((horizontalScrollProductView) holder).setHorizontalScrollProduct(horizontalProductScrollModelList, title, layoutBackground , viewAllProducts);
                break;
            case HomePageModel.GRID_PRODUCT_VIEW:
                String gridBackground = homePageModelList.get(position).getLayoutBackground();
                String gridProductTitle = homePageModelList.get(position).getHorizontalScrollTitle();
                List<HorizontalProductScrollModel> gridProductModelList = homePageModelList.get(position).getHorizontalProductScrollModelList();
                ((gridProductViewHolder) holder).setGridProduct(gridProductTitle, gridProductModelList, gridBackground);

            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return homePageModelList.size();
    }

    public class bannerSliderViewHolder extends RecyclerView.ViewHolder {
        private ViewPager bannerViewPager;
        private int currentPage;
        private Timer timer;
        final private int DELAY_TIME = 3000;
        final private int PERIOD_TIME = 3000;
        private List<SliderModel> arrangedList;

        public bannerSliderViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerViewPager = itemView.findViewById(R.id.bannerSlider_viewPager);


        }

        private void setBannerSliderPager(final List<SliderModel> sliderModelList) {
            currentPage = 2;
            if (timer != null) {
                timer.cancel();
            }
            arrangedList = new ArrayList<>();
            for (int x = 0; x < sliderModelList.size(); x++) {
                arrangedList.add(x, sliderModelList.get(x));
            }
            arrangedList.add(sliderModelList.get(0));
            arrangedList.add(sliderModelList.get(1));
            arrangedList.add(0, sliderModelList.get(sliderModelList.size() - 2));
            arrangedList.add(1, sliderModelList.get(sliderModelList.size() - 1));


            SliderAdapter sliderAdapter = new SliderAdapter(arrangedList);
            bannerViewPager.setClipToPadding(false);
            bannerViewPager.setPageMargin(20);
            bannerViewPager.setAdapter(sliderAdapter);
            bannerViewPager.setCurrentItem(currentPage);

            ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    currentPage = position;
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                    if (state == ViewPager.SCROLL_STATE_IDLE) {
                        pageLooper(arrangedList);
                    }
                }
            };
            bannerViewPager.addOnPageChangeListener(onPageChangeListener);

            startBannerSlideshow(arrangedList);
            bannerViewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    pageLooper(arrangedList);
                    stopBannerSlideshow();
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        startBannerSlideshow(arrangedList);
                    }

                    return false;
                }
            });
        }

        private void pageLooper(List<SliderModel> sliderModelList) {
            if (currentPage == sliderModelList.size() - 2) {
                currentPage = 2;
                bannerViewPager.setCurrentItem(currentPage, false);
            }
            if (currentPage == 1) {
                currentPage = sliderModelList.size() - 3;
                bannerViewPager.setCurrentItem(currentPage, false);
            }
        }

        private void startBannerSlideshow(final List<SliderModel> sliderModelList) {
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    if (currentPage >= sliderModelList.size()) {
                        currentPage = 1;
                    }
                    bannerViewPager.setCurrentItem(currentPage++);
                }
            };
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(runnable);
                }
            }, DELAY_TIME, PERIOD_TIME);
        }

        private void stopBannerSlideshow() {
            timer.cancel();
        }

    }

    public class stripAdViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout stripAdContainer;
        private ImageView stripAdImage;


        public stripAdViewHolder(@NonNull View itemView) {
            super(itemView);
            stripAdContainer = itemView.findViewById(R.id.stripAdContainer);
            stripAdImage = itemView.findViewById(R.id.strip_ad_image);

        }

        private void setStripAd(String resources, String color) {
            stripAdContainer.setBackgroundColor(Color.parseColor(color));
            Glide.with(itemView.getContext()).load(resources).apply(new RequestOptions().placeholder(R.mipmap.my_home))
                    .into(stripAdImage);

        }
    }

    public class horizontalScrollProductView extends RecyclerView.ViewHolder {
        private RecyclerView horizontalScrollRecyclerView;
        private TextView horizontalScrollDeals;
        private Button horizontalScrollViewAll;
        private ConstraintLayout container;

        public horizontalScrollProductView(@NonNull View itemView) {
            super(itemView);
            horizontalScrollRecyclerView = itemView.findViewById(R.id.horizontal_scroll_recyclerView);
            horizontalScrollDeals = itemView.findViewById(R.id.horizontal_scroll_dealsOfDay_tv);
            horizontalScrollViewAll = itemView.findViewById(R.id.horizontal_scroll_viewAll_btn);
            horizontalScrollRecyclerView.setRecycledViewPool(recycledViewPool);
            container = itemView.findViewById(R.id.horizontal_product_container);

        }

        private void setHorizontalScrollProduct(List<HorizontalProductScrollModel> horizontalProductScrollModelList, final String title, String layoutBackground , final List<MyWishListModel>viewAllProductsList) {
            container.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(layoutBackground)));
            horizontalScrollDeals.setText(title);
            if (horizontalProductScrollModelList.size() > 8) {
                horizontalScrollViewAll.setVisibility(View.VISIBLE);
                horizontalScrollViewAll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ViewAllActivity.myWishListModelList = viewAllProductsList;
                        Intent recyclerProductView = new Intent(itemView.getContext(), ViewAllActivity.class);
                        recyclerProductView.putExtra("title" , title);
                        recyclerProductView.putExtra("layout_code", 0);
                        itemView.getContext().startActivity(recyclerProductView);
                    }
                });
            } else {
                horizontalScrollViewAll.setVisibility(View.INVISIBLE);
            }
            LinearLayoutManager horizontalLayout = new LinearLayoutManager(itemView.getContext());
            horizontalLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
            horizontalScrollRecyclerView.setLayoutManager(horizontalLayout);


            HorizontalProductScrollAdapter horizontalProductScrollAdapter = new HorizontalProductScrollAdapter(horizontalProductScrollModelList);
            horizontalScrollRecyclerView.setAdapter(horizontalProductScrollAdapter);
            horizontalProductScrollAdapter.notifyDataSetChanged();

        }
    }

    public class gridProductViewHolder extends RecyclerView.ViewHolder {
        private TextView gridLayoutTitle;
        private GridLayout gridLayout;
        private Button gridLayoutViewAllBtn;
        private ConstraintLayout gridLayoutContainer;

        public gridProductViewHolder(@NonNull View itemView) {
            super(itemView);
            gridLayoutTitle = itemView.findViewById(R.id.grid_product_title_tv);
            gridLayout = (GridLayout) itemView.findViewById(R.id.grid_product_container);
            gridLayoutViewAllBtn = itemView.findViewById(R.id.grid_product_viewAll_btn);
            gridLayoutContainer = itemView.findViewById(R.id.gridlayout_container);
        }

        public void setGridProduct(final String gridTitle, final List<HorizontalProductScrollModel> horizontalProductScrollModelList, String gridBackground) {
            gridLayoutContainer.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(gridBackground)));
            gridLayoutTitle.setText(gridTitle);
            for (int x = 0; x < 4; x++) {
                ImageView productImage = gridLayout.getChildAt(x).findViewById(R.id.horizontal_scroll_product_image);
                TextView productName = gridLayout.getChildAt(x).findViewById(R.id.horizontal_scroll_product_name);
                TextView productDescription = gridLayout.getChildAt(x).findViewById(R.id.horizontal_scroll_product_description);
                TextView productPrice = gridLayout.getChildAt(x).findViewById(R.id.horizontal_scroll_product_price);

                Glide.with(itemView.getContext()).load(horizontalProductScrollModelList.get(x).getHorizontalProductImage())
                        .apply(new RequestOptions().placeholder(R.mipmap.my_home)).into(productImage);
                productName.setText(horizontalProductScrollModelList.get(x).getHorizontalProductName());
                productDescription.setText(horizontalProductScrollModelList.get(x).getHorizontalProductDescription());
                productPrice.setText("Rs."+horizontalProductScrollModelList.get(x).getHorizontalProductPrice()+"/-");
                gridLayout.getChildAt(x).setBackgroundColor(Color.parseColor("#ffffff"));

                gridLayout.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent productDetailsIntent = new Intent(itemView.getContext(), ProductDetailsActivity.class);
                        itemView.getContext().startActivity(productDetailsIntent);
                    }
                });
            }
            gridLayoutViewAllBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ViewAllActivity.horizontalProductScrollModelList = horizontalProductScrollModelList;
                    Intent recyclerProductView = new Intent(itemView.getContext(), ViewAllActivity.class);
                    recyclerProductView.putExtra("title" , gridTitle);
                    recyclerProductView.putExtra("layout_code", 1);
                    itemView.getContext().startActivity(recyclerProductView);
                }
            });
        }
    }


}
