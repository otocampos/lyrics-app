package ocdev.com.br.lyricseditor.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Oto on 17/04/2018.
 */

public class FavoriteDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "lyrics.db";
    private static final int VERSION = 1;

    public FavoriteDbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CREATE_TABLE = "CREATE TABLE " + FavoriteContract.FavoriteEntry.TABLE_NAME + " (" +
                FavoriteContract.FavoriteEntry._ID + " INTEGER PRIMARY KEY, " +
                FavoriteContract.FavoriteEntry.COLUMN_ID_ART + " TEXT, " +
                FavoriteContract.FavoriteEntry.COLUMN_NOME_ART + " TEXT," +
                FavoriteContract.FavoriteEntry.COLUMN_URL_ART + " TEXT," +
                FavoriteContract.FavoriteEntry.COLUMN_URL_IMG_ART + " TEXT," +

                FavoriteContract.FavoriteEntry.COLUMN_ID_LETRA + " TEXT," +
                FavoriteContract.FavoriteEntry.COLUMN_NOME_MUS + " TEXT," +
                FavoriteContract.FavoriteEntry.COLUMN_LETRA_LANG + " INTEGER," +
                FavoriteContract.FavoriteEntry.COLUMN_LETRA_URL + " TEXT," +
                FavoriteContract.FavoriteEntry.COLUMN_LETRA_MUS + " TEXT," +

                FavoriteContract.FavoriteEntry.COLUMN_TRANSLATE_ID + " TEXT," +
                FavoriteContract.FavoriteEntry.COLUMN_TRANSLATE_LANG + " INTEGER," +
                FavoriteContract.FavoriteEntry.COLUMN_TRANSLATE_TEXT + " TEXT," +
                FavoriteContract.FavoriteEntry.COLUMN_TRANSLATE_URL + " TEXT);";


        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + FavoriteContract.FavoriteEntry.TABLE_NAME);
        onCreate(db);
    }





}
