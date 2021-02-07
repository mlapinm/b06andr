package com.example.b631612widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class LittleAppWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        for (int appWidgetId : appWidgetIds){
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context,0, intent,0);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.little_widget);

            views.setOnClickPendingIntent(R.id.little_widget_button, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
