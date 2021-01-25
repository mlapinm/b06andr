package com.example.freon.b609192palette;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout layoutRoot;
    private TextView textViewTitle;
    private TextView textViewBody;
    private ImageView imageView;

    private Palette.Swatch vibrantSwatch;
    private Palette.Swatch lightVibrantSwatch;
    private Palette.Swatch darkVibrantSwatch;
    private Palette.Swatch mutedSwatch;
    private Palette.Swatch lightMutedSwatch;
    private Palette.Swatch darkMutedSwatch;

    private int swatchNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutRoot = findViewById(R.id.layoutRoot);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewBody = findViewById(R.id.textViewBody);
        imageView = findViewById(R.id.imageView);

        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();

        Palette.from(bitmap).maximumColorCount(32).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                vibrantSwatch = palette.getVibrantSwatch();
                lightVibrantSwatch = palette.getLightVibrantSwatch();
                darkVibrantSwatch = palette.getDarkVibrantSwatch();
                mutedSwatch = palette.getMutedSwatch();
                lightMutedSwatch = palette.getLightMutedSwatch();
                darkMutedSwatch = palette.getDarkMutedSwatch();
            }
        });

    }

    public void nextSwatch(View view) {
        Palette.Swatch currentSwatch = null;

        switch (swatchNumber){
            case 0:
                currentSwatch = vibrantSwatch;
                textViewTitle.setText("vibrant");
                break;
            case 1:
                currentSwatch = lightVibrantSwatch;
                textViewTitle.setText("light Vibrant");
                break;
            case 2:
                currentSwatch = darkVibrantSwatch;
                textViewTitle.setText("dark Vibrant");
                break;
            case 3:
                currentSwatch = mutedSwatch;
                textViewTitle.setText("muted");
                break;
            case 4:
                currentSwatch = lightMutedSwatch;
                textViewTitle.setText("light Muted");
                break;
            case 5:
                currentSwatch = darkMutedSwatch;
                textViewTitle.setText("dark Muted");
                break;
        }
        if(currentSwatch != null){
            layoutRoot.setBackgroundColor(currentSwatch.getRgb());
            textViewTitle.setTextColor(currentSwatch.getTitleTextColor());
            textViewBody.setTextColor(currentSwatch.getBodyTextColor());
        }else {
            layoutRoot.setBackgroundColor(Color.WHITE);
            textViewTitle.setTextColor(Color.BLUE);
            textViewBody.setTextColor(Color.BLUE);
        }

        if(swatchNumber < 5){
            swatchNumber++;
        }else {
            swatchNumber = 0;
        }
    }
}