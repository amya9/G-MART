package com.example.foodtruck.adapters;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodtruck.R;
import com.example.foodtruck.models.MyAddressesModel;

import java.util.List;

import static com.example.foodtruck.MyAddressActivity.refreshItem;
import static com.example.foodtruck.OrderSummeryActivity.SELECT_ADDRESS;
import static com.example.foodtruck.ui.myAccount.MyAccountFragment.MANAGE_ADDRESS;

public class MyAddressesAdapter extends RecyclerView.Adapter<MyAddressesAdapter.ViewHolder> {
    private List<MyAddressesModel> myAddressesModelList;
    private int MODE;
    private int preSelectedPosition = -1;

    public MyAddressesAdapter(List<MyAddressesModel> myAddressesModelList, int MODE) {
        this.myAddressesModelList = myAddressesModelList;
        this.MODE = MODE;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_address_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String name = myAddressesModelList.get(position).getMyAddressName();
        String fullAdd = myAddressesModelList.get(position).getMyFullAddress();
        String mobNo = myAddressesModelList.get(position).getMyAddressMobNo();
        Boolean selectedAddress = myAddressesModelList.get(position).getSelectedAddress();
        holder.setAddressesData(name, fullAdd, mobNo, selectedAddress, position);
    }

    @Override
    public int getItemCount() {
        return myAddressesModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView myAddressName;
        private TextView myFullAddress;
        private TextView myAddressMobNo;
        private ImageView selectorIcon;
        private Button deliverHereBtn;
        private ImageView menuIcon;
        private LinearLayout optionContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            myAddressName = itemView.findViewById(R.id.name_in_address);
            myFullAddress = itemView.findViewById(R.id.users_address);
            myAddressMobNo = itemView.findViewById(R.id.users_mobile_number);
            selectorIcon = itemView.findViewById(R.id.address_selector_indicator_iv);
            menuIcon = itemView.findViewById(R.id.menu_icon_iv);
            optionContainer = itemView.findViewById(R.id.address_edit_container_ll);


        }

        private void setAddressesData(String name, String fullAdd, String mobNo, Boolean selectedAddress, final int position) {
            myAddressName.setText(name);
            myFullAddress.setText(fullAdd);
            myAddressMobNo.setText(mobNo);
            if (MODE == SELECT_ADDRESS) {
                selectorIcon.setImageResource(R.drawable.selected_address);
                selectorIcon.setImageTintList(ColorStateList.valueOf(Color.parseColor("#00B4FF")));
                if (selectedAddress) {
                    selectorIcon.setVisibility(View.VISIBLE);
                    preSelectedPosition = position;
                } else {
                    selectorIcon.setImageResource(R.drawable.address_not_selected);
                    selectorIcon.setImageTintList(ColorStateList.valueOf(Color.parseColor("#818080")));
                }
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (preSelectedPosition != position) {
                            myAddressesModelList.get(position).setSelectedAddress(true);
                            myAddressesModelList.get(preSelectedPosition).setSelectedAddress(false);
                            refreshItem(preSelectedPosition, position);
                            preSelectedPosition = position;
                        }
                    }
                });
            } else if (MODE == MANAGE_ADDRESS) {
                selectorIcon.setVisibility(View.GONE);
                menuIcon.setVisibility(View.VISIBLE);
                optionContainer.setVisibility(View.GONE);
                menuIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        optionContainer.setVisibility(View.VISIBLE);
                        refreshItem(preSelectedPosition ,preSelectedPosition);
                        preSelectedPosition = position;
                    }
                });

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        refreshItem(preSelectedPosition , preSelectedPosition);
                        preSelectedPosition = -1;
                    }
                });


            }
        }
    }
}
