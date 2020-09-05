package com.example.foodtruck.ui.myAccount;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.foodtruck.MyAddressActivity;
import com.example.foodtruck.R;


public class MyAccountFragment extends Fragment {
    public static final int MANAGE_ADDRESS = 1;

    private ImageView accountSetting;
    private LinearLayout accountSettingContainer;

    private LinearLayout logoutFromAppContainer;
    private LinearLayout logoutFromAll;
    private LinearLayout notificationPreferences;

    private TextView viewAllAddresses;
    private TextView viewAllOrders;

    public MyAccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_my_account, container, false);

        accountSetting = view.findViewById(R.id.my_account_setting_iv);
        accountSettingContainer = view.findViewById(R.id.my_account_setting_container_linearlayout);
        logoutFromAppContainer = view.findViewById(R.id.my_account_logout_from_app_container_linearlayout);
        logoutFromAll = view.findViewById(R.id.my_account_logout_from_all_container_linearlayout);
        notificationPreferences = view.findViewById(R.id.my_account_notification_container_linearlayout);
        viewAllOrders = view.findViewById(R.id.my_account_body_card_viewAll_orders_links_tv);
        viewAllAddresses = view.findViewById(R.id.my_account_body_card_viewAll_addresses_links_tv);

        viewAllAddresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent manageAddressIntent = new Intent(getContext() , MyAddressActivity.class);
                manageAddressIntent.putExtra("MODE" , MANAGE_ADDRESS);
                view.getContext().startActivity(manageAddressIntent);
            }
        });




        return view;
    }
}