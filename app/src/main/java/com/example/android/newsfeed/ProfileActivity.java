package com.example.android.newsfeed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.android.newsfeed.db.CurrentUser;
import com.example.android.newsfeed.model.User;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {
    TextView fullname, email, phone, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        fullname = findViewById(R.id.profileFullname);
        email = findViewById(R.id.profileEmail);
        phone = findViewById(R.id.profileNomer);
        address = findViewById(R.id.profileAddress);

        User curUser = CurrentUser.getCurrentUser();
        System.out.println(curUser.getEmail());
        if (curUser != null) {
            fullname.setText(curUser.getFirstname() + " " + curUser.getLastname());
            email.setText(curUser.getEmail());
            phone.setText(curUser.getPhone());
            address.setText(curUser.getAddress());
        }
    }
}