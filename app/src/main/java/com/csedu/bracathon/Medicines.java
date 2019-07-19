package com.csedu.bracathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.csedu.bracathon.R;

import java.util.ArrayList;
import java.util.Locale;

public class Medicines extends AppCompatActivity {

    EditText editText=null;
    RecyclerView recyclerView;
    MedicineAdapter medicineAdapter;
    String[] name;
    ArrayList<MedicineData> medicineDataArrayList = new ArrayList<MedicineData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicines);

        name = new String[]{
                "Delete","Alert"
        };

        MedicineData[] data = new MedicineData[] {
                new MedicineData("Napa", android.R.drawable.ic_delete),
                new MedicineData("Alatrol", android.R.drawable.ic_dialog_alert)
        };

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        for(int i=0;i<name.length;i++){
            MedicineData medicineData = new MedicineData(name[i],android.R.drawable.ic_delete);
            medicineDataArrayList.add(medicineData);
        }

        editText = findViewById(R.id.Edt);


        medicineAdapter = new MedicineAdapter(this,medicineDataArrayList);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(medicineAdapter);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String who = editText.getText().toString().toLowerCase(Locale.getDefault());
                System.out.println(who);
                medicineAdapter.myFilter(who);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
