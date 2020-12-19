package com.example.farmstorelocator.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmstorelocator.R;
import com.example.farmstorelocator.models.WebRadioCountry;
import java.util.List;

public class RadioAdapter extends RecyclerView.Adapter<RadioAdapter.ViewHolder> {

    private List<WebRadioCountry> data;

    public RadioAdapter(List<WebRadioCountry> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.radio_country_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RadioAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void updateData(List<WebRadioCountry> data) {
        this.data = data;
        notifyDataSetChanged();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textCountry;
        private TextView textAmountOfStations;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textCountry = itemView.findViewById(R.id.textCountry);
            textAmountOfStations = itemView.findViewById(R.id.textAmountOfStations);
        }

        public void updateWebRadio(WebRadioCountry data) {
            textCountry.setText(data.getName().toString());
            textAmountOfStations.setText(data.getStationcount().toString());
        }
    }
}
