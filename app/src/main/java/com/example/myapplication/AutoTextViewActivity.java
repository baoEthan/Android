package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AutoTextViewActivity extends AppCompatActivity {
    private static final String[] COUNTRIES = new String[] {
            "中科创达", "中科创达软件科技", "中科创达软件科技有限公司","中科创达","创达"
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main4);
        AutoCompleteTextView tv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        Button btn = (Button) findViewById(R.id.button1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        tv.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(AutoTextViewActivity.this,tv.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
