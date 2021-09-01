package ocdev.com.br.lyricseditor.Widget;

import android.annotation.TargetApi;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;

import ocdev.com.br.lyricseditor.R;

/**
 * Implementation of App Widget functionality.
 */
public class LetraWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId,String receitaswidget) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.letra_widget);
        views.setTextViewText(R.id.appwidget_text, receitaswidget);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);

    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        LetraWidgetService.startActionUpdateLetraWidgets(context);

    }

    public static void updateIngredientesWidgets(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds,String receitaswidget) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId,receitaswidget);
        }
    }




    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager,
                                          int appWidgetId, Bundle newOptions) {
        LetraWidgetService.startActionUpdateLetraWidgets(context);
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    }









}

