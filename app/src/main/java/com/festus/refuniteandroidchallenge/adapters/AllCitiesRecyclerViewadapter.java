package com.festus.refuniteandroidchallenge.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import com.festus.refuniteandroidchallenge.R;
import com.festus.refuniteandroidchallenge.models.Geoname;

/**
 * Created by festus on 10/27/16.
 */

public class AllCitiesRecyclerViewadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Geoname> geoNames;
    public AllCitiesRecyclerViewadapter(ArrayList<Geoname> geoNames) {
        this.geoNames = geoNames;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_countries_item_view, parent, false);
        CityItemView cityItemView = new CityItemView(v);
        return cityItemView;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CityItemView) holder).cityName.setText(geoNames.get(position).getToponymName());

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    private class CityItemView extends RecyclerView.ViewHolder  {
        public TextView cityName;

        public CityItemView(View itemView) {
            super(itemView);
            cityName = (TextView)itemView.findViewById(R.id.location_textView);

        }


    }
}
