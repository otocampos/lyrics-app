package ocdev.com.br.lyricseditor.Model.RankingMusica.Historico;

/**
 * Created by Oto on 03/05/2018.
 */

public class HistoricoLetra  {
    public String nomemusica;
    public String idmusica;


    public HistoricoLetra(String nomemusica, String idmusica) {
        this.nomemusica = nomemusica;
        this.idmusica = idmusica;
    }

    public HistoricoLetra() {
    }

    public String getNomemusica() {
        return nomemusica;
    }

    public void setNomemusica(String nomemusica) {
        this.nomemusica = nomemusica;
    }

    public String getIdmusica() {
        return idmusica;
    }

    public void setIdmusica(String idmusica) {
        this.idmusica = idmusica;
    }
}
