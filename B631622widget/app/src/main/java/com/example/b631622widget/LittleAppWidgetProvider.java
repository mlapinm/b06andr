package com.example.b631622widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

import static com.example.b631622widget.LittleAppWidgetConfig.KEY_BUTTON_TEXT;
import static com.example.b631622widget.LittleAppWidgetConfig.SHARED_PRES;

public class LittleAppWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        for (int appWidgetId : appWidgetIds){
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context,0, intent,0);

            SharedPreferences prefs = context.getSharedPreferences(SHARED_PRES, Context.MODE_PRIVATE);
            String buttonText = prefs.getString(KEY_BUTTON_TEXT + appWidgetId, "Press me");

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.little_widget);
            views.setCharSequence(R.id.little_widget_button, "setText", buttonText);

            views.setOnClickPendingIntent(R.id.little_widget_button, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
