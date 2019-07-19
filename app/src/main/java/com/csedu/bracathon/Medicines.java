package com.csedu.bracathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.csedu.bracathon.R;

public class Medicines extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicines);

        MedicineData[] data = new MedicineData[] {
                new MedicineData("Napa", android.R.drawable.ic_delete),
                new MedicineData("Alatrol", android.R.drawable.ic_dialog_alert)
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MedicineAdapter adapter = new MedicineAdapter(data);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
