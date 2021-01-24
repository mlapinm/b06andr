package com.example.b617034pref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
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

        loadData();

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
    }

    public void onSave(View view) {
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        Gson gson = new Gson();
        String json = gson.toJson(items);
        editor.putString("items", json);
        editor.apply();
        Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show();
    }

    private void loadData() {
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = pref.getString("items", null);
        Type type = new TypeToken<ArrayList<LittleItem>>() {
        }.getType();
        items = gson.fromJson(json, type);
        if (items == null) {
            items = new ArrayList<>();
        }
    }
}