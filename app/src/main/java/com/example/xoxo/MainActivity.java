package com.example.xoxo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.xoxo.morpion.MatriceData;

public class MainActivity extends AppCompatActivity {
    public static MainActivity mainA;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.mainA = this;
        setContentView(R.layout.activity_main);
//        boolean res = MatriceData.isIsWin();
//        if(res){
//            Intent intent = new Intent(MainActivity.this, WinActivity.class);
//            startActivity(intent);
//        }
    }
}