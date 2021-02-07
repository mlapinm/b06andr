package com.example.b631622widget;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RemoteViews;

public class LittleAppWidgetConfig extends AppCompatActivity {
    public static final String SHARED_PRES = "prefs";
    public static final String KEY_BUTTON_TEXT = "keyButtonText";

    private int appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;
    private EditText editTextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_little_app_widget_config);


        Intent configIntent = getIntent();
        Bundle extras = configIntent.getExtras();
        if (extras != null) {
            appWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
        }

        Intent resultValue = new Intent();
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        setResult(RESULT_CANCELED, resultValue);


        if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish();
        }

        editTextButton = findViewById(R.id.editTextButton);


    }

    public void onConfirm(View view) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, intent, 0);

        String buttonText = editTextButton.getText().toString();

        RemoteViews remoteViews = new RemoteViews(this.getPackageName(), R.layout.little_widget);
        remoteViews.setOnClickPendingIntent(R.id.little_widget_button, pendingIntent);
        remoteViews.setCharSequence(R.id.little_widget_button,
                "setText",
                buttonText);
        remoteViews.setInt(R.id.little_widget_button,
                "setBackgroundColor",
                Color.GREEN);

        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);

        SharedPreferences prefs = getSharedPreferences(SHARED_PRES, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_BUTTON_TEXT + appWidgetId, buttonText);
        editor.apply();

        Intent resultValue = new Intent();
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        setResult(RESULT_OK, resultValue);
        finish();

    }
}