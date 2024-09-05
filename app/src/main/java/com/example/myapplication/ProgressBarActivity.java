package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ProgressBarActivity extends AppCompatActivity {
    private ProgressBar horizonP;
    private ProgressBar circleP;
    private int progressStatus=0; //进度条的进度
    private Handler handler; //用于处理消息

    @SuppressLint({"HandlerLeak", "MissingInflatedId"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main5);
        horizonP = (ProgressBar) findViewById(R.id.progressBar1);
        circleP = (ProgressBar) findViewById(R.id.progressBar2);
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == 0x111){
                    horizonP.setProgress(progressStatus);
                }
                else {
                    Toast.makeText(ProgressBarActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
                    horizonP.setVisibility(View.GONE); //隐藏进度条
                    circleP.setVisibility(View.GONE);  //隐藏圆形进度条
                }
            }
        };
        new Thread(new Runnable(){

            @Override
            public void run() {
                while(true){
                    progressStatus=doWork();
                    Message m = new Message();
                    if (progressStatus<100){
                        m.what = 0x111;
                        handler.sendMessage(m);
                    }else {
                        m.what = 0x222;
                        handler.sendMessage(m);
                        break;
                    }
                }
            }

            private int doWork() {
                progressStatus += Math.random()*10;
                try {
                    Thread.sleep(200);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                return progressStatus;
            }
        }).start();
        
        
    }

}
