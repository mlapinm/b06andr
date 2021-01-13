package com.example.freon.b605204rec6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String EXTRA_ITEM_LITTLE = "EXTRA_ITEM_LITTLE";



    private RecyclerView mRecyclerView;
    private AdapterLittle mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ItemLittle> itemLittles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycleView);

        itemLittles = new ArrayList<>();
        itemLittles.add(new ItemLittle(R.drawable.ic_android2, "Line 11", "Line 12"));
        itemLittles.add(new ItemLittle(R.drawable.ic_audio, "Line 21", "Line 22"));
        itemLittles.add(new ItemLittle(R.drawable.ic_sun, "Line 31", "Line 32"));

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AdapterLittle(itemLittles);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new AdapterLittle.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                startNewActivity(position);
            }
        });
    }
    public void startNewActivity(int position){
        Intent intent = new Intent(this, SecondActivity.class);

        ItemLittle itemLittle = itemLittles.get(position);
        intent.putExtra(EXTRA_ITEM_LITTLE, itemLittle);
        startActivity(intent);
    }
}
