package ocdev.com.br.lyricseditor.Loader;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;

import ocdev.com.br.lyricseditor.data.FavoriteContract;

/**
 * Created by Oto on 25/04/2018.
 */

public class CarregarListadeFavoritos implements LoaderManager.LoaderCallbacks<Cursor> {
    private Context mContext;
    private GetResultadosListadeFavoritos getResultadosListadeFavoritos;


    public interface GetResultadosListadeFavoritos {
        void getDataCursor(Cursor mCursor);
    }

    public CarregarListadeFavoritos(GetResultadosListadeFavoritos getResultadosListadeFavoritos, Context mContext) {
        this.getResultadosListadeFavoritos = getResultadosListadeFavoritos;
        this.mContext = mContext;

    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        return new AsyncTaskLoader<Cursor>(mContext) {
            Cursor mTaskData = null;

            @Override
            protected void onStartLoading() {
                if (mTaskData != null) {
                    deliverResult(mTaskData);
                } else {
                    forceLoad();
                }

            }

            @Override
            public Cursor loadInBackground() {
                try {
                    return mContext.getContentResolver().query(FavoriteContract.FavoriteEntry.CONTENT_URI,
                            null,
                            null,
                            null,
                            FavoriteContract.FavoriteEntry._ID);

                } catch (Exception e) {
                    e.printStackTrace();

                    return null;
                }

            }

            public void deliverResult(Cursor data) {
                mTaskData = data;

                super.deliverResult(data);
            }

        };

    }


    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        getResultadosListadeFavoritos.getDataCursor(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
