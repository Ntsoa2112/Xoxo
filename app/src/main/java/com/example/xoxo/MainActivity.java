package com.example.xoxo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.xoxo.morpion.Joueur;

public class MainActivity extends AppCompatActivity {
    public static MainActivity mainA;

    public static Joueur j1, j2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.mainA = this;
        setContentView(R.layout.activity_main);
        if(MainActivity.j1 == null){
            MainActivity.j1 = new Joueur("j1");
            MainActivity.j2 = new Joueur("j2");
        }

        String j1_name = j1.name;
        String j2_name = j1.name;
        int j1_score = j1.score;
        int j2_score = j2.score;
        String j1_score_string = Integer.toString(j1_score);
        String j2_score_string = Integer.toString(j2_score);
        TextView nb1 = (TextView) findViewById(R.id.editTextNumber);
        TextView nb2 = (TextView) findViewById(R.id.editTextNumber2);
        TextView tv1 = (TextView) findViewById(R.id.textView8);
        tv1.setText((CharSequence) j1_name);
        TextView tv = (TextView)findViewById(R.id.textView9);
        tv.setText((CharSequence) j2_name);
        nb1.setText((CharSequence) j1_score_string);
        nb2.setText((CharSequence) j2_score_string);

    }
}