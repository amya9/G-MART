package com.example.foodtruck;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInFragment extends Fragment {

    private TextView dontHaveAccount;
    private FrameLayout parentFramelayout;
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";

    private TextView forgotPassword ;
    private Button signInButton ;
    private EditText signInEmail , signInPassword;
    private ProgressBar signInProgressBar;
    private ImageButton closeSignInBtn;
    FirebaseAuth firebaseAuth;

    public SignInFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
         view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        parentFramelayout = getActivity().findViewById(R.id.register_frameLayout);

        firebaseAuth = FirebaseAuth.getInstance();

        dontHaveAccount = view.findViewById(R.id.new_user_signUp_form);
         signInButton = view.findViewById(R.id.signIn_btn);
         signInEmail = view.findViewById(R.id.signIn_email);
         signInPassword = view.findViewById(R.id.signIn_password);
         forgotPassword = view.findViewById(R.id.forgot_password_tv);
         signInProgressBar = view.findViewById(R.id.signIn_progressBar);
         forgotPassword = view.findViewById(R.id.forgot_password_tv);

         closeSignInBtn = view.findViewById(R.id.close_signIn_btn);


          return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dontHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignUpFragment());
            }

        });
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new ForgotPassworFragment());
            }
        });



        signInEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        signInPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailAndPassword();
            }
        });

        closeSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIntent();
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right , R.anim.slideout_from_left);
        fragmentTransaction.replace(parentFramelayout.getId() , fragment);
        fragmentTransaction.commit();
    }

    private void checkInputs(){
        if (!TextUtils.isEmpty(signInEmail.getText())){
            if (!TextUtils.isEmpty(signInPassword.getText())){
                 signInButton.setEnabled(true);
                 signInButton.setTextColor(Color.parseColor("#000000"));
            }else {
                signInButton.setEnabled(false);
                signInButton.setTextColor(Color.parseColor("#50000000"));
            }

        }else {
            signInButton.setEnabled(false);
            signInButton.setTextColor(Color.parseColor("#50000000"));
        }
    }

    private void checkEmailAndPassword(){
        if (signInEmail.getText().toString().matches(emailPattern)){
            if (signInPassword.length() >= 8){
                signInProgressBar.setVisibility(View.VISIBLE);
                signInButton.setEnabled(false);
                signInButton.setTextColor(Color.parseColor("#50000000"));
                firebaseAuth.signInWithEmailAndPassword(signInEmail.getText().toString() , signInPassword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful()){
                               mainIntent();
                           }else {
                               signInProgressBar.setVisibility(View.INVISIBLE);
                               signInButton.setEnabled(true);
                               signInButton.setTextColor(Color.parseColor("#000000"));
                               String error = task.getException().getMessage();
                               Toast.makeText(getActivity() , error , Toast.LENGTH_LONG).show();
                           }
                            }
                        });
            }else {
                signInProgressBar.setVisibility(View.INVISIBLE);
                signInButton.setEnabled(true);
                signInButton.setTextColor(Color.parseColor("#000000"));
            }
        }else {
            signInProgressBar.setVisibility(View.INVISIBLE);
            signInButton.setEnabled(true);
            signInButton.setTextColor(Color.parseColor("#000000"));

        }

    }
    private void mainIntent(){
        Intent mainActivityIntent = new Intent(getActivity() , MainActivity.class);
        startActivity(mainActivityIntent);
        getActivity().finish();
    }
}