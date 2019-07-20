package com.csedu.bracathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationActivity extends AppCompatActivity {
    Button dengue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        setTitle("Notification");

        dengue = findViewById(R.id.dengue);
        dengue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotificationActivity.this, DengueActivity.class);
                startActivity(intent);
            }
        });
    }
}
