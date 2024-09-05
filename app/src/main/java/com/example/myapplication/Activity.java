package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.View.RabbitView;

public class Activity extends AppCompatActivity {


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3);
        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.myLayout);
        final RabbitView rabbit = new RabbitView(Activity.this);//创建一个RabbitView对象
        rabbit.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                rabbit.bitmapX = event.getX();
                rabbit.bitmapY = event.getY();
                rabbit.invalidate();
                return true;
            }
        });
        frameLayout.addView(rabbit);//将RabbitView对象添加到布局中
    }





}
