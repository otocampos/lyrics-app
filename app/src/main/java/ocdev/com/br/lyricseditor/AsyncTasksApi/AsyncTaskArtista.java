package ocdev.com.br.lyricseditor.AsyncTasksApi;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import java.io.IOException;
import java.net.URL;

import ocdev.com.br.lyricseditor.Interfaces.ResultadoAsynctaskArtistas;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.ResultArtista;
import ocdev.com.br.lyricseditor.Utils.NetworkUtils;
import ocdev.com.br.lyricseditor.Utils.OpenJsonUtils;

/**
 * Created by Oto on 08/03/2018.
 */

public class AsyncTaskArtista extends AsyncTask<String, Void, ResultArtista> {

    ResultadoAsynctaskArtistas mResultadoArtista;
    ProgressBar progressBar;


    public AsyncTaskArtista(ResultadoAsynctaskArtistas mResultadoArtista, View pb) {
        this.mResultadoArtista = mResultadoArtista;
        this.progressBar = (ProgressBar) pb;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ResultArtista doInBackground(String... nomeDoArtista) {
        URL UrlConsultaArtistaunico = NetworkUtils.buildUrlArtistaUnico(nomeDoArtista[0]);
        try {
            String JsonArtistaUnico = NetworkUtils.getResponseFromHttpUrl(UrlConsultaArtistaunico);

            return OpenJsonUtils.ResultadoArtistaUnico(JsonArtistaUnico);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    protected void onPostExecute(ResultArtista resultArtista) {

        mResultadoArtista.getResultadoArtista(resultArtista);
        progressBar.setVisibility(View.GONE);
    }
}
