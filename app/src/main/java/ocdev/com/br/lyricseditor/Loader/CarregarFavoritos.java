package ocdev.com.br.lyricseditor.Loader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;

import ocdev.com.br.lyricseditor.data.FavoriteContract;

import static ocdev.com.br.lyricseditor.Constants.Constants.ID_DETAIL_LOADER;

/**
 * Created by Oto on 17/04/2018.
 */

public class CarregarFavoritos implements LoaderManager.LoaderCallbacks<Cursor> {
    private String id_letra;
    private Context mContext;
    public static final int INDEX_FILME_ID = 0;
    private ResultadoConferirFavoritado resultadoConferirFavoritado;


    public interface ResultadoConferirFavoritado {
        void isFavoritado(boolean favoritado, String nomeart, String nomemus, String urlimg, String urlmus, String letramus);
    }


    public CarregarFavoritos(ResultadoConferirFavoritado resultadoConferirFavoritado) {
        this.resultadoConferirFavoritado = resultadoConferirFavoritado;
    }

    public CarregarFavoritos() {

    }

    @SuppressLint("StaticFieldLeak")
    @Override
    public Loader<Cursor> onCreateLoader(int loaderId, Bundle args) {
        Uri uri_item = FavoriteContract.FavoriteEntry.CONTENT_URI.buildUpon().appendPath(id_letra).build();

        switch (loaderId) {
            case ID_DETAIL_LOADER:

                return new CursorLoader(mContext,
                        uri_item,
                        new String[]{FavoriteContract.FavoriteEntry.COLUMN_ID_LETRA, FavoriteContract.FavoriteEntry.COLUMN_NOME_MUS,
                                FavoriteContract.FavoriteEntry.COLUMN_NOME_ART,
                                FavoriteContract.FavoriteEntry.COLUMN_LETRA_MUS,
                                FavoriteContract.FavoriteEntry.COLUMN_URL_IMG_ART,
                                FavoriteContract.FavoriteEntry.COLUMN_LETRA_URL,
                        },
                        null,
                        null,
                        null);

            default:
                throw new RuntimeException("Loader Not Implemented: " + loaderId);


        }

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {


        String iddaletra;

        switch (loader.getId()) {
            case ID_DETAIL_LOADER:
                boolean cursorHasValidData = false;
                if (data != null && data.moveToFirst()) {
            /* We have valid data, continue on to bind the data to the UI */
                    cursorHasValidData = true;
                }

                if (!cursorHasValidData) {
            /* No data to display, simply return and do nothing */
                    return;
                }
                Log.v("oioto", data.getString(1));

                int nome_musica = data.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_NOME_MUS);
                int nome_artista = data.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_NOME_ART);
                int letra_mus = data.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_LETRA_MUS);
                int url_img_artista = data.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_URL_IMG_ART);
                final int url_letra = data.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_LETRA_URL);

                String urlletra = data.getString(url_letra);
                String letramus = data.getString(letra_mus);
                String musica = data.getString(nome_musica);
                String artista = data.getString(nome_artista);
                String img = data.getString(url_img_artista);


                iddaletra = data.getString(INDEX_FILME_ID);

                if (iddaletra.equals(id_letra)) {


                    resultadoConferirFavoritado.isFavoritado(true, artista, musica, img, urlletra, letramus);
                }


        }

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    public void setIdfavorito(Context context, String idletra) {
        this.mContext = context;
        this.id_letra = idletra;
    }
}
