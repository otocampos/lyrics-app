package ocdev.com.br.lyricseditor.AsyncTasksApi;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.URL;

import ocdev.com.br.lyricseditor.Interfaces.ResultadoAsynctaskLetra;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Letra.ResultadoLetras;
import ocdev.com.br.lyricseditor.Utils.NetworkUtils;
import ocdev.com.br.lyricseditor.Utils.OpenJsonUtils;

/**
 * Created by Oto on 11/03/2018.
 */

public class AsyncTaskLetra extends AsyncTask<String, Void, ResultadoLetras> {
    private ResultadoAsynctaskLetra mResultadoLetras;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    public AsyncTaskLetra(ResultadoAsynctaskLetra mResultadoLetras) {
        this.mResultadoLetras = mResultadoLetras;
    }

    @Override
    protected ResultadoLetras doInBackground(String... iddamusica) {
        int INDEX = 0;
        URL UrlConsultaLetradamusica = NetworkUtils.buildUrlLetradeMusica(iddamusica[INDEX]);
        try {
            String JsonLetra = NetworkUtils.getResponseFromHttpUrl(UrlConsultaLetradamusica);

            return OpenJsonUtils.ResultadoLetradeMusica(JsonLetra);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(ResultadoLetras resultadoLetras) {
        mResultadoLetras.getResultadoLetra(resultadoLetras);


    }
}
