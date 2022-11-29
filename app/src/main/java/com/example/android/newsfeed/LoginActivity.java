package com.example.android.newsfeed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.newsfeed.db.UsersDB;
import com.example.android.newsfeed.model.User;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText inputpassword, inputlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        inputlogin = findViewById(R.id.inputlogin);
        inputpassword = findViewById(R.id.inputpassword);
    }

    public void onClick(View view) {
        String email = inputlogin.getText().toString();
        String password = inputpassword.getText().toString();
        User user = UsersDB.getUserByEmail(email);
        if (!email.equals("") && !password.equals("")) {
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Сіз сәтті кірдіңіз!", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent settingsIntent = new Intent(this, MainActivity.class);
                    startActivity(settingsIntent);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Cіз енгізген құпия сөз қате!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Бұл аккаунт тіркелмеген!", Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Мәлеметтерді дұрыс толтырыңыз!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void register(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Тіркелу...", Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
