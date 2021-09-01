package ocdev.com.br.lyricseditor.Model.RankingMusica;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Oto on 01/03/2018.
 */

public class Week implements Parcelable{

    @SerializedName("period")
    private Period period;
    @SerializedName("all")
    private List<All> all = null;

    @SerializedName("lyrics")
    private List<All> lyrics = null;

    @SerializedName("nacional")
    private List<All> nacional = null;

    @SerializedName("internacional")
    private List<All> internacional = null;

    @SerializedName("translations")
    private List<All> translations = null;


    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public List<All> getAll() {
        return all;
    }

    public void setAll(List<All> all) {
        this.all = all;
    }

    public List<All> getLyrics() {
        return lyrics;
    }

    public void setLyrics(List<All> lyrics) {
        this.lyrics = lyrics;
    }

    public List<All> getNacional() {
        return nacional;
    }

    public void setNacional(List<All> nacional) {
        this.nacional = nacional;
    }

    public List<All> getInternacional() {
        return internacional;
    }

    public void setInternacional(List<All> internacional) {
        this.internacional = internacional;
    }

    public List<All> getTranslations() {
        return translations;
    }

    public void setTranslations(List<All> translations) {
        this.translations = translations;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.period, flags);
        dest.writeTypedList(this.all);
        dest.writeTypedList(this.lyrics);
        dest.writeTypedList(this.nacional);
        dest.writeTypedList(this.internacional);
        dest.writeTypedList(this.translations);
    }

    public Week() {
    }

    protected Week(Parcel in) {
        this.period = in.readParcelable(Period.class.getClassLoader());
        this.all = in.createTypedArrayList(All.CREATOR);
        this.lyrics = in.createTypedArrayList(All.CREATOR);
        this.nacional = in.createTypedArrayList(All.CREATOR);
        this.internacional = in.createTypedArrayList(All.CREATOR);
        this.translations = in.createTypedArrayList(All.CREATOR);
    }

    public static final Creator<Week> CREATOR = new Creator<Week>() {
        @Override
        public Week createFromParcel(Parcel source) {
            return new Week(source);
        }

        @Override
        public Week[] newArray(int size) {
            return new Week[size];
        }
    };
}
