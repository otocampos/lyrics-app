package ocdev.com.br.lyricseditor.Widget;

import android.app.IntentService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import ocdev.com.br.lyricseditor.R;
import ocdev.com.br.lyricseditor.data.FavoriteContract;

import static ocdev.com.br.lyricseditor.data.FavoriteContract.BASE_CONTENT_URI;
import static ocdev.com.br.lyricseditor.data.FavoriteContract.PATH_FAVORITES;

/**
 * Created by Oto on 29/04/2018.
 */

public class
LetraWidgetService extends IntentService {
    public static final String ACTION_UPDATE_INGREDIENTE_WIDGETS = "ocdev.com.br.lyricseditor.action.update_letra_widgets";


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     * <p>
     * // * @param name Used to name the worker thread, important only for debugging.
     */
    public LetraWidgetService() {
        super("LetraWidgetService");
    }

    public static void startActionUpdateLetraWidgets(Context context) {
        Intent intent = new Intent(context, LetraWidgetService.class);
        intent.setAction(ACTION_UPDATE_INGREDIENTE_WIDGETS);
        context.startService(intent);

    }

    private void UpdateIngredienteWidget() {
        Uri PLANT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_FAVORITES).build();
        Cursor cursor = getContentResolver().query(
                PLANT_URI,
                null,
                null,
                null,
                FavoriteContract.FavoriteEntry._ID
        );
        String letra = null;
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToLast();

            int ingredientesIndex = cursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_LETRA_MUS);

            letra = cursor.getString(ingredientesIndex);
            cursor.close();

            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this, LetraWidget.class));

            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.appwidget_text);

            LetraWidget.updateIngredientesWidgets(this, appWidgetManager, appWidgetIds, letra);
        }


    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_UPDATE_INGREDIENTE_WIDGETS.equals(action)) {
                UpdateIngredienteWidget();
            }

        }
    }
}
