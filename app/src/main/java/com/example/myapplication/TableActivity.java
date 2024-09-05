package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class TableActivity extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        TextView user = (EditText) findViewById(R.id.user);
        TextView pwd = (EditText) findViewById(R.id.pwd);
        user.setText(extras.getString("username"));
        pwd.setText(extras.getString("password"));
    }
}
