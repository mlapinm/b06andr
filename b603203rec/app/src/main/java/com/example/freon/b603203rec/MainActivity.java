package com.example.freon.b603203rec;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private AdapterLittle mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycleView);

        ArrayList<ItemLittle> itemLittles = new ArrayList<>();
        itemLittles.add(new ItemLittle(R.drawable.ic_android2, "Line 11", "Line 12"));
        itemLittles.add(new ItemLittle(R.drawable.ic_audio, "Line 21", "Line 22"));
        itemLittles.add(new ItemLittle(R.drawable.ic_sun, "Line 31", "Line 32"));

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AdapterLittle(itemLittles);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnClickListener(new AdapterLittle.OnClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this,
                        "Position: " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
