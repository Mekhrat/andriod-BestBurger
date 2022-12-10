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
import com.example.android.newsfeed.adapter.BurgerAdapter;
import com.example.android.newsfeed.adapter.OrdersAdapter;
import com.example.android.newsfeed.db.OrdersDB;
import com.example.android.newsfeed.model.Burger;
import com.example.android.newsfeed.utils.Type;

import java.util.List;

public class OrdersFragment extends Fragment implements AdapterView.OnItemClickListener{

    List<Burger> orders = OrdersDB.getOrders();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        orders = OrdersDB.getOrders();
        if (orders.size() == 0) {
            Toast.makeText(getActivity(), "Сіз әлі тапсырыс жасамадыңыз!", Toast.LENGTH_SHORT).show();
        }
        return inflater.inflate(R.layout.fragment_orders, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        orders = OrdersDB.getOrders();
        ListView listView = (ListView) view.findViewById(R.id.ordersList);
        OrdersAdapter ordersAdapter = new OrdersAdapter(getActivity(), R.layout.items, orders);
        listView.setAdapter(ordersAdapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(view.getContext(), OrderActivity.class);
        intent.putExtra("id", i);
        intent.putExtra("type", Type.MY_ORDER);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        orders = OrdersDB.getOrders();
    }
}