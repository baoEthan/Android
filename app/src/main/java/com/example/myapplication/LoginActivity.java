package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    final int CODE=0x717; //自定义的请求码
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button login = (Button) findViewById(R.id.button1);
        Button register = (Button) findViewById(R.id.button2);
        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String username = ((EditText) findViewById(R.id.username)).getText().toString();
                String password = ((EditText) findViewById(R.id.password)).getText().toString();
//                Intent intent = new Intent(LoginActivity.this, TableActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("username", username);
//                bundle.putString("password", password);
//                Log.d("LoginActivity", "username: " + username + ", password: " + password);
//                intent.putExtras(bundle);
//                startActivity(intent);
                Intent intent = new Intent();
                intent.putExtra("username", username);
                intent.putExtra("password", password);
                intent.setClass(LoginActivity.this, TableActivity.class);
                startActivityForResult(intent, CODE);
            }
        });
        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent, CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println(requestCode + ": " + resultCode);
        if(requestCode==CODE && resultCode==CODE){
            ((EditText) findViewById(R.id.username)).setText("");
            ((EditText) findViewById(R.id.password)).setText("");
        }
    }
}
