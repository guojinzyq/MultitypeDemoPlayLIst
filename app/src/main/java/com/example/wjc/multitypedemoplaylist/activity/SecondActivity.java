package com.example.wjc.multitypedemoplaylist.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.wjc.multitypedemoplaylist.R;
import com.example.wjc.multitypedemoplaylist.livemodel.PracticeLiveData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;
//    @OnClick(R.id.button)
//    public void updateNewMusic(){
//        MainActivity.newMusic.setTitle("新歌速递3");
//        //通过get方法获得的viewmodel会根据of里的key返回一个viewmodel实例，key不变时获得的是同一个viewmodel
//        ViewModelProviders.of(MainActivity.instance).get(PracticeLiveData.class).getNewMusic().setValue(MainActivity.newMusic);
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
    }
}
