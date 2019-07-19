package com.csedu.bracathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        setTitle("Guide");
        Button medicineButton;

        medicineButton = findViewById(R.id.medicineButton);

        medicineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMedicine();
            }
        });

    }
    public void showMedicine() {

        startActivity(new Intent(GuideActivity.this,Medicines.class));

    }
}
