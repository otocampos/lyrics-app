package ocdev.com.br.lyricseditor.Utils;

import android.content.Context;
import android.content.res.Configuration;

/**
 * Created by Oto on 01/05/2018.
 */

public class ScreenUtils {

    public static int RecuperarNumerodeColunas(Context mContext) {
        int value = mContext.getResources().getConfiguration().orientation;
        int colunasrecyclerview = 0;
        if (value == Configuration.ORIENTATION_PORTRAIT) {
            colunasrecyclerview = 2;
        }
        if (value == Configuration.ORIENTATION_LANDSCAPE) {
            colunasrecyclerview = 3;
        }
        return colunasrecyclerview;
    }


}
