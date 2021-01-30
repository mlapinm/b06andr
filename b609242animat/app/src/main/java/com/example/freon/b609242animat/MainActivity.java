package com.example.freon.b609242animat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;

import android.os.Bundle;
import android.text.Layout;
import android.transition.TransitionManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Placeholder placeholder;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placeholder = findViewById(R.id.placeholder);
        layout = findViewById(R.id.layout);
    }

    public void swapView(View view) {

        TransitionManager.beginDelayedTransition(layout);
        placeholder.setContentId(view.getId());

    }
}