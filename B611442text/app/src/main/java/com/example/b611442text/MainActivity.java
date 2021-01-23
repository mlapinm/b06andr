package com.example.b611442text;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        String text = "BOLD and ITALIC and BOLD-ITALIC and UNDERLINE and STROKE-THROUGH";

        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        StyleSpan italicSpan = new StyleSpan(Typeface.ITALIC);
        StyleSpan boldItalicSpan = new StyleSpan(Typeface.BOLD_ITALIC);
        UnderlineSpan underlineSpan = new UnderlineSpan();
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();

        SpannableString ss = new SpannableString(text);

        ss.setSpan(boldSpan, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(italicSpan, 9, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(boldItalicSpan, 20, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(underlineSpan, 36, 45, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(strikethroughSpan, 50, 64, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);
    }
}