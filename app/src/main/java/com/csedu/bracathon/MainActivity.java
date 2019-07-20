package com.csedu.bracathon;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
   EditText pin,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       pin = (EditText) findViewById(R.id.brac_id);
       pass=(EditText)findViewById(R.id.password);

        Button mybutton = (Button) findViewById(R.id.loginButton);
        mybutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(pin.getText().toString().trim().length() <= 0 || pass.getText().toString().trim().length() <= 0 )
                {
                    Toast.makeText(MainActivity.this, "PLease Enter Your Brac Pin And ID", Toast.LENGTH_SHORT).show();
                }
               else {
                    startActivity(new Intent(MainActivity.this, GridActivity.class));
                }
            }
        });

    }

}
