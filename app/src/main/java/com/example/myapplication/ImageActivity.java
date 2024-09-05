package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ImageActivity extends AppCompatActivity {
    private int imageId[]=new int[]{R.drawable.rabbit,R.drawable.background,R.drawable.green,R.drawable.search1};
    private int index = 0; //当前图片的索引
    private ImageSwitcher mImageSwitcher;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main8);
        mImageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        mImageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in)); //设置淡入效果
        mImageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out)); //设置淡出效果
        mImageSwitcher.setFactory(new ImageSwitcher.ViewFactory(){
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(ImageActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        mImageSwitcher.setImageResource(imageId[index]);
        Button up = (Button) findViewById(R.id.button1);
        Button down = (Button) findViewById(R.id.button2);
        up.setOnClickListener(new View.OnClickListener() { //设置向上按钮的点击事件
            @Override
            public void onClick(View v) {
                if (index>0){
                    index--;
                }else {
                    index = imageId.length-1;
                }
                mImageSwitcher.setImageResource(imageId[index]);
            }
        });
        down.setOnClickListener(new View.OnClickListener() { //设置向下按钮的点击事件
            @Override
            public void onClick(View v) {
                if (index<imageId.length-1){
                    index++;
                }else {
                    index = 0;
                }
                mImageSwitcher.setImageResource(imageId[index]);
            }
        });
    }
}
