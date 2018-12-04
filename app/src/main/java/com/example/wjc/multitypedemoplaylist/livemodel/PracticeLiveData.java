package com.example.wjc.multitypedemoplaylist.livemodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;

import com.example.wjc.multitypedemoplaylist.data.HotList;
import com.example.wjc.multitypedemoplaylist.data.HotMusic;
import com.example.wjc.multitypedemoplaylist.data.NewMusic;

public class PracticeLiveData extends ViewModel {
//    private static PracticeLiveData practiceLiveModel=new PracticeLiveData();
//    private PracticeLiveData(){}
//    public static PracticeLiveData getInstance(){
//        return practiceLiveModel;
//    }
    private MutableLiveData<NewMusic> newMusic;
    private MutableLiveData<HotMusic> hotMusic;
    private MutableLiveData<HotList> hotList;
    public MutableLiveData<NewMusic> getNewMusic(){
        if(newMusic==null){
            newMusic=new MutableLiveData<>();
        }
        return newMusic;
    }
    public MutableLiveData<HotMusic> getHotMusic(){
        if(hotMusic==null){
            hotMusic=new MutableLiveData<>();
        }
        return hotMusic;
    }
    public MutableLiveData<HotList> getHotList(){
        if(hotList==null){
            hotList=new MutableLiveData<>();
        }
        return hotList;
    }
}
