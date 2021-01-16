package com.example.b609062page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private String[] imageUrls = new String[]{
            "https://cdn.pixabay.com/photo/2021/01/05/01/50/elephants-5889403_1280.jpg",
            "https://cdn.pixabay.com/photo/2020/04/04/21/11/hummingbird-5003882_1280.jpg",
            "https://cdn.pixabay.com/photo/2020/12/27/15/51/pheasant-5864490_1280.jpg",
            "https://cdn.pixabay.com/photo/2021/01/04/21/46/nutria-5888958_1280.jpg",
            "https://cdn.pixabay.com/photo/2020/12/30/07/43/squirrel-5872759_1280.jpg",
            "https://cdn.pixabay.com/photo/2020/12/27/05/59/house-mouse-5863083_1280.jpg",
            "https://cdn.pixabay.com/photo/2020/12/10/05/17/flamingos-5819381_1280.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this, imageUrls);
        viewPager.setAdapter(adapter);

    }
}