package ocdev.com.br.lyricseditor.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;

import ocdev.com.br.lyricseditor.Constants.Constants;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.ResultArtista;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Letra.ResultadoLetras;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Result;

/**
 * Created by Oto on 01/03/2018.
 */

public class OpenJsonUtils {

    public static Gson gson;

    public OpenJsonUtils() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }

    public static ArrayList<Result> getListaResultados(ArrayList<String> listadeEscopos) {
        Result resultsmusica = gson.fromJson(listadeEscopos.get(Constants.RANKING_LISTA_INDEX_MUSICAS_LYRICS), Result.class);
        Result resultsartnacional = gson.fromJson(listadeEscopos.get(Constants.RANKING_LISTA_INDEX_ARTISTAS_NACIONAL), Result.class);
        Result resultsartinternacional = gson.fromJson(listadeEscopos.get(Constants.RANKING_LISTA_INDEX_ARTISTAS_INTERNACIONAL), Result.class);
        Result resultsmusicatraducao = gson.fromJson(listadeEscopos.get(Constants.RANKING_LISTA_INDEX_MUSICAS_TRADUCOES), Result.class);

        ArrayList<Result> listaderesultado = new ArrayList<>();
        listaderesultado.add(resultsmusica);
        listaderesultado.add(resultsartnacional);
        listaderesultado.add(resultsartinternacional);
        listaderesultado.add(resultsmusicatraducao);
        return listaderesultado;

    }

    public static ResultArtista ResultadoArtistaUnico(String jsonArtistaUnico) {
        try {
            ResultArtista resultArtista = gson.fromJson(jsonArtistaUnico, ResultArtista.class);
            return resultArtista;

        }catch (IllegalStateException | JsonSyntaxException exception){
            exception.toString();
        }
        return null;
    }
    public static ResultadoLetras ResultadoLetradeMusica(String jsonletrademusica) {
        try {
            ResultadoLetras resultadoLetras = gson.fromJson(jsonletrademusica, ResultadoLetras.class);
            return resultadoLetras;

        }catch (IllegalStateException | JsonSyntaxException exception){
            exception.toString();
        }
        return null;
    }

}
