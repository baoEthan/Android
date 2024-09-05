package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.Util.languageHelper;


public class MainActivity extends AppCompatActivity {
    private Context applicationContext;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        int[] tvID=new int[] {R.id.str1,R.id.str2,R.id.str3,R.id.str4,R.id.str5,R.id.str6,R.id.str7};
//        int[] tvColor=new int[] {R.color.color1,R.color.color2,R.color.color3,R.color.color4,R.color.color5,R.color.color6,R.color.color7};
        setTheme(R.style.wbg);//设置主题
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); //设置全屏
        Context ct= languageHelper.updateLanguage(this, "zh");
        this.applicationContext=ct;
        setContentView(R.layout.main1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            //原始XML文件资源运用实例
            XmlResourceParser xrp = getResources().getXml(R.xml.customers);//获取XML文件资源
            StringBuilder sb=new StringBuilder("");
            try {
                while(xrp.getEventType() != XmlResourceParser.END_DOCUMENT){   //判断是否到xml的结尾
                    if(xrp.getEventType() == XmlResourceParser.START_TAG) { //判断是否是开始标签
                        if (xrp.getName().equals("customer")) { //判断标签名是否为customer
                            sb.append("姓名："+xrp.getAttributeValue(0)+" ");//获取属性值
                            sb.append("邮箱："+xrp.getAttributeValue(1)+" ");
                            sb.append("电话："+xrp.getAttributeValue(2)+"\n");
                        }
                    }
                    xrp.next(); //获取下一个标签
                }
                TextView tv=(TextView) findViewById(R.id.show);
                tv.setText(sb.toString());
            }catch (Exception e){
                e.printStackTrace();
            }

            //stateListDrawable运用实例
//            final Button bt1=(Button) findViewById(R.id.button4);
//            bt1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Button b= (Button) v; //获取按钮对象
//                    b.setEnabled(false); //设置按钮不可用
//                    b.setText("我是不可用按钮");
//                    Toast.makeText(MainActivity.this, "按钮变为不可用", Toast.LENGTH_SHORT).show();
//                }
//            });
//            Button bt2 = (Button) findViewById(R.id.button5);
//            bt2.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    bt1.setEnabled(true);
//                    bt1.setText("我是可用按钮");
//                }
//            });


            //通过数组形式给textview组件设置颜色
//            ListView lv = (ListView) findViewById(R.id.listView1);
//            lv.setBackgroundColor(getResources().getColor(R.color.color1));
//            for (int i = 0; i <7 ; i++) {
//                TextView tv = (TextView) findViewById(tvID[i]);  //获取id为tvID[i]的TextView
//                tv.setGravity(Gravity.CENTER); //设置文字居中
//                tv.setBackgroundColor(getResources().getColor(tvColor[i])); //设置背景颜色
//                tv.setHeight((int) (getResources().getDimension(R.dimen.basic)*(i+2)/2));
////                String red=getResources().getString(R.string.app_name);
////                System.out.println(red);
//            }
            recreate();
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}