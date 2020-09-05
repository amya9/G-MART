package com.example.foodtruck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.foodtruck.adapters.MyAddressesAdapter;
import com.example.foodtruck.models.MyAddressesModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.foodtruck.OrderSummeryActivity.SELECT_ADDRESS;

public class MyAddressActivity extends AppCompatActivity {
    private LinearLayout addNewAddress;
    private RecyclerView savedAddressesRecyclerView;
    private Button deliverHere;
    public static  MyAddressesAdapter myAddressesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Select Address (9)");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        deliverHere = findViewById(R.id.deliver_here_btn);
        deliverHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderSummeryIntent = new Intent(MyAddressActivity.this , OrderSummeryActivity.class);
                startActivity(orderSummeryIntent);
            }
        });
        savedAddressesRecyclerView = findViewById(R.id.saved_address_recycler_view);
        addNewAddress = findViewById(R.id.add_new_address_linearLayout);
        addNewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addNewAddressIntent = new Intent(MyAddressActivity.this , AddNewAddressActivity.class);
                startActivity(addNewAddressIntent);
            }
        });


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        savedAddressesRecyclerView.setLayoutManager(layoutManager);
        List<MyAddressesModel> myAddressesModelList = new ArrayList<>();
        myAddressesModelList.add(new MyAddressesModel("Amit kumar" , "Bhawanipur , purainiya , darpa thana , near narkatiya bazae , east champaran , bihar , 845301" , "8789341233" , true));
        myAddressesModelList.add(new MyAddressesModel("Sumit kumar" , "Bhawanipur , purainiya , darpa thana , near narkatiya bazae , east champaran , bihar , 845301" , "8789341233" , false));
        myAddressesModelList.add(new MyAddressesModel("Amit kumar" , "Bhawanipur , purainiya , darpa thana , near narkatiya bazae , east champaran , bihar , 845301" , "8789341233", false));
        myAddressesModelList.add(new MyAddressesModel("Amit kumar" , "Bhawanipur , purainiya , darpa thana , near narkatiya bazae , east champaran , bihar , 845301" , "8789341233" , false));
        myAddressesModelList.add(new MyAddressesModel("Amit kumar" , "Bhawanipur , purainiya , darpa thana , near narkatiya bazae , east champaran , bihar , 845301" , "8789341233" , false));
        myAddressesModelList.add(new MyAddressesModel("Amit kumar" , "Bhawanipur , purainiya , darpa thana , near narkatiya bazae , east champaran , bihar , 845301" , "8789341233" , false));
        myAddressesModelList.add(new MyAddressesModel("Amit kumar" , "Bhawanipur , purainiya , darpa thana , near narkatiya bazae , east champaran , bihar , 845301" , "8789341233" , false));
        myAddressesModelList.add(new MyAddressesModel("Amit kumar" , "Bhawanipur , purainiya , darpa thana , near narkatiya bazae , east champaran , bihar , 845301" , "8789341233" , false));
        myAddressesModelList.add(new MyAddressesModel("Amit kumar" , "Bhawanipur , purainiya , darpa thana , near narkatiya bazae , east champaran , bihar , 845301" , "8789341233" , false));

        int mode = getIntent().getIntExtra("MODE" , -1);
        if (mode == SELECT_ADDRESS){
            deliverHere.setVisibility(View.VISIBLE);
        }else {
            deliverHere.setVisibility(View.GONE);
        }
       myAddressesAdapter = new MyAddressesAdapter(myAddressesModelList , mode);
        savedAddressesRecyclerView.setAdapter(myAddressesAdapter);
        ((SimpleItemAnimator)savedAddressesRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        myAddressesAdapter.notifyDataSetChanged();
    }

    public static void refreshItem(int preSelectedPosition , int position){
        myAddressesAdapter.notifyItemChanged(preSelectedPosition);
        myAddressesAdapter.notifyItemChanged(position);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}