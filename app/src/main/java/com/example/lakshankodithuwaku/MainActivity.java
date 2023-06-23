package com.example.lakshankodithuwaku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
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
    String url= "https://worldtimeapi.org/api/timezone/Asia/Colombo";//"https://123.231.9.43:3999";

    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }*/

        data = findViewById(R.id.data);

      /*  try {*/
            // Create the JSON object
           /* JSONObject jsonBody = new JSONObject();
            jsonBody.put("username", "test");
            jsonBody.put("password", "Test123");*/

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        String datetime = response.getString("datetime");//"res_desc");
                        data.setText(datetime);
                    }catch (Exception e){
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
     /*   }catch (JSONException e) {
            e.printStackTrace();
        }*/

        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,home.class);
                startActivity(intent);
            }
        });
    }
}