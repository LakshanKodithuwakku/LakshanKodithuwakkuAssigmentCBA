package com.example.lakshankodithuwaku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class home extends AppCompatActivity {
    TextView view;
    private Button view_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        view = findViewById(R.id.data_view);
        view_button = findViewById(R.id.button_view);

        view_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("SharedPref_CBA", MODE_PRIVATE);
                String id = sharedPreferences.getString("id", "");
                String email = sharedPreferences.getString("email", "");
                String name = sharedPreferences.getString("name", "");
                String dob = sharedPreferences.getString("dob", "");
                String gender = sharedPreferences.getString("gender", "");
                String company = sharedPreferences.getString("company", "");
                String position = sharedPreferences.getString("position", "");
                view.setText("Id: "+ id +"\n\n"+ "email: " + email+"\n\n"+"Name: "+ name +"\n\n"+ "DOB: " + dob+"\n\n"+"Gender: "+
                        gender +"\n\n"+ "Company: " + company+"\n\n"+"Position: "+ position);
            }
        });
    }
}