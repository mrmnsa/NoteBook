package com.example.diary;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setNightMode();
    }

    //设置主题 主题换肤（Theme主题换肤）
    public void setNightMode(){
       setTheme(R.style.DayTheme);
    }
}
