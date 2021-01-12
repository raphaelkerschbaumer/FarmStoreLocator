package com.example.farmstorelocator.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmstorelocator.R;
import com.example.farmstorelocator.SelectedShopActivity;
import com.example.farmstorelocator.WelcomePageActivity;
import com.example.farmstorelocator.models.FarmStoreInfo;

import java.util.List;

public class FarmStoreAdapter extends RecyclerView.Adapter<FarmStoreAdapter.ViewHolder>{

    private List<FarmStoreInfo> data;
    private Context context;

    public FarmStoreAdapter(Context context, List<FarmStoreInfo> data) {
        this.data = data;
        this.context = context;
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
        Log.d("onBindViewHolder: ","updateFarmStores done for position: "
                + position + " & "
                + data.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent;
                intent =  new Intent(context, SelectedShopActivity.class);
                intent.putExtra("FARM_STORE_OBJECT",data.get(position));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public void updateDataList(List<FarmStoreInfo> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        private TextView textFarmStoreName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textFarmStoreName = itemView.findViewById(R.id.textFarmStoreName);
            context = itemView.getContext();
        }

        public void updateFarmStores(FarmStoreInfo data) {
            textFarmStoreName.setText(data.getName()+ " "+data.getTown());
        }
    }
}
