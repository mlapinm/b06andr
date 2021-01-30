package com.example.b615022sqli;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase database;
    private GroceryAdapter adapter;
    private EditText editTextName;
    private TextView textViewAmount;
    private int amount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GroceryDBHelper dbHelper = new GroceryDBHelper(this);
        database = dbHelper.getWritableDatabase();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GroceryAdapter(this, getAllItems());
        recyclerView.setAdapter(adapter);

        editTextName = findViewById(R.id.edit_text_name);
        textViewAmount = findViewById(R.id.text_view_amount);

        Button buttonIncrease = findViewById(R.id.button_increase);
        Button buttonDecrease = findViewById(R.id.button_decrease);
        Button buttonAdd = findViewById(R.id.button_add);


    }

    public void onDecrease(View view) {
        amount--;
        textViewAmount.setText(String.valueOf(amount));
    }

    public void onIncrease(View view) {
        amount++;
        textViewAmount.setText(String.valueOf(amount));
    }

    public void onAdd(View view) {
        if(editTextName.getText().toString().trim().length() == 0 || amount == 0){
            return;
        }
        String name = editTextName.getText().toString().trim();
        ContentValues cvs = new ContentValues();
        cvs.put(GroceryContract.GroceryEntry.COLUMN_NAME, name);
        cvs.put(GroceryContract.GroceryEntry.COLUMN_AMOUNT, amount);

        database.insert(GroceryContract.GroceryEntry.TABLE_NAME, null, cvs);
        adapter.swapCursor(getAllItems());
    }

    private Cursor getAllItems() {
        return  database.query(
                GroceryContract.GroceryEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                GroceryContract.GroceryEntry.COLUMN_TIMESTAMP + " DESC"
        );
    }
}