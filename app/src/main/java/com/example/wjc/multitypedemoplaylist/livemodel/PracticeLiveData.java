package com.example.wjc.multitypedemoplaylist.livemodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;

import com.example.wjc.multitypedemoplaylist.Repository;
import com.example.wjc.multitypedemoplaylist.activity.MainActivity;
import com.example.wjc.multitypedemoplaylist.data.HotList;
import com.example.wjc.multitypedemoplaylist.data.HotMusic;
import com.example.wjc.multitypedemoplaylist.data.NewMusic;

import me.drakeet.multitype.Items;

public class PracticeLiveData{
    private static PracticeLiveData practiceLiveModel=new PracticeLiveData();
    private PracticeLiveData(){}
    public static PracticeLiveData getInstance(){
        return practiceLiveModel;
    }
    private MutableLiveData<NewMusic> newMusicLiveData;
    private MutableLiveData<HotMusic> hotMusicLiveData;
    private MutableLiveData<HotList> hotListLiveData;
    private MutableLiveData<Items> itemsMutableLiveData;
    private Repository repository=new Repository();
    public NewMusic newMusic=repository.initNewMusicData();
    public HotMusic hotMusic=repository.initHotMusicData();
    public HotList hotList=repository.initHotListData();
    public Items items=repository.getItems();
    public void updateNewMusicObject(){
        this.getNewMusic().setValue(newMusic);
    }
    public void firstOpenApp(){
        this.getItems().setValue(items);
    }
   public void updateNewMusicTitle(String title){
        newMusic.setTitle(title);
        this.getNewMusic().setValue(newMusic);
    }
    public void updateHotMusicObject(){
        this.getHotMusic().setValue(hotMusic);
    }
    public void updateHotListObject(){
        this.getHotList().setValue(hotList);
    }
    public MutableLiveData<NewMusic> getNewMusic(){
        if(newMusicLiveData==null){
            newMusicLiveData=new MutableLiveData<>();
        }
        return newMusicLiveData;
    }
    public MutableLiveData<HotMusic> getHotMusic(){
        if(hotMusicLiveData==null){
            hotMusicLiveData=new MutableLiveData<>();
        }
        return hotMusicLiveData;
    }
    public MutableLiveData<HotList> getHotList(){
        if(hotListLiveData==null){
            hotListLiveData=new MutableLiveData<>();
        }
        return hotListLiveData;
    }
    public MutableLiveData<Items> getItems(){
        if(itemsMutableLiveData==null){
            itemsMutableLiveData=new MutableLiveData<>();
        }
        return itemsMutableLiveData;
    }
}
