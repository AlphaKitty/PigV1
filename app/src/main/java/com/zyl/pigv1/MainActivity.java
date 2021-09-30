package com.zyl.pigv1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.zyl.pigv1.activity.check.CheckActivity;
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

    public void clickToCheck(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, CheckActivity.class);
        startActivity(intent);
    }
}