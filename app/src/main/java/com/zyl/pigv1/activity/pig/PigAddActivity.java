package com.zyl.pigv1.activity.pig;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.zyl.pigv1.databinding.ActivityPigBinding;

public class PigAddActivity extends AppCompatActivity {

    private ActivityPigBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("猪");
        binding = ActivityPigBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
//        String checkId = intent.getStringExtra("checkId");

//        Toast.makeText(PigActivity.this, checkId, Toast.LENGTH_LONG).show();
    }
}