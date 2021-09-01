package ocdev.com.br.lyricseditor.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static ocdev.com.br.lyricseditor.data.FavoriteContract.FavoriteEntry.TABLE_NAME;

/**
 * Created by Oto on 17/04/2018.
 */

public class FavoriteContentProvider extends ContentProvider {
    private FavoriteDbHelper mFavoriteDbHelper;
    public static final int FAVORITES = 100;
    public static final int FAVORITES_WITH_ID = 101;
    private static final UriMatcher sUriMatcher = buildUriMatcher();

    public static UriMatcher buildUriMatcher() {

        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(FavoriteContract.AUTHORITY, FavoriteContract.PATH_FAVORITES, FAVORITES);
        uriMatcher.addURI(FavoriteContract.AUTHORITY, FavoriteContract.PATH_FAVORITES + "/*", FAVORITES_WITH_ID);
        return uriMatcher;
    }


    @Override
    public boolean onCreate() {
        Context contxt = getContext();
        mFavoriteDbHelper = new FavoriteDbHelper(contxt);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        final SQLiteDatabase db = mFavoriteDbHelper.getWritableDatabase();
        int match = sUriMatcher.match(uri);
        Cursor cursor;
        switch (match) {
            case FAVORITES:
                cursor = db.query(TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);

                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);

            case FAVORITES_WITH_ID: {
                String normalizedUtcDateString = uri.getLastPathSegment();
                String[] selectionArguments = new String[]{normalizedUtcDateString};
                cursor = mFavoriteDbHelper.getReadableDatabase().query(
                        TABLE_NAME,
                        projection,
                        FavoriteContract.FavoriteEntry.COLUMN_ID_LETRA + " = ? ",
                        selectionArguments,
                        null,
                        null,
                        sortOrder);
                break;
            }
        }
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;

    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        final SQLiteDatabase db = mFavoriteDbHelper.getWritableDatabase();
        int match = sUriMatcher.match(uri);
        Uri returnUri;
        switch (match) {
            case FAVORITES:
                long id = db.insert(TABLE_NAME, null, values);
                if (id > 0) {
                    returnUri = ContentUris.withAppendedId(FavoriteContract.FavoriteEntry.CONTENT_URI, id);
                } else {
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                }
                break;

            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return returnUri;

    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        final SQLiteDatabase db = mFavoriteDbHelper.getWritableDatabase();
        int match = sUriMatcher.match(uri);
        int tasksDeleted;
        switch (match) {
            case FAVORITES_WITH_ID:
                String id = uri.getPathSegments().get(1);
                tasksDeleted = db.delete(TABLE_NAME, selection, new String[]{id});
                break;


            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

        if (tasksDeleted != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return tasksDeleted;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
