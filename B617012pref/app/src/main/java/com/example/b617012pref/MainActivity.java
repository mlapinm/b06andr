package com.example.b617012pref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonApply;
    Button buttonSave;
    EditText editText;
    TextView textView;
    Switch switchA;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String SWITCH_A = "switchA";

    private String text;
    private Boolean checkedOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        switchA = findViewById(R.id.switchA);

        loadData();
        updateViews();

    }

    public void onApply(View view) {
        textView.setText(editText.getText().toString());
    }

    public void onSaveData(View view) {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString(TEXT, textView.getText().toString());
        editor.putBoolean(SWITCH_A, switchA.isChecked());
        editor.apply();
        Toast.makeText(this, "data saved", Toast.LENGTH_SHORT).show();

    }

    private void loadData(){
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = prefs.getString(TEXT, "");
        checkedOn = prefs.getBoolean(SWITCH_A, false);
    }
    private void updateViews() {
        textView.setText(text);
        switchA.setChecked(checkedOn);
    }

}