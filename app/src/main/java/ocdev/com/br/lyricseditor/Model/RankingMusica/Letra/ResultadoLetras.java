package ocdev.com.br.lyricseditor.Model.RankingMusica.Letra;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Oto on 11/03/2018.
 */

public class ResultadoLetras {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("art")
    @Expose
    private ArtLetras art;
    @SerializedName("mus")
    @Expose
    private List<Musica> mus = null;
    @SerializedName("badwords")
    @Expose
    private Boolean badwords;

    public ResultadoLetras() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArtLetras getArt() {
        return art;
    }

    public void setArt(ArtLetras art) {
        this.art = art;
    }

    public List<Musica> getMus() {
        return mus;
    }

    public void setMus(List<Musica> mus) {
        this.mus = mus;
    }

    public Boolean getBadwords() {
        return badwords;
    }

    public void setBadwords(Boolean badwords) {
        this.badwords = badwords;
    }
}
