package com.csedu.bracathon;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.ViewHolder> {

    Context cont;
    LayoutInflater layinf;
    List<MedicineData> medicineList;
    ArrayList<MedicineData> medicineArray;
    private MedicineData[] data;

    public MedicineAdapter(Context con,List<MedicineData>medicine) {
        cont =con;
        medicineList = medicine;
        this.layinf = LayoutInflater.from(cont);
        this.medicineArray = new ArrayList<MedicineData>();
        this.medicineArray.addAll(medicine);

    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.medicine_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textMedicine.setText(medicineArray.get(position).getName());
        holder.imageMedicine.setImageResource(medicineArray.get(position).getImgId());
    }
    @Override
    public int getItemCount() {
        return  medicineArray.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageMedicine;
        public TextView textMedicine;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageMedicine = (ImageView) itemView.findViewById(R.id.imageMedicine);
            this.textMedicine = (TextView) itemView.findViewById(R.id.textMedicine);
        }
    }

    public void myFilter(String name){
        name = name.toLowerCase(Locale.getDefault());
        medicineArray.clear();

        if(name.length() == 0){
            System.out.println("11");
            medicineArray.addAll(medicineList);
        }
        else{
            for(MedicineData medicineData : medicineList){
                if(medicineData.getName().toLowerCase(Locale.getDefault()).startsWith(name)){
                    medicineArray.add(medicineData);
                }
            }

        }
        notifyDataSetChanged();
    }



}