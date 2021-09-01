package ocdev.com.br.lyricseditor.Model.RankingMusica.Artista;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Oto on 07/03/2018.
 */

public class Rank implements Parcelable {
    @SerializedName("pos")
    @Expose
    private String pos;
    @SerializedName("period")
    @Expose
    private String period;
    @SerializedName("views")
    @Expose
    private String views;
    @SerializedName("uniques")
    @Expose
    private String uniques;
    @SerializedName("points")
    @Expose
    private String points;

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getUniques() {
        return uniques;
    }

    public void setUniques(String uniques) {
        this.uniques = uniques;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.pos);
        dest.writeString(this.period);
        dest.writeString(this.views);
        dest.writeString(this.uniques);
        dest.writeString(this.points);
    }

    public Rank() {
    }

    protected Rank(Parcel in) {
        this.pos = in.readString();
        this.period = in.readString();
        this.views = in.readString();
        this.uniques = in.readString();
        this.points = in.readString();
    }

    public static final Creator<Rank> CREATOR = new Creator<Rank>() {
        @Override
        public Rank createFromParcel(Parcel source) {
            return new Rank(source);
        }

        @Override
        public Rank[] newArray(int size) {
            return new Rank[size];
        }
    };
}
