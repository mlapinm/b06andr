package com.example.b621052recy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<LittleItem> items = new ArrayList<>();
    private RecyclerView recyclerView;
    private LittleAdapter littleAdapter;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = Volley.newRequestQueue(this);

        parseJSON();

    }

    private void parseJSON() {
        String url = "https://pixabay.com/api/?key=20017739-d242111bbff80044b979d4d99&q=yellow+flowers&image_type=photo";

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject hit = jsonArray.getJSONObject(i);
                                String creator = hit.getString("user");
                                String imageUrl = "";
                                imageUrl = hit.getString("webformatURL");
                                imageUrl = hit.getString("previewURL");
                                int likes = hit.getInt("likes");
                                items.add(new LittleItem(
                                        imageUrl,
                                        creator,
                                        likes
                                ));
                            }
                            littleAdapter = new LittleAdapter(MainActivity.this, items);
                            recyclerView.setAdapter(littleAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }
        );
        requestQueue.add(request);

    }
}