package com.example.freon.b603202rec;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextInsert, editTextRemove;
    Button buttonInsert, buttonRemove;
    ArrayList<ItemLittle> itemLittles;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInsert = findViewById(R.id.editTextInsert);
        editTextRemove = findViewById(R.id.editTextRemove);
        buttonInsert = findViewById(R.id.buttonInsert);
        buttonRemove = findViewById(R.id.buttonRemove);

        mRecyclerView = findViewById(R.id.recycleView);

        itemLittles = new ArrayList<>();
        itemLittles.add(new ItemLittle(R.drawable.ic_android2, "Line 11", "Line 12"));
        itemLittles.add(new ItemLittle(R.drawable.ic_audio, "Line 21", "Line 22"));
        itemLittles.add(new ItemLittle(R.drawable.ic_sun, "Line 31", "Line 32"));

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AdapterLittle(itemLittles);
        mRecyclerView.setAdapter(mAdapter);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(editTextInsert.getText().toString());
                insertItem(position);
            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });
    }

    private void insertItem(int position) {
        itemLittles.add(position, new ItemLittle(R.drawable.ic_android2, "Line 11", "Line 12"));
        mAdapter.notifyItemInserted(position);
    }

    private void removeItem(int position) {
        itemLittles.remove(position);
        mAdapter.notifyItemRemoved(position);
    }
}
