package com.example.b611242soft;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;
import net.yslibrary.android.keyboardvisibilityevent.util.UIUtil;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);

        KeyboardVisibilityEvent.setEventListener(this, new KeyboardVisibilityEventListener() {
            @Override
            public void onVisibilityChanged(boolean isOpen) {
                if (isOpen) {
                    Toast.makeText(MainActivity.this, "Keyboard opened", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Keyboard closed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onClickHide(View view) {
        UIUtil.hideKeyboard(this);
//        UIUtil.showKeyboard(this, editText);
    }


}