package com.example.android.newsfeed;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.android.newsfeed.db.CodeDB;
import com.example.android.newsfeed.db.UsersDB;
import com.example.android.newsfeed.model.User;
import com.example.android.newsfeed.utils.CodeUtils;
import com.example.android.newsfeed.utils.LongOperation;
public class RegisterActivity extends Activity {

    private TextView firstname, lastname, address, phone, email, password1, password2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.registerEmail);
        password1 = findViewById(R.id.registerPassword1);
        password2 = findViewById(R.id.registerPassword2);
    }

    public void onCLick(View view) {
        String firstnameU = firstname.getText().toString();
        String lastnameU = lastname.getText().toString();
        String addressU = address.getText().toString();
        String phoneU = phone.getText().toString();
        String emailU = email.getText().toString();
        String password1U = password1.getText().toString();
        String password2U = password2.getText().toString();
        User user = new User(firstnameU,lastnameU,addressU,phoneU,emailU,password1U);

        if (!firstnameU.equals("") && !lastnameU.equals("") && !phoneU.equals("")
                && !emailU.equals("") && !password1U.equals("") && !password2U.equals("")) {
            if (UsersDB.checkEmail(emailU)) {
                if (password1U.equals(password2U)) {
                    String code = CodeUtils.generateCode();
                    System.out.println(code);
                    CodeDB.addCode(emailU,code);
                    new LongOperation(code,emailU).execute();
                    Intent settingsIntent = new Intent(this, CodeActivity.class);
                    settingsIntent.putExtra("user", user);
                    startActivity(settingsIntent);
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Құпия сөз поштаңызға жіберілді!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Құпия сөздер бірдей болу керек!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            } else {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Бұл пошта тіркеліп қойған!", Toast.LENGTH_SHORT);
                toast.show();
            }
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Міндетті мәндерді толтырыңыз!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}

