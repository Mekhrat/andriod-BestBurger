package com.example.android.newsfeed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.newsfeed.db.BurgerDB;
import com.example.android.newsfeed.db.OrdersDB;
import com.example.android.newsfeed.model.Burger;

public class OrderActivity extends AppCompatActivity {
    Burger burger = null;
    TextView name, price, desc;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        name = findViewById(R.id.orderName);
        price = findViewById(R.id.orderPrice);
        desc = findViewById(R.id.orderDesc);
        image = findViewById(R.id.orderImage);

        Bundle arguments = getIntent().getExtras();
        int id = (int) arguments.get("id");
        burger = BurgerDB.getBurger(id);

        name.setText(burger.getName());
        price.setText(burger.getPrice() + " тг");
        desc.setText(burger.getDescryption());
        image.setImageResource(burger.getPhoto());
    }

    public void onClickOrder(View view) {
        OrdersDB.addOrder(burger);
        Toast.makeText(getApplicationContext(),
                "Тапсырыс сәтті қабылданды!", Toast.LENGTH_SHORT).show();
        Intent settingsIntent = new Intent(this, MainActivity.class);
        startActivity(settingsIntent);
    }
}