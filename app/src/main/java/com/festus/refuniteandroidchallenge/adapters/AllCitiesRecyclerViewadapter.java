package com.festus.refuniteandroidchallenge.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import com.festus.refuniteandroidchallenge.R;

import static com.festus.refuniteandroidchallenge.fragments.AllCitiesFragment.weatherObservation;

/**
 * Created by festus on 10/27/16.
 */

public class AllCitiesRecyclerViewadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Map<String, String>> data;
    public AllCitiesRecyclerViewadapter(List<Map<String, String>> data) {
        this.data = data;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_location_item_view, parent, false);
        CityItemView cityItemView = new CityItemView(v);
        return cityItemView;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CityItemView) holder).cityName.setText(data.get(position).get("STATIONNAME"));
        ((CityItemView) holder).dateTime.setText(data.get(position).get("DATETIME"));
        ((CityItemView) holder).temperature.setText(data.get(position).get("TEMPARATURE"));

        switch (position) {
            case 0:
                ((CityItemView) holder).itemView.setBackgroundResource(R.drawable.navbg);
                break;
            case 1:
                ((CityItemView) holder).itemView.setBackgroundResource(R.drawable.addisababacity);
                break;
            case 2:
                ((CityItemView) holder).itemView.setBackgroundResource(R.drawable.entebe);
                break;
            case 3:
                ((CityItemView) holder).itemView.setBackgroundResource(R.drawable.eldoret);
                break;
            case 4:
                ((CityItemView) holder).itemView.setBackgroundResource(R.drawable.dareslam);
                break;
            case 5:
                ((CityItemView) holder).itemView.setBackgroundResource(R.drawable.kisumu);
                break;
            case 6:
                ((CityItemView) holder).itemView.setBackgroundResource(R.drawable.jkia);
                break;

             default:
                 break;
        }



    }

    @Override
    public int getItemCount() {
       return data.size();
    }
    private class CityItemView extends RecyclerView.ViewHolder  {
        public TextView cityName , dateTime,temperature;

        public CityItemView(View itemView) {
            super(itemView);
            cityName = (TextView)itemView.findViewById(R.id.station_name_textView);
            dateTime = (TextView)itemView.findViewById(R.id.date_textView) ;
            temperature = (TextView)itemView.findViewById(R.id.temperature_textView);
        }


    }
}
