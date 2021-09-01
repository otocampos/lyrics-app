package ocdev.com.br.lyricseditor.AsyncTasksApi;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import ocdev.com.br.lyricseditor.Model.RankingMusica.Letra.ResultadoLetras;
import ocdev.com.br.lyricseditor.R;
import ocdev.com.br.lyricseditor.data.FavoriteContract;

import static ocdev.com.br.lyricseditor.Constants.Constants.MADONA_ID_ART;
import static ocdev.com.br.lyricseditor.Constants.Constants.MADONA_ID_LETRA;
import static ocdev.com.br.lyricseditor.Constants.Constants.MADONA_IMG_URL_ART;
import static ocdev.com.br.lyricseditor.Constants.Constants.MADONA_LETRA_LANG;
import static ocdev.com.br.lyricseditor.Constants.Constants.MADONA_LETRA_MUS;
import static ocdev.com.br.lyricseditor.Constants.Constants.MADONA_LETRA_URL;
import static ocdev.com.br.lyricseditor.Constants.Constants.MADONA_NOME_ART;
import static ocdev.com.br.lyricseditor.Constants.Constants.MADONA_NOME_MUS;
import static ocdev.com.br.lyricseditor.Constants.Constants.MADONA_TR_ID;
import static ocdev.com.br.lyricseditor.Constants.Constants.MADONA_TR_LANG;
import static ocdev.com.br.lyricseditor.Constants.Constants.MADONA_TR_TEXT;
import static ocdev.com.br.lyricseditor.Constants.Constants.MADONA_TR_URL;
import static ocdev.com.br.lyricseditor.Constants.Constants.MADONA_URL_ART;

/**
 * Created by Oto on 17/04/2018.
 */

public class ResultadosUnicosLetras {
    private String idartista;
    private String nomeartista;
    private String urlartista;
    private String urlImgArtista;


    private String idmusica;
    private String nomemusica;
    private Integer langmusica;
    private String urlmusica;
    private String textletramusica;

    private String trId;
    private Integer trLang;
    private String trUrl;
    private String trTextLetramusica;

    private ResultadoLetras resultadosUnicosLetras;
    private Activity activity;

    public ResultadosUnicosLetras(FragmentActivity activity) {
        this.activity = activity;
    }

    public ResultadosUnicosLetras() {
    }

    public String getIdartista() {
        return idartista;
    }

    public void setIdartista(String idartista) {
        this.idartista = idartista;
    }

    public String getNomeartista() {
        return nomeartista;
    }

    public void setNomeartista(String nomeartista) {
        this.nomeartista = nomeartista;
    }

    public String getUrlartista() {
        return urlartista;
    }

    public void setUrlartista(String urlartista) {
        this.urlartista = urlartista;
    }

    public String getIdmusica() {
        return idmusica;
    }

    public void setIdmusica(String idmusica) {
        this.idmusica = idmusica;
    }

    public String getNomemusica() {
        return nomemusica;
    }

    public void setNomemusica(String nomemusica) {
        this.nomemusica = nomemusica;
    }


    public String getUrlmusica() {
        return urlmusica;
    }

    public void setUrlmusica(String urlmusica) {
        this.urlmusica = urlmusica;
    }

    public String getTextletramusica() {
        return textletramusica;
    }

    public void setTextletramusica(String textletramusica) {
        this.textletramusica = textletramusica;
    }

    public String getTrId() {
        return trId;
    }

    public void setTrId(String trId) {
        this.trId = trId;
    }


    public Integer getTrLang() {
        return trLang;
    }

    public void setTrLang(Integer trLang) {
        this.trLang = trLang;
    }

    public String getTrUrl() {
        return trUrl;
    }

    public void setTrUrl(String trUrl) {
        this.trUrl = trUrl;
    }

    public String getTrTextLetramusica() {
        return trTextLetramusica;
    }

    public void setTrTextLetramusica(String trTextLetramusica) {
        this.trTextLetramusica = trTextLetramusica;
    }


    public Integer getLangmusica() {
        return langmusica;
    }

    public void setLangmusica(Integer langmusica) {
        this.langmusica = langmusica;
    }

    public String getUrlImgArtista() {
        return urlImgArtista;
    }

    public void setUrlImgArtista(String urlImgArtista) {
        this.urlImgArtista = urlImgArtista;
    }

    public void setResultLetra(ResultadoLetras resultLetra) {
        this.resultadosUnicosLetras = resultLetra;
        setIdartista(resultLetra.getArt().getId());
        setNomeartista(resultLetra.getArt().getName());
        setUrlartista(resultLetra.getArt().getUrl());
        setUrlImgArtista(resultLetra.getArt().getUrl() + "images/profile.jpg");


        setIdmusica(resultLetra.getMus().get(0).getId());
        setNomemusica(resultLetra.getMus().get(0).getName());
        setUrlmusica(resultLetra.getMus().get(0).getUrl());
        setTextletramusica(resultLetra.getMus().get(0).getText());
        setLangmusica(resultLetra.getMus().get(0).getLang());

        if (resultLetra.getMus().get(0).getTranslate() != null) {
            setTrId(resultLetra.getMus().get(0).getTranslate().get(0).getId());
            setTrLang(resultLetra.getMus().get(0).getTranslate().get(0).getLang());
            setTrUrl(resultLetra.getMus().get(0).getTranslate().get(0).getUrl());
            setTrTextLetramusica(resultLetra.getMus().get(0).getTranslate().get(0).getText());
        }

    }
    public void setDemoTestFavoritos(){

        ContentValues contentValues = new ContentValues();
        contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_ID_ART, MADONA_ID_ART);
        contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_NOME_ART, MADONA_NOME_ART);
        contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_URL_ART, MADONA_URL_ART);
        contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_URL_IMG_ART, MADONA_IMG_URL_ART);

        contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_ID_LETRA, MADONA_ID_LETRA);
        contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_NOME_MUS, MADONA_NOME_MUS);
        contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_LETRA_LANG, MADONA_LETRA_LANG);
        contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_LETRA_URL, MADONA_LETRA_URL);
        contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_LETRA_MUS, MADONA_LETRA_MUS);
            contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_TRANSLATE_ID, MADONA_TR_ID);
            contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_TRANSLATE_LANG, MADONA_TR_LANG);
            contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_TRANSLATE_TEXT, MADONA_TR_TEXT);
            contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_TRANSLATE_URL, MADONA_TR_URL);


        Uri uri = activity.getContentResolver().insert(FavoriteContract.FavoriteEntry.CONTENT_URI, contentValues);
        if (uri != null) {
            Toast.makeText(activity.getBaseContext(), R.string.sucesso_favoritado, Toast.LENGTH_LONG).show();
        }






    }

    public void FavoritarLetras() {

        ContentValues contentValues = new ContentValues();
        contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_ID_ART, getIdartista());
        contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_NOME_ART, getNomeartista());
        contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_URL_ART, getUrlartista());
        contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_URL_IMG_ART, getUrlImgArtista());

        contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_ID_LETRA, getIdmusica());
        contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_NOME_MUS, getNomemusica());
        contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_LETRA_LANG, getLangmusica());
        contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_LETRA_URL, getUrlmusica());
        contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_LETRA_MUS, getTextletramusica());
        if (resultadosUnicosLetras.getMus().get(0).getTranslate() != null) {
            contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_TRANSLATE_ID, getTrId());
            contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_TRANSLATE_LANG, getTrLang());
            contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_TRANSLATE_TEXT, getTrTextLetramusica());
            contentValues.put(FavoriteContract.FavoriteEntry.COLUMN_TRANSLATE_URL, getTrUrl());
        }

        Uri uri = activity.getContentResolver().insert(FavoriteContract.FavoriteEntry.CONTENT_URI, contentValues);
        if (uri != null) {
            Toast.makeText(activity.getBaseContext(), R.string.sucesso_favoritado, Toast.LENGTH_LONG).show();
        }

    }

}
