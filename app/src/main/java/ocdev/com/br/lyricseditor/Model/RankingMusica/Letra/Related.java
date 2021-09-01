package ocdev.com.br.lyricseditor.Model.RankingMusica.Letra;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Oto on 11/03/2018.
 */

public class Related {

    @SerializedName("art")
    @Expose
    private ArtLetras art;
    @SerializedName("mus")
    @Expose
    private MusicasRelated mus;

    public ArtLetras getArt() {
        return art;
    }

    public void setArt(ArtLetras art) {
        this.art = art;
    }

    public MusicasRelated getMus() {
        return mus;
    }

    public void setMus(MusicasRelated mus) {
        this.mus = mus;
    }
}
