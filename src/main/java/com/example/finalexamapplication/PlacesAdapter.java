package com.example.finalexamapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class PlacesAdapter extends BaseAdapter {
    private ArrayList<Places> places;
    LayoutInflater inflater;

    public PlacesAdapter(Context context, ArrayList<Places> inflater) {
        this.places = places;
        this.inflater=LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView (int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        holder = new ViewHolder();
        if(view==null)

            {
                view = inflater.inflate(R.layout.list_row, null);
                holder.img = view.findViewById(R.id.imgCountry);
                holder.country = view.findViewById(R.id.imgPlace);
                holder.price = view.findViewById(R.id.priceTxt);
                view.setTag(holder);
            }
        else
                view.getTag();
            int id;

            {
                id = view.getResources().getIdentifier(places.get(i).placeImg, "mipmap", view.getContext().getPackageName());
            }
        holder.img.setImageResource(id);
        holder.country.setImageResource(id);
        holder.price.setText(String.valueOf(places.get(i).

            getPrice()));

        return view;

        }
        static class ViewHolder{
        ImageView img,country;
        TextView price;
    }

}

