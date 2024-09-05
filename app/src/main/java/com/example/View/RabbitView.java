package com.example.View;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.myapplication.R;

public class RabbitView extends View {
    public float bitmapX;//小兔子位置显示的X坐标
    public float bitmapY;//小兔子位置显示的Y坐标

    public RabbitView(Context context) {
        super(context);
        bitmapX = 700; //小兔子初始位置
        bitmapY = 750; //小兔子初始位置
    }

    @Override
    @SuppressLint("DrawAllocation")
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
         Paint paint = new Paint();
         Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.green)
                                .copy(Bitmap.Config.ARGB_8888,true);//获取小兔子图片
        bitmap.setHeight(100);
        bitmap.setWidth(100);

        canvas.drawBitmap(bitmap,bitmapX,bitmapY,paint);//绘制小兔子
        if (bitmap.isRecycled()){  //判断bitmap是否被回收
            bitmap.recycle(); //强制回收bitmap
        }
    }
}
