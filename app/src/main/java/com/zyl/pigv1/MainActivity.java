package com.zyl.pigv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zyl.pigv1.activity.user.UserActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToUser(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, UserActivity.class);
        startActivity(intent);
    }

//    public void clickToPig(View view) {
//        Intent intent = new Intent();
//        intent.setClass(MainActivity.this, PigActivity.class);
//        startActivity(intent);
//    }
}