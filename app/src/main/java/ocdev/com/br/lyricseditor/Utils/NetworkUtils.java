package ocdev.com.br.lyricseditor.Utils;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Normalizer;
import java.util.Scanner;

import ocdev.com.br.lyricseditor.Constants.Constants;

/**
 * Created by Oto on 01/03/2018.
 */

public class NetworkUtils {


    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    public static URL buildUrlRankingMusicas(String tipodeRanking, String escopo) {
        Uri builtUri = Uri.parse(Constants.URL_BASE)
                .buildUpon()
                .appendPath(Constants.RANKING_BASE)
                .appendQueryParameter(Constants.TYPE, tipodeRanking)
                .appendQueryParameter(Constants.PERIOD, Constants.PERIOD_WEEK)
                .appendQueryParameter(Constants.ESCOPO, escopo)
                .appendQueryParameter(Constants.LIMITE, Constants.LIMITE_RANKING_MUSICA)

                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }


    public static URL buildUrlArtistaUnico(String nomeDoArtista) {
        Uri builtUri = Uri.parse(stripAccents(nomeDoArtista).replace(".html", " "))
                .buildUpon()
                .appendPath(Constants.INDEX_JS)
                .build();
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;

    }

    public static URL buildUrlLetradeMusica(String iddamusica) {
        Uri builtUri = Uri.parse(Constants.URL_BASE)
                .buildUpon()
                .appendPath(Constants.SEARCH_BASE)
                .appendQueryParameter(Constants.MUSICA_ID_BUSCA_PARAMETRO, iddamusica)
                .appendQueryParameter(Constants.EXTRA, Constants.EXTRA_RELMUS)
                .build();
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;

    }


    public static String stripAccents(String s) {
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").toLowerCase().replace(" ", "-").replace("'", " ");
        return s;
    }


    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public static void Compartilhar(Context context, String message) {

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, message);
        sendIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        sendIntent.setType("text/plain");
        context.startActivity(sendIntent);

    }


}
