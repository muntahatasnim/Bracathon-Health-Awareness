package com.csedu.bracathon;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.ViewHolder> {

    private MedicineData[] data;

    public MedicineAdapter(MedicineData[] data) {
        this.data = data;
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
        holder.textMedicine.setText(data[position].getName());
        holder.imageMedicine.setImageResource(data[position].getImgId());
    }
    @Override
    public int getItemCount() {
        return  data.length;
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

}