package com.example.tenx.test272.DatabaseElements.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.tenx.test272.DatabaseElements.AppRepository;
import com.example.tenx.test272.DatabaseElements.Models.Notification;
import com.example.tenx.test272.DatabaseElements.Models.TechEvent;

import java.util.List;

public class AppViewModel extends AndroidViewModel {
    private static AppRepository appRepository;

    public AppViewModel(@NonNull Application application) {
        super(application);
        appRepository = new AppRepository(application);
    }


    //events functions
    public LiveData<List<TechEvent>> getAllEvents(){
        return appRepository.getAllEvents();
    }

    public void deleteAllEvents(){
        appRepository.deleteAllEvents();
    }
    public void deleteEventByID(int _id){
        appRepository.deleteEventByid(_id);
    }
    public void deleteEventByName(String name){
        appRepository.deleteEventByName(name);
    }

    public void insertEvent(TechEvent event){
        appRepository.insertEvent(event);
    }
    public void updateEvent(TechEvent event){
        appRepository.updateEvent(event);
    }



    //notifications functions
    public LiveData<List<Notification>> getAllNotifs(){
        return appRepository.getAllNotifications();
    }

    public void deleteAllNotifs(){
        appRepository.deleteAllEvents();
    }
    public void deleteNotifById(int _id){
        appRepository.deleteNotifbyID(_id);
    }

    public void insert(Notification notif){
        appRepository.insertNotif(notif);
    }
    public void update(Notification notif){
        appRepository.updateNotif(notif);
    }


}
