package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;

public class TabActivity extends AppCompatActivity {
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.main7);
        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(); // 初始化TabHost
        LayoutInflater inflater = LayoutInflater.from(this);  // 获取LayoutInflater对象
        inflater.inflate(R.layout.tab1, tabHost.getTabContentView());  // 添加第一个标签
        inflater.inflate(R.layout.tab2, tabHost.getTabContentView());
        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("中科创达")
                .setContent(R.id.tab1));
        tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator("智慧城市")
                .setContent(R.id.tab2)
        );
    }
}
