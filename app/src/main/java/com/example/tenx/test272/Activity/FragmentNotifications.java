package com.example.tenx.test272.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.tenx.test272.Adapters.NotificationsAdapter;
import com.example.tenx.test272.DatabaseElements.Models.Notification;
import com.example.tenx.test272.DatabaseElements.ViewModels.AppViewModel;
import com.example.tenx.test272.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FragmentNotifications extends Fragment{

    RecyclerView recyclerView;
    NotificationsAdapter adapter;
    private final static String TAG = "FragmentNotifications!";
    private List<Notification> mList;

    AppViewModel viewModel;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        recyclerView = view.findViewById(R.id.notification_recycler);

        ToggleButton tog = view.findViewById(R.id.tog_subscribe);
        tog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    FirebaseMessaging.getInstance().subscribeToTopic("all").addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getContext(), "Subscribed to notifications", Toast.LENGTH_SHORT).show();
                        }
                    });

                }else{
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("all").addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getContext(), "Unsubscribed to notifications", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });

        adapter = new NotificationsAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        //setting up the view model
        viewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(AppViewModel.class);
        viewModel.getAllNotifs().observe(this, new Observer<List<Notification>>() {
            @Override
            public void onChanged(@Nullable List<Notification> notifications) {

                      if(adapter == null){
                          adapter = new NotificationsAdapter(getActivity());
                      }
                       adapter.insertAndRefresh(notifications);
                       adapter.notifyDataSetChanged();
                       recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                       recyclerView.setAdapter(adapter);
                        Log.d(TAG, "onChanged called");


            }
        });


        return view;
    }


}

