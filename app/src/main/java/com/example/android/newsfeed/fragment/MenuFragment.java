package com.example.android.newsfeed.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.newsfeed.OrderActivity;
import com.example.android.newsfeed.R;
import com.example.android.newsfeed.BurgerAdapter;
import com.example.android.newsfeed.model.Burger;
import com.example.android.newsfeed.db.BurgerDB;

import java.util.List;

public class MenuFragment extends Fragment implements AdapterView.OnItemClickListener{

    List<Burger> burgers = BurgerDB.getBurgers();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println(burgers);
        ListView listView = (ListView) view.findViewById(R.id.burgersList);


        BurgerAdapter burgerAdapter = new BurgerAdapter(getActivity(), R.layout.items, burgers);
        listView.setAdapter(burgerAdapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getActivity(), String.valueOf(i), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(view.getContext(), OrderActivity.class);
        intent.putExtra("id", i);
        startActivity(intent);
    }
}