package ocdev.com.br.lyricseditor.data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Oto on 17/04/2018.
 */

public class FavoriteContract {
    public static final String AUTHORITY="ocdev.com.br.lyricseditor";
    public static final Uri BASE_CONTENT_URI= Uri.parse("content://" + AUTHORITY);
    public static final String PATH_FAVORITES = "favoritos";

    public static final class FavoriteEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_FAVORITES).build();
        public static final String TABLE_NAME = "favoritos";

        //CONTRACT ARTSITA
        public static final String COLUMN_ID_ART = "id_art";
        public static final String COLUMN_URL_IMG_ART = "img_art";
        public static final String COLUMN_URL_ART = "url_art";
        public static final String COLUMN_NOME_ART = "nome_art";

        //CONTRACT LETRA
        public static final String COLUMN_ID_LETRA = "id_letra";
        public static final String COLUMN_NOME_MUS = "nome_mus";
        public static final String COLUMN_LETRA_MUS = "letra_mus";
        public static final String COLUMN_LETRA_LANG = "letra_lang";
        public static final String COLUMN_LETRA_URL = "url_letra";

        //CONTRACT TRADUÇÃO
        public static final String COLUMN_TRANSLATE_ID = "tr_id";
        public static final String COLUMN_TRANSLATE_LANG = "tr_lang";
        public static final String COLUMN_TRANSLATE_URL = "tr_url";
        public static final String COLUMN_TRANSLATE_TEXT = "tr_text";
    }










}
