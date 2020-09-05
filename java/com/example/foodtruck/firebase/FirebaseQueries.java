package com.example.foodtruck.firebase;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.foodtruck.adapters.CategoryAdapter;
import com.example.foodtruck.adapters.HomePageAdapter;
import com.example.foodtruck.models.CategoryModel;
import com.example.foodtruck.models.HomePageModel;
import com.example.foodtruck.models.HorizontalProductScrollModel;
import com.example.foodtruck.models.MyWishListModel;
import com.example.foodtruck.models.SliderModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class FirebaseQueries {
    public static FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    public static List<CategoryModel> categoryModelList = new ArrayList<>();
//    public static List<HomePageModel> homePageModelList = new ArrayList<>();
    public static List<SliderModel> sliderModelList;

    public static List<List<HomePageModel>> mainLists = new ArrayList<>();
    public static List<String> loadedListName = new ArrayList<>();

    public static void loadCategoriesData(final CategoryAdapter categoryAdapter, final Context context) {
        firebaseFirestore.collection("GMCATEGORIES").orderBy("index").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                        categoryModelList.add(new CategoryModel(documentSnapshot.get("iconUrl").toString(), documentSnapshot.get("categoryName").toString()));
                    }
                    categoryAdapter.notifyDataSetChanged();
                } else {
                    String error = task.getException().getMessage();
                    Toast.makeText(context, error, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    ///////////////////////////load fragment in home fragment
    public static void loadHomeFragmentView(final HomePageAdapter homePageAdapter, final Context context , final int index , String categoryName) {

        firebaseFirestore.collection("GMCATEGORIES").document(categoryName)
                .collection("HOMEPAGE_ITEMS").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                                if ((long) documentSnapshot.get("view_type") == 0) {
                                    sliderModelList = new ArrayList<>();
                                    long bannerNo = (long) documentSnapshot.get("number_of_banner");
                                    for (long x = 1; x < bannerNo + 1; x++) {
                                        sliderModelList.add(new SliderModel(documentSnapshot.get("banner_" + x).toString()
                                                , documentSnapshot.get("banner_" + x + "_background").toString()));
                                    }
                                    mainLists.get(index).add(new HomePageModel(0, sliderModelList));
                                } else if ((long) documentSnapshot.get("view_type") == 1) {
                                    mainLists.get(index).add(new HomePageModel(1, documentSnapshot.get("stripAd_banner").toString()
                                            , documentSnapshot.get("stripAd_background").toString()));
                                } else if ((long) documentSnapshot.get("view_type") == 2) {
                                    List<MyWishListModel> viewAllProductLists = new ArrayList<>();
                                    List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
                                    long number_of_product = (long) documentSnapshot.get("number_of_product");
                                    for (long x = 1; x < number_of_product + 1; x++) {
                                        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(documentSnapshot.get("product_ID_" + x).toString()
                                                , documentSnapshot.get("product_image_" + x).toString()
                                                , documentSnapshot.get("product_title_" + x).toString()
                                                , documentSnapshot.get("product_description_" + x).toString()
                                                , documentSnapshot.get("product_price_" + x).toString()));
                                        viewAllProductLists.add(new MyWishListModel(documentSnapshot.get("product_image_" + x).toString()
//                                                , (long)documentSnapshot.get("offer_available_" + x)
                                                , (String) documentSnapshot.get("average_rating_" + x)
                                                , (String)documentSnapshot.get("total_rating_" + x)
                                                ,(String) documentSnapshot.get("product_full_title_" + x)
                                                ,(String) documentSnapshot.get("product_price_" + x)
                                                ,(String) documentSnapshot.get("discounted_price_" + x)));
                                    }
                                    mainLists.get(index).add(new HomePageModel(2, documentSnapshot.get("layout_background").toString()
                                            , documentSnapshot.get("layout_title").toString(), horizontalProductScrollModelList, viewAllProductLists));
                                } else if ((long) documentSnapshot.get("view_type") == 3) {
                                    List<HorizontalProductScrollModel> gridlayoutModelList = new ArrayList<>();
                                    long number_of_product = (long) documentSnapshot.get("number_of_product");
                                    for (long x = 1; x < number_of_product + 1; x++) {
                                        gridlayoutModelList.add(new HorizontalProductScrollModel(documentSnapshot.get("product_ID_" + x).toString()
                                                , documentSnapshot.get("product_image_" + x).toString()
                                                , documentSnapshot.get("product_title_" + x).toString()
                                                , documentSnapshot.get("product_description_" + x).toString()
                                                , documentSnapshot.get("product_price_" + x).toString()));
                                    }
                                    mainLists.get(index).add(new HomePageModel(3, documentSnapshot.get("layout_background").toString()
                                            , documentSnapshot.get("layout_title").toString(), gridlayoutModelList));
                                }
                                homePageAdapter.notifyDataSetChanged();
                            }
                        } else {
                            String error = task.getException().getMessage();
                            Toast.makeText(context, error, Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}
