package com.example.android.newsfeed.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android.newsfeed.R;
import com.example.android.newsfeed.model.Burger;

import java.util.List;

public class BurgerAdapter extends ArrayAdapter<Burger> {
    private LayoutInflater inflater;
    private int layout;
    private List<Burger> burgers;


    public BurgerAdapter(@NonNull Context context, int resource, @NonNull List<Burger> burgers) {
        super(context, resource, burgers);
        this.inflater = LayoutInflater.from(context);
        this.layout = resource;
        this.burgers = burgers;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=inflater.inflate(this.layout, parent, false);

        ImageView flagView = view.findViewById(R.id.flag);
        TextView nameView = view.findViewById(R.id.name);
        TextView capitalView = view.findViewById(R.id.capital);
        TextView price = view.findViewById(R.id.price);

        Burger burger = burgers.get(position);

        flagView.setImageResource(burger.getPhoto());
        nameView.setText(burger.getName());
        capitalView.setText(burger.getDescryption());
        price.setText(burger.getPrice()+ " тг.");

        return view;
    }
}
