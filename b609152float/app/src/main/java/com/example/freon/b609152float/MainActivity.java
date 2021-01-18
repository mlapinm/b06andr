package com.example.freon.b609152float;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButtonShow(View view) {
        revealFab();

    }

    public void onClickButtonHide(View view) {
        hideFab();

    }

    private void revealFab() {
        View view = findViewById(R.id.floatingActionButton);

        int cx = view.getWidth() / 2;
        int cy = view.getHeight() / 2;

        float finalRadius = (float) Math.hypot(cx, cy);

        Animator animator = ViewAnimationUtils.createCircularReveal(view,
                cx, cy, 0, finalRadius);
        view.setVisibility(View.VISIBLE);
        animator.start();
    }

    private void hideFab() {
        View view = findViewById(R.id.floatingActionButton);

        int cx = view.getWidth() / 2;
        int cy = view.getHeight() / 2;

        float initialRadius = (float) Math.hypot(cx, cy);

        Animator animator = ViewAnimationUtils.createCircularReveal(view,
                cx, cy, initialRadius, 0);

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(View.INVISIBLE);
            }
        });
        animator.start();
    }
}