package com.example.tenx.test272.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tenx.test272.R;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;


import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentMenu extends Fragment {

    Button btnLogout;
    FirebaseAuth mAuth;
    private static final String TAG = "MenuActivity";
    //imageViews
    CircleImageView civ_profile;
    TextView tvName;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        //auth
        mAuth = FirebaseAuth.getInstance();

        //civ
        civ_profile = view.findViewById(R.id.civ_profile_image);
        Profile user = Profile.getCurrentProfile();
        Glide.with(Objects.requireNonNull(getActivity())).load(user.getProfilePictureUri(120,120)).into(civ_profile);


        tvName = view.findViewById(R.id.tv_profile_name);
        String print = "Logged in as : "+user.getFirstName();
        tvName.setText(print);



        btnLogout = view.findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                LoginManager.getInstance().logOut();
                updateUI();
            }
        });
        return view;
    }
    public void updateUI(){
        Intent accountIntent = new Intent(getActivity(), LoginActivity.class);
        startActivity(accountIntent);
    }

}
