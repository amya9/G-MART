package com.example.foodtruck;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.foodtruck.RegisterActivity.onFragmentChange;

public class ForgotPassworFragment extends Fragment {
    private EditText forgotPasswordEmail;
    private Button resetPasswordBtn;
    private TextView goBack ;
    private FrameLayout frameLayout;
    private FirebaseAuth firebaseAuth;
    private ProgressBar resetProgressBar;
    private TextView emailSentTv;
    private ImageView emailIcon;
    private ViewGroup iconContainerLL;

    public ForgotPassworFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_forgot_passwor, container, false);

        forgotPasswordEmail = view.findViewById(R.id.resetPassword_email);
        resetPasswordBtn = view.findViewById(R.id.resetPassword_btn);
        goBack = view.findViewById(R.id.resetPassword_goback_tv);

        frameLayout = getActivity().findViewById(R.id.register_frameLayout);

        resetProgressBar = view.findViewById(R.id.resetPassword_progressBar);

        emailSentTv = view.findViewById(R.id.emailSent_tv);
        emailIcon = view.findViewById(R.id.email_icon);
        iconContainerLL = view.findViewById(R.id.forgotPassword_linearlayout);
        firebaseAuth = FirebaseAuth.getInstance();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        forgotPasswordEmail.addTextChangedListener(new TextWatcher() {
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

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignInFragment());
            }
        });

        resetPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFragmentChange = true;

                sendResetEmail();
            }
        });
    }

    private void checkInputs(){
        if (!TextUtils.isEmpty(forgotPasswordEmail.getText())){

            resetPasswordBtn.setEnabled(true);
            resetPasswordBtn.setTextColor(Color.parseColor("#ffffff"));
        }else {
            resetPasswordBtn.setEnabled(false);
            resetPasswordBtn.setTextColor(Color.parseColor("#80ffffff"));
        }
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left , R.anim.slideout_from_right);
        fragmentTransaction.replace(frameLayout.getId() , fragment);
        fragmentTransaction.commit();
    }

    private void sendResetEmail(){

        TransitionManager.beginDelayedTransition(iconContainerLL);
        emailSentTv.setVisibility(View.GONE);

        TransitionManager.beginDelayedTransition(iconContainerLL);
        emailIcon.setVisibility(View.VISIBLE);
        resetProgressBar.setVisibility(View.VISIBLE);

        resetPasswordBtn.setEnabled(false);
        resetPasswordBtn.setTextColor(Color.parseColor("#80ffffff"));

        firebaseAuth.sendPasswordResetEmail(forgotPasswordEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){

//                    ScaleAnimation scaleAnimation = new ScaleAnimation()
                    Toast.makeText(getActivity().getApplicationContext() , "Mail send successfully" , Toast.LENGTH_LONG).show();

                }else {
                    String error = task.getException().getMessage();
                    emailSentTv.setText(error);
                    resetPasswordBtn.setEnabled(true);
                    resetPasswordBtn.setTextColor(Color.parseColor("#ffffff"));

                    emailSentTv.setTextColor(getResources().getColor(R.color.errorColor));
                    TransitionManager.beginDelayedTransition(iconContainerLL);
                    emailSentTv.setVisibility(View.VISIBLE);
                }
                resetProgressBar.setVisibility(View.GONE);

            }
        });
    }

}