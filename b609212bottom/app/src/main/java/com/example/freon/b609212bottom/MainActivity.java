package com.example.freon.b609212bottom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
    private TextView textViewState;
    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewState = findViewById(R.id.textViewState);
        View bottomSheet = findViewById(R.id.bottom_sheet);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch(newState){
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        textViewState.setText("Collapsed");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        textViewState.setText("Dragging...");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        textViewState.setText("Expanded");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        textViewState.setText("Hidden");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        textViewState.setText("Settling...");
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                textViewState.setText("Sliding...");
            }
        });
    }

    public void onExpand(View view) {
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        Toast.makeText(this, "Expanded", Toast.LENGTH_SHORT).show();
    }

    public void onCollaps(View view) {
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        Toast.makeText(this, "Collapsed", Toast.LENGTH_SHORT).show();
    }



}