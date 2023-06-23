package com.example.lakshankodithuwaku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    TextView data;
    EditText username;
    EditText password;
    String url= "http://123.231.9.43:3999";

    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = findViewById(R.id.data);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login=findViewById(R.id.login);

        String testname = "Lakshan";
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendJsonRequest(url, username.getText().toString(), password.getText().toString(), new JsonRequestCallback() {
                    @Override
                    public void onResponseString(String response) {
                        System.out.println(response);
                        if(response.equals("success")){
                            Intent intent=new Intent(MainActivity.this,home.class);
                            startActivity(intent);
                        }
                    }
                });

            }
        });
    }

    public void sendJsonRequest(String url, String username, String password, JsonRequestCallback callback) {
        try {
            // Create the JSON object
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("username", username);
            jsonBody.put("password", password);

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, jsonBody, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        String res_desc = response.getString("res_desc");
                        data.setText(res_desc);


                        SharedPreferences sharedPreferences = getSharedPreferences("SharedPref_CBA", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("id", response.getJSONObject("user_data").getString("id"));
                        editor.putString("email", response.getJSONObject("user_data").getString("email"));
                        editor.putString("name", response.getJSONObject("user_data").getString("name"));
                        editor.putString("dob", response.getJSONObject("user_data").getString("dob"));
                        editor.putString("gender", response.getJSONObject("user_data").getString("gender"));
                        editor.putString("company", response.getJSONObject("user_data").getString("company"));
                        editor.putString("position", response.getJSONObject("user_data").getString("position"));
                        editor.apply();

                        // Invoke the callback with the response string
                        callback.onResponseString(res_desc);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // Handle error
                    error.printStackTrace();
                }
            });
            Volley.newRequestQueue(this).add(request);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}