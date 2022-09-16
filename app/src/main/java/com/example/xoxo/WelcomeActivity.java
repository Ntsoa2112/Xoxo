package com.example.xoxo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.xoxo.morpion.Joueur;
import com.example.xoxo.morpion.MatriceView;
import com.google.android.material.textfield.TextInputEditText;

public class WelcomeActivity extends Activity {
    Button btn, tailleBtn, matchBtn, botBtn, amiBtn;
    TextInputEditText j1, j2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);

        btn = (Button) findViewById(R.id.btn1);
        tailleBtn = (Button) findViewById(R.id.tailleBtn);
        matchBtn = (Button) findViewById(R.id.matchBtn);
        botBtn = (Button) findViewById(R.id.botBtn);
        amiBtn = (Button) findViewById(R.id.amiBtn);
        j1 = (TextInputEditText) findViewById(R.id.i1);
        j2 = (TextInputEditText) findViewById(R.id.i2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = j1.getText().toString();
                MainActivity.j1 = new Joueur(name);
                name = j2.getText().toString();
                MainActivity.j2 = new Joueur(name);
                if(tailleBtn.getText().equals("4 x 4")){
                    MatriceView.dim = 4;
                }
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        tailleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = (String) tailleBtn.getText();
                if(txt.equals("3 x 3")){
                    tailleBtn.setText("4 x 4");
                }else{
                    tailleBtn.setText("3 x 3");
                }
            }
        });

        matchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int val = Integer.parseInt((String) matchBtn.getText());
                if(val < 5){
                    val++;
                }else{
                    val = 1;
                }
            }
        });
    }
}
