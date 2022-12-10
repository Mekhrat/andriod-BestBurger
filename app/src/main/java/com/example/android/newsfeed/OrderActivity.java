package com.example.android.newsfeed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.newsfeed.db.BurgerDB;
import com.example.android.newsfeed.db.OrdersDB;
import com.example.android.newsfeed.model.Burger;
import com.example.android.newsfeed.utils.Type;

public class OrderActivity extends AppCompatActivity {
    Burger burger = null;
    TextView name, price, desc;
    ImageView image;
    Type type;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        name = findViewById(R.id.orderName);
        price = findViewById(R.id.orderPrice);
        desc = findViewById(R.id.orderDesc);
        image = findViewById(R.id.orderImage);
        button = findViewById(R.id.send);

        Bundle arguments = getIntent().getExtras();
        int id = (int) arguments.get("id");
        System.out.println("id = " + id);
        type = (Type) arguments.get("type");

        if (type == Type.ORDER) {
            button.setBackgroundColor(Color.GREEN);
            burger = BurgerDB.getBurger(id);
        }
        else {
            button.setBackgroundColor(Color.RED);
            burger = OrdersDB.getOrders().get(id);
        }

        name.setText(burger.getName());
        price.setText(burger.getPrice() + " тг");
        desc.setText(burger.getDescryption());
        image.setImageResource(burger.getPhoto());
        button.setText(type == Type.ORDER ? "Тапсырыс беру" : "Тапсырысты жою");
    }

    public void onClickOrder(View view) {
        if (type.equals(Type.ORDER)) {
            OrdersDB.addOrder(burger);
            Toast.makeText(getApplicationContext(),
                    "Тапсырыс сәтті қабылданды!", Toast.LENGTH_SHORT).show();
        }
        else {
            OrdersDB.deleteOrder(burger);
            Toast.makeText(getApplicationContext(),
                    "Тапсырыс жойылды!", Toast.LENGTH_SHORT).show();
        }
        Intent settingsIntent = new Intent(this, MainActivity.class);
        startActivity(settingsIntent);
    }
}