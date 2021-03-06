package com.example.da08.threadbasic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnBasic).setOnClickListener(this);
        findViewById(R.id.btnTest).setOnClickListener(this);
        findViewById(R.id.btnRain).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnBasic :
                intent = new Intent(this, ThreadBasicActivity.class);
                startActivity(intent);
                break;
            case R.id.btnTest :
                intent = new Intent(this, TestActivity.class);
                startActivity(intent);
                break;
            case R.id.btnRain :
                intent = new Intent(this, RainActivity.class);
                startActivity(intent);
                break;
        }
    }
}