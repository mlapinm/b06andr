package com.example.freon.b609222dodge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View bottomSheet = findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

    }

    public void onFab(View view) {
        Snackbar.make(view, "This is a Snackbar",
                Snackbar.LENGTH_LONG).show();
    }

    public void onButton(View view) {
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

}