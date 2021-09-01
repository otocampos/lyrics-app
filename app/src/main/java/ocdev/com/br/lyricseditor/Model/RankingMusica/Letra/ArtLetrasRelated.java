package ocdev.com.br.lyricseditor.Model.RankingMusica.Letra;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Oto on 11/03/2018.
 */

public class ArtLetrasRelated {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("pic_small")
    @Expose
    private String picSmall;
    @SerializedName("pic_medium")
    @Expose
    private String picMedium;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicSmall() {
        return picSmall;
    }

    public void setPicSmall(String picSmall) {
        this.picSmall = picSmall;
    }

    public String getPicMedium() {
        return picMedium;
    }

    public void setPicMedium(String picMedium) {
        this.picMedium = picMedium;
    }

}


