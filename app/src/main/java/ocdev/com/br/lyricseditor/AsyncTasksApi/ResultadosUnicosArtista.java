package ocdev.com.br.lyricseditor.AsyncTasksApi;

import java.util.ArrayList;
import java.util.List;

import ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.Genre;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.ItemAlbums;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.ItemTopLyrics;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.ItemTopLyricsTraducao;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.Rank;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.Related;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.ResultArtista;

/**
 * Created by Oto on 08/03/2018.
 */

public class ResultadosUnicosArtista {

    ResultArtista resultArtista;
    String NomeArtista;
    private String UrldoArtista;
    private String Urlpicsmall;
    private String Urlpicmedium;

    //INFO RANKING ARTISTA;
    private String PosicaoRanking;
    private String periododeavaliacao;
    private String numerodeviews;
    private String numerodeUsuarios;
    private String pontuacaoRanking;

    //INFO GÊNERO

    private List<String> nameGenero;
    private List<String> urlGenero;

    //ARTISTAS RELACIONADOS
    private ArrayList<String> nameRelatedArtistas;
    private ArrayList<String> idRelatedArtistas;
    private ArrayList<String> urlRelatedArtistas;

    //TopLyrics
    private ArrayList<String> idToplyricsArtistas;
    private ArrayList<String> tituloToplyricsArtistas;
    private ArrayList<String> UrlToplyricsArtistas;

    //TopLyrics tradução

    private ArrayList<String> idLyricsArtistas;
    private ArrayList<String> titulolyricsArtistas;
    private ArrayList<String> UrlLyricsArtistas;
    private ArrayList<String> TraducaoUrlLyricsArtistas;

    //ALBUMS
    private ArrayList<String> idAlbumsArtistas;
    private ArrayList<String> nomeAlbumsArtistas;
    private ArrayList<String> urlAlbumsArtistas;
    private ArrayList<String> yearAlbumsArtistas;
    private ArrayList<String> gravadoraAlbumsArtistas;


    public String getNomeArtista() {
        return NomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        NomeArtista = nomeArtista;
    }

    public String getUrldoArtista() {
        return UrldoArtista;
    }

    public void setUrldoArtista(String urldoArtista) {
        UrldoArtista = urldoArtista;
    }

    public String getUrlpicsmall() {
        return Urlpicsmall;
    }

    public void setUrlpicsmall(String urlpicsmall) {
        Urlpicsmall = urlpicsmall;
    }

    public String getUrlpicmedium() {
        return Urlpicmedium;
    }

    public void setUrlpicmedium(String urlpicmedium) {
        Urlpicmedium = urlpicmedium;
    }

    public String getPosicaoRanking() {
        return PosicaoRanking;
    }

    public void setPosicaoRanking(String posicaoRanking) {
        PosicaoRanking = posicaoRanking;
    }

    public String getPeriododeavaliacao() {
        return periododeavaliacao;
    }

    public void setPeriododeavaliacao(String periododeavaliacao) {
        this.periododeavaliacao = periododeavaliacao;
    }

    public String getNumerodeviews() {
        return numerodeviews;
    }

    public void setNumerodeviews(String numerodeviews) {
        this.numerodeviews = numerodeviews;
    }

    public String getNumerodeUsuarios() {
        return numerodeUsuarios;
    }

    public void setNumerodeUsuarios(String numerodeUsuarios) {
        this.numerodeUsuarios = numerodeUsuarios;
    }

    public String getPontuacaoRanking() {
        return pontuacaoRanking;
    }

    public void setPontuacaoRanking(String pontuacaoRanking) {
        this.pontuacaoRanking = pontuacaoRanking;
    }

    public ResultArtista getResultArtista() {
        return resultArtista;
    }

    public List<String> getNameGenero() {
        return nameGenero;
    }

    public void setNameGenero(List<String> nameGenero) {
        this.nameGenero = nameGenero;
    }

    public List<String> getUrlGenero() {
        return urlGenero;
    }

    public void setUrlGenero(List<String> urlGenero) {
        this.urlGenero = urlGenero;
    }

    public ArrayList<String> getNameRelatedArtistas() {
        return nameRelatedArtistas;
    }

    public void setNameRelatedArtistas(ArrayList<String> nameRelatedArtistas) {
        this.nameRelatedArtistas = nameRelatedArtistas;
    }

    public ArrayList<String> getIdRelatedArtistas() {
        return idRelatedArtistas;
    }

    public void setIdRelatedArtistas(ArrayList<String> idRelatedArtistas) {
        this.idRelatedArtistas = idRelatedArtistas;
    }

    public ArrayList<String> getUrlRelatedArtistas() {
        return urlRelatedArtistas;
    }

    public void setUrlRelatedArtistas(ArrayList<String> urlRelatedArtistas) {
        this.urlRelatedArtistas = urlRelatedArtistas;
    }

    public ArrayList<String> getIdToplyricsArtistas() {
        return idToplyricsArtistas;
    }

    public void setIdToplyricsArtistas(ArrayList<String> idToplyricsArtistas) {
        this.idToplyricsArtistas = idToplyricsArtistas;
    }

    public ArrayList<String> getTituloToplyricsArtistas() {
        return tituloToplyricsArtistas;
    }

    public void setTituloToplyricsArtistas(ArrayList<String> tituloToplyricsArtistas) {
        this.tituloToplyricsArtistas = tituloToplyricsArtistas;
    }

    public ArrayList<String> getUrlToplyricsArtistas() {
        return UrlToplyricsArtistas;
    }

    public void setUrlToplyricsArtistas(ArrayList<String> urlToplyricsArtistas) {
        UrlToplyricsArtistas = urlToplyricsArtistas;
    }


    public ArrayList<String> getIdLyricsArtistas() {
        return idLyricsArtistas;
    }

    public void setIdLyricsArtistas(ArrayList<String> idLyricsArtistas) {
        this.idLyricsArtistas = idLyricsArtistas;
    }


    public ArrayList<String> getTitulolyricsArtistas() {
        return titulolyricsArtistas;
    }

    public void setTitulolyricsArtistas(ArrayList<String> titulolyricsArtistas) {
        this.titulolyricsArtistas = titulolyricsArtistas;
    }

    public ArrayList<String> getUrlLyricsArtistas() {
        return UrlLyricsArtistas;
    }

    public void setUrlLyricsArtistas(ArrayList<String> urlLyricsArtistas) {
        UrlLyricsArtistas = urlLyricsArtistas;
    }

    public ArrayList<String> getTraducaoUrlLyricsArtistas() {
        return TraducaoUrlLyricsArtistas;
    }

    public void setTraducaoUrlLyricsArtistas(ArrayList<String> traducaoUrlLyricsArtistas) {
        TraducaoUrlLyricsArtistas = traducaoUrlLyricsArtistas;
    }

    public ArrayList<String> getIdAlbumsArtistas() {
        return idAlbumsArtistas;
    }

    public void setIdAlbumsArtistas(ArrayList<String> idAlbumsArtistas) {
        this.idAlbumsArtistas = idAlbumsArtistas;
    }

    public ArrayList<String> getNomeAlbumsArtistas() {
        return nomeAlbumsArtistas;
    }

    public void setNomeAlbumsArtistas(ArrayList<String> nomeAlbumsArtistas) {
        this.nomeAlbumsArtistas = nomeAlbumsArtistas;
    }

    public ArrayList<String> getUrlAlbumsArtistas() {
        return urlAlbumsArtistas;
    }

    public void setUrlAlbumsArtistas(ArrayList<String> urlAlbumsArtistas) {
        this.urlAlbumsArtistas = urlAlbumsArtistas;
    }

    public ArrayList<String> getYearAlbumsArtistas() {
        return yearAlbumsArtistas;
    }

    public void setYearAlbumsArtistas(ArrayList<String> yearAlbumsArtistas) {
        this.yearAlbumsArtistas = yearAlbumsArtistas;
    }

    public ArrayList<String> getGravadoraAlbumsArtistas() {
        return gravadoraAlbumsArtistas;
    }

    public void setGravadoraAlbumsArtistas(ArrayList<String> gravadoraAlbumsArtistas) {
        this.gravadoraAlbumsArtistas = gravadoraAlbumsArtistas;
    }

    public void setResultArtista(ResultArtista resultArtista) {
        this.resultArtista = resultArtista;
        //INFO DO ARTISTA
        setNomeArtista(resultArtista.getArtist().getDesc());
        setUrldoArtista(resultArtista.getArtist().getUrl());
        setUrlpicsmall(resultArtista.getArtist().getPicSmall());
        setUrlpicmedium(resultArtista.getArtist().getPicMedium());

        //INFO RANKING ARTISTA
        Rank rank = resultArtista.getArtist().getRank();
        setPosicaoRanking(rank.getPos());
        setPeriododeavaliacao(rank.getPeriod());
        setNumerodeviews(rank.getViews());
        setNumerodeUsuarios(rank.getUniques());
        setPontuacaoRanking(rank.getPoints());


        //INFO GÊNERO

        ArrayList listadeNomeGeneros = new ArrayList();
        ArrayList listadeUrlGeneros = new ArrayList();
        if (resultArtista.getArtist().getGenre() != null) {
            for (Genre genre : resultArtista.getArtist().getGenre()) {
                listadeNomeGeneros.add(genre.getName());
                listadeUrlGeneros.add(genre.getUrl());

            }

            setNameGenero(listadeNomeGeneros);
            setUrlGenero(listadeUrlGeneros);
        }

        //INFO ARTISTAS RELACIONADOS
        if (resultArtista.getArtist().getRelated() != null) {
            ArrayList listadeArtistasRelacionadosid = new ArrayList();
            ArrayList listadeArtistasRelacionadosNome = new ArrayList();
            ArrayList listadeArtistasRelacionadosUrl = new ArrayList();
            for (Related related : resultArtista.getArtist().getRelated()) {
                listadeArtistasRelacionadosid.add(related.getId());
                listadeArtistasRelacionadosNome.add(related.getName());
                listadeArtistasRelacionadosUrl.add(related.getUrl());
            }

            setIdRelatedArtistas(listadeArtistasRelacionadosid);
            setNameRelatedArtistas(listadeArtistasRelacionadosNome);
            setUrlRelatedArtistas(listadeArtistasRelacionadosUrl);
        }
        //TOP LYRICS
        if (resultArtista.getArtist().getToplyrics().getItem() != null) {
            idToplyricsArtistas = new ArrayList();
            tituloToplyricsArtistas = new ArrayList();
            UrlToplyricsArtistas = new ArrayList();
            for (ItemTopLyrics itemTopLyrics : resultArtista.getArtist().getToplyrics().getItem()) {
                idToplyricsArtistas.add(itemTopLyrics.getId());
                tituloToplyricsArtistas.add(itemTopLyrics.getDesc());
                UrlToplyricsArtistas.add(itemTopLyrics.getUrl());

            }

            setIdToplyricsArtistas(idToplyricsArtistas);
            setTituloToplyricsArtistas(tituloToplyricsArtistas);
            setUrlRelatedArtistas(UrlToplyricsArtistas);
        }

//Lyrics,comtem letras que estão traduzidas também

        if (resultArtista.getArtist().getLyrics().getItem() != null) {
            idLyricsArtistas = new ArrayList();
            titulolyricsArtistas = new ArrayList();
            UrlLyricsArtistas = new ArrayList();
            TraducaoUrlLyricsArtistas = new ArrayList<>();

            for (ItemTopLyricsTraducao itemTopLyricstraducao : resultArtista.getArtist().getLyrics().getItem()) {
                idLyricsArtistas.add(itemTopLyricstraducao.getId());
                titulolyricsArtistas.add(itemTopLyricstraducao.getDesc());
                UrlLyricsArtistas.add(itemTopLyricstraducao.getUrl());
                TraducaoUrlLyricsArtistas.add(itemTopLyricstraducao.getTurl());
            }

            setIdLyricsArtistas(idToplyricsArtistas);
            setTitulolyricsArtistas(tituloToplyricsArtistas);
            setUrlLyricsArtistas(UrlToplyricsArtistas);
            setTraducaoUrlLyricsArtistas(TraducaoUrlLyricsArtistas);
        }

        //ALBUMS
            idAlbumsArtistas = new ArrayList();
            nomeAlbumsArtistas = new ArrayList();
            urlAlbumsArtistas = new ArrayList();
            yearAlbumsArtistas = new ArrayList();
            gravadoraAlbumsArtistas = new ArrayList();
        if (resultArtista.getArtist().getAlbums() !=null ) {
            for (ItemAlbums itemAlbums : resultArtista.getArtist().getAlbums().getItem()) {
                idAlbumsArtistas.add(itemAlbums.getId());
                nomeAlbumsArtistas.add(itemAlbums.getDesc());
                urlAlbumsArtistas.add(itemAlbums.getUrl());
                yearAlbumsArtistas.add(itemAlbums.getYear());
                gravadoraAlbumsArtistas.add(itemAlbums.getLabel());
            }

            setIdAlbumsArtistas(idAlbumsArtistas);
            setNomeAlbumsArtistas(nomeAlbumsArtistas);
            setUrlAlbumsArtistas(urlAlbumsArtistas);
            setYearAlbumsArtistas(yearAlbumsArtistas);
            setGravadoraAlbumsArtistas(gravadoraAlbumsArtistas);
        }

    }
}
