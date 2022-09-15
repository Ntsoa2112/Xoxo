package com.example.xoxo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

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
        j1 = (TextInputEditText) findViewById(R.id.jinput1);
        j2 = (TextInputEditText) findViewById(R.id.jinput2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
