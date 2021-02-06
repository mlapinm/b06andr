package com.example.b613182volley2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        queue = VolleySingleton.getInstance(this).getRequestQueue();

    }

    public void onButton(View view) {

        String url = "https://api.androidhive.info/volley/person_object.json";
        url = "https://raw.githubusercontent.com/mlapinm/jnotebook/master/android/B613173json.json";

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        textView.setText("2");
                        try {
                            JSONArray jsonArray = response
                                    .getJSONArray("employees");
                            for(int i = 0; i<jsonArray.length(); i++){
                                JSONObject employee = jsonArray.getJSONObject(i);
                                String firstName = employee.getString("firstname");
                                int age = employee.getInt("age");
                                String mail = employee.getString("mail");

                                String text = "";
                                text += firstName + "\n";
                                text += String.valueOf(age) + "\n";
                                text += mail + "\n\n";
                                textView.append(text);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });
        queue.add(request);
    }
}