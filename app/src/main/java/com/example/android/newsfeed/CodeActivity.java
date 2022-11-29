package com.example.android.newsfeed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android.newsfeed.db.CodeDB;
import com.example.android.newsfeed.db.UsersDB;
import com.example.android.newsfeed.model.User;

public class CodeActivity extends AppCompatActivity {
    private User user = null;
    private TextView cod;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.code);
        cod = findViewById(R.id.cod);
        Bundle arguments = getIntent().getExtras();
        user = (User)arguments.get("user");
    }

    public void onClickCheck(View view) {
        String code = CodeDB.getCode(user.getEmail());
        String inputCode = cod.getText().toString();
        System.out.println(code);
        System.out.println(inputCode);
        if (code.equals(inputCode)) {
            UsersDB.addUser(user);
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Тексеру сәтті өтті", Toast.LENGTH_SHORT);
            toast.show();
            Intent settingsIntent = new Intent(this, LoginActivity.class);
            startActivity(settingsIntent);
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Қате код!", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}
