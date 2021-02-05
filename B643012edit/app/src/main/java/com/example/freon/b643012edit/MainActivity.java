package com.example.freon.b643012edit;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String EXTRA_TEXT1 = "text1";
    public static String EXTRA_TEXT2 = "text2";
    public static String EXTRA_ICON = "icon";


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
        itemLittles.add(new ItemLittle(R.drawable.ic_android2, "One", "Line 12"));
        itemLittles.add(new ItemLittle(R.drawable.ic_audio, "Two", "Line 22"));
        itemLittles.add(new ItemLittle(R.drawable.ic_sun, "Three", "Line 32"));
        itemLittles.add(new ItemLittle(R.drawable.ic_sun, "Four", "Line 32"));

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AdapterLittle(itemLittles);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new AdapterLittle.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "Position: " + position, Toast.LENGTH_SHORT).show();
//                itemLittles.get(position).setmText1("checked");
//                mAdapter.notifyItemChanged(position);
                startNewActivity(position);
            }

            @Override
            public void onDeleteClick(int position) {
                itemLittles.remove(position);
                mAdapter.notifyItemRemoved(position);
            }
        });

        EditText editText = findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());

            }
        });
    }

    private void filter(String text) {
        ArrayList<ItemLittle> filteredList = new ArrayList<>();

        for(ItemLittle item : itemLittles){
            if(item.getmText1().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }

        }

       mAdapter.filterList(filteredList);

    }

    public void startNewActivity(int position){
        Intent intent = new Intent(this, SecondActivity.class);
        int icon = itemLittles.get(position).getmImageResource();
        Toast.makeText(this, "" + icon, Toast.LENGTH_SHORT).show();
        intent.putExtra(EXTRA_ICON, icon);
        intent.putExtra(EXTRA_TEXT1, itemLittles.get(position).getmText1().toString());
        intent.putExtra(EXTRA_TEXT2, itemLittles.get(position).getmText2().toString());
        startActivity(intent);

    }
}
