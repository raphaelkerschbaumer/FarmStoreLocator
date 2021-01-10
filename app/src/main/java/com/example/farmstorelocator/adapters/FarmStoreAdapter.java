package com.example.farmstorelocator.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmstorelocator.R;
import com.example.farmstorelocator.models.FarmStoreInfo;

import java.util.List;

public class FarmStoreAdapter extends RecyclerView.Adapter<FarmStoreAdapter.ViewHolder>{

    private List<FarmStoreInfo> data;
    private ClickListener clickListener;

    public FarmStoreAdapter(List<FarmStoreInfo> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.farm_store, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.updateFarmStores(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public void updateDataList(List<FarmStoreInfo> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textFarmStoreName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textFarmStoreName = itemView.findViewById(R.id.textFarmStoreName);
        }

        public void updateFarmStores(FarmStoreInfo data) {
            textFarmStoreName.setText(data.getName()+ " "+data.getTown());
        }

        @Override
        public void onClick(View v) {
            Log.d("onClick:", "onClick performed" );
        }
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }
}
