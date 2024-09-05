package com.example.myapplication;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GalleryActivity extends AppCompatActivity {
    private int imageId[]=new int[]{R.drawable.rabbit,R.drawable.background,R.drawable.green,R.drawable.search1,
            R.drawable.rabbit,R.drawable.background,R.drawable.green,R.drawable.search1,
            R.drawable.rabbit,R.drawable.background,R.drawable.green,R.drawable.search1};
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main9);
        Gallery gallery=(Gallery) findViewById(R.id.gallery);
        gallery.setAdapter(adapter);
        gallery.setSelection(imageId.length/2);
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GalleryActivity.this,"你点击了"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    BaseAdapter adapter = new BaseAdapter(){

        @Override
        public int getCount() {
            return imageId.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null){
                imageView = new ImageView(GalleryActivity.this);
                imageView.setLayoutParams(new Gallery.LayoutParams(200,200));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                TypedArray typedArray = obtainStyledAttributes(R.styleable.Gallery);  //获取自定义属性
                imageView.setBackgroundResource(typedArray.getResourceId(R.styleable.Gallery_android_galleryItemBackground,0));
                imageView.setPadding(5,0,5,0);
            }else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(imageId[position]);
            return imageView;
        }
    };
}
