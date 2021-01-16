package com.example.b609052scal;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        String url = "https://cdn.pixabay.com/photo/2017/11/06/18/39/apple-2924531__480.jpg";
        url = "https://cdn.pixabay.com/photo/2017/11/06/18/39/apple-2924531_1280.jpg";
        Picasso.with(this)
                .load(url)
//                .resize(500, 0)
                .fit()
                .centerCrop()
                .into(imageView);
    }
}