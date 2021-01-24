package com.example.b617032pref;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<LittleItem> items;
    RecyclerView recyclerView;
    AdapterLittle adapterLittle;
    EditText editTextLine1;
    EditText editTextLine2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLine1 = findViewById(R.id.editTextLine1);
        editTextLine2 = findViewById(R.id.editTextLine2);
        recyclerView = findViewById(R.id.recyclerView);

        items = new ArrayList<>();
        items.add(new LittleItem("Line 1", "Line 2"));

        adapterLittle = new AdapterLittle(items);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterLittle);
    }

    public void onInsert(View view) {
        items.add(new LittleItem(
                editTextLine1.getText().toString(),
                editTextLine2.getText().toString()
        ));
        adapterLittle.notifyItemInserted(items.size());
        Toast.makeText(this, "Insert", Toast.LENGTH_SHORT).show();
    }
}