package com.example.farmstorelocator.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmstorelocator.R;
import com.example.farmstorelocator.models.FarmStoreInfo;

import java.util.List;

public class FarmStoreAdapter extends RecyclerView.Adapter<FarmStoreAdapter.ViewHolder> {

    private List<FarmStoreInfo> data;

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
    public void onBindViewHolder(@NonNull FarmStoreAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void updateData(List<FarmStoreInfo> data) {
        this.data = data;
        notifyDataSetChanged();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textFarmStoreName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textFarmStoreName = itemView.findViewById(R.id.textFarmStoreName);
        }

        public void updateFarmStores(FarmStoreInfo data) {
            textFarmStoreName.setText(data.getName().toString());
        }
    }
}
