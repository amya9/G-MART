package com.example.foodtruck;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.foodtruck.ui.home.HomeFragment;
import com.example.foodtruck.ui.myCart.MyCartFragment;
import com.example.foodtruck.ui.notification.NotificationFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static com.example.foodtruck.RegisterActivity.signUpFragment;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private FrameLayout frameLayout;
    private NavigationView navigationView;
    private ImageView actionBarLogo;
    private static final int HOME_FRAGMENT = 0;
    private static final int CART_FRAGMENT = 1;
    private static final int ORDERS_FRAGMENT = 2;
    private static final int WISHLIST_FRAGMENT = 3;
    private static final int REWARD_FRAGMENT = 4;
    private static final int ACCOUNT_FRAGMENT = 5;
    private static final int NOTIFICATION_FRAGMENT = 6;

    public static Boolean showCart = false;

    private DrawerLayout drawer;
    private int currentFragment = -1;
    private Window window;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        actionBarLogo = findViewById(R.id.action_bar_logo);
        window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.main_nav_home, R.id.main_nav_my_order, R.id.main_nav_my_reward,
                R.id.main_nav_my_cart, R.id.main_nav_my_wishList, R.id.main_nav_my_account)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.getMenu().getItem(0).setChecked(true);

        frameLayout = findViewById(R.id.main_frameLayout);
//        setFragments(new HomeFragment(), HOME_FRAGMENT);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.main_action_notification) {
            //todo
            return true;
        } else if (id == R.id.main_action_search) {
            //todo search code

            return true;
        } else if (id == R.id.main_action_cart) {
            //todo cart code
            final Dialog signInDialog = new Dialog(MainActivity.this);
            signInDialog.setCancelable(true);
            signInDialog.setContentView(R.layout.sign_in_dialog);
            signInDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT , WindowManager.LayoutParams.WRAP_CONTENT);
            Button signInBtn = signInDialog.findViewById(R.id.dialog_sign_in_btn);
            Button signUpBtn = signInDialog.findViewById(R.id.dialog_sign_up_btn);

            final Intent registerIntent = new Intent(MainActivity.this , RegisterActivity.class);
            signInBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signInDialog.dismiss();
                    signUpFragment = false;
                    startActivity(registerIntent);

                }
            });

            signUpBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signInDialog.dismiss();
                    signUpFragment = true;
                    startActivity(registerIntent);
                }
            });
            signInDialog.show();

//            myCart();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void myCart() {
        invalidateOptionsMenu();
        actionBarLogo.setVisibility(View.INVISIBLE);
        getSupportActionBar().setTitle("My Cart");
        setFragments(new MyCartFragment());
        navigationView.getMenu().getItem(3).setChecked(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    private void setFragments(Fragment fragments) {
//        currentFragment = fragmentNo;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(), fragments);
        fragmentTransaction.commit();

    }

}