package ocdev.com.br.lyricseditor.Constants;

/**
 * Created by Oto on 01/03/2018.
 */

public class Constants {
    //URL BASE
    public static final String URL_BASE = "https://api.vagalume.com.br";
    //SEARCH
    public static final String SEARCH_BASE = "search.php";
    public static final String MUSICA_ID_BUSCA_PARAMETRO = "musid";
    public static final String EXTRA_RELMUS = "relmus";
    public static final String EXTRA = "extra";


    //MONTAR URL DE RANKING
    public static final String RANKING_BASE = "rank.php";
    //TIPO
    public static final String TYPE = "type";
    public static final String TYPE_ARTISTA = "art";
    public static final String TYPE_ALBUM = "alb";
    public static final String TYPE_MUSICA = "mus";

    //PERIODO
    public static final String PERIOD = "period";
    public static final String PERIOD_DAY = "day";
    public static final String PERIOD_WEEK = "week";
    public static final String PERIOD_MONTH = "month";

    //ESCOPO
    public static final String ESCOPO = "scope";

    //ESCOPO PARA ARTISTAS
    public static final String ESCOPO_INTERNATIONAL = "internacional";
    public static final String ESCOPO_NACIONAL = "nacional";
    public static final String ESCOPO_ARTISTAS_ALL = "all";

    //ESCOPO PARA MUSICAS
    public static final String ESCOPO_LYRICS = "lyrics";
    public static final String ESCOPO_TRANSLATIONS = "translations";
    public static final String ESCOPO_CHORDS = "chords";
    public static final String ESCOPO_MUSICAS_ALL = "all";

    //LIMITES DE EXIBIÇÃO
    public static final String LIMITE = "limit";
    public static final String LIMITE_RANKING_MUSICA = "20";
    public static final String LIMITE_RANKING_ARTISTA = "10";

    //RESPOSTAS RANKING
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String URL = "url";
    public static final String PIC_SMALL = "pic_small";
    public static final String PIC_MEDIUM = "pic_medium";
    public static final String UNIQUES = "uniques";
    public static final String VIEWS = "views";


    // INDICES DE LISTA DE MUSICAS POR ESCOPOS
    public static final int RANKING_LISTA_INDEX_MUSICAS_LYRICS = 0;
    public static final int RANKING_LISTA_INDEX_ARTISTAS_NACIONAL = 1;
    public static final int RANKING_LISTA_INDEX_ARTISTAS_INTERNACIONAL = 2;
    public static final int RANKING_LISTA_INDEX_MUSICAS_TRADUCOES = 3;
    public static final int LISTA_MUSICA_ITEM_UNICO_INDEX = 4;


    //FAVORITOS
    public static final int LISTAGEM_MUSICAS_FAVORITAS = 55;

    //CONTENT PROVIDER FAVORITES
    public static final String ID_COLLUMN_CONSULTA_UNICA_LETRA = "id_letra=?";


//FRAGMENTS ID´S

    //ranking
    public static final String FRAGMENT_TOP_LYRICS = "ranking_lyrics_fragment";
    public static final String FRAGMENT_TOP_ARTISTA_NACIONAL = "ranking_artista_nacional_fragment";
    public static final String FRAGMENT_TOP_ARTISTA_INTERNACIONAL = "ranking_artista_internacional_fragment";
    public static final String FRAGMENT_TOP_TRADUCOES = "ranking_traducoes_fragment";

    //letra
    public static final String FRAGMENT_ELEMENTO_LETRA = "elemento_letra_fragment";
    //artista
    public static final String FRAGMENT_ELEMENTO_ARTISTA = "elemento_artista_fragment";


    //telas fragment
    public static final String FRAGMENT_TELA_HOME = "fragment_tela_home";
    public static final String FRAGMENT_TELA_DETALHE = "fragment_tela_detalhe";
    public static final String FRAGMENT_TELA_LETRA = "fragment_tela_letra";


    //CONSULTA DE INFORMAÇÕES DO ARTISTA
    public static final String BASE_URL_ARTISTAS = "https://www.vagalume.com.br/";
    public static final String BASE_URLS2 = "https://s2.vagalume.com/";

    public static final String IMAGES = "/images/";
    public static final String PROFILE_JPG = "profile.jpg";

    public static final String INDEX_JS = "index.js";


    //LINGUAS TRADUÇÕES
    public static final int lINGUA_PORTUGUES = 1;
    public static final int lINGUA_INGLES = 2;
    public static final int lINGUA_ESPANHOL = 3;

    //CHAVES BUNDLE
    public static final String CHAVE_ID_LETRA = "id_letra";


//api key

    public static final String KEY_PARAMETER = "apikey";

    //Loader
    public static final int ID_DETAIL_LOADER = 353;
    public static final int ID_LISTA_FAVORITOS = 354;

    //TELAS
    public static final int TELA_PRINCIPAL_RANK = 10;
    public static final int TELA_FAVORITOS = 20;
    public static final int TELA_LETRA = 30;
    public static final int TELA_LETRA_FAVORITOS = 40;
    public static final int TELA_HISTORICO = 50;



    public static final String CHAVE_CURRENT_TELA = "chavetela";


    public static final String CHAVE_URL_IMG = "urlimg";

    public static final String CHAVE_LISTA_DE_ESCOPOS = "listadescopos";

    public static final String CHAVE_ID_ARTISTA = "idartista";
    public static final String CHAVE_NOME_ARTISTA = "nomeartista";
    public static final String CHAVE_ARTISTA_REL = "listareal";
    public static final String CHAVE_FAVORITO = "chavefavorito";
    public static final String CHAVE_LISTA_MUSICA = "listademusicas";
    public static final String CHAVE_LISTA_ALBUM = "listadealbuns";

    public static final String CHAVE_FRAGMENT_CARREGADO= "carregado";
    public static final String CHAVE_FRAGMENT= "fragment";




    public static final String ANIM_ART = "profileartista";
    public static final String TRANSACTION = "transaction";


    public static final int QNT_RANK = 9;


    //CONTENT PROVIDER DE TESTE -- API VAGALUME COM PROBLEMAS
    //MUSICA HOLLIDAY MADONA

    public static final String MADONA_ID_ART = "3ade68b3g1f86eda3";
    public static final String MADONA_NOME_ART = "Madonna";
    public static final String MADONA_URL_ART = "https://www.vagalume.com.br/madonna/";
    public static final String MADONA_IMG_URL_ART = "https://s2.vagalume.com/u2/images/madonna.jpg";

    //MUSICA
    public static final String MADONA_ID_LETRA = "3ade68b6g8e27fda3";
    public static final String MADONA_NOME_MUS = "Holiday";
    public static final Integer MADONA_LETRA_LANG =2 ;
    public static final String MADONA_LETRA_URL = "https://www.vagalume.com.br/madonna/holiday.html";
    public static final String MADONA_LETRA_MUS = "\"Holiday Celebrate \\nHoliday Celebrate \\nIf we took a holiday \\nTook some time to celebrate \\nJust one day out of life \\nIt would be, it would be so nice (chorus)\\n\\nEverybody spread the word \\nWe\\u00b4re gonna have a celebration \\nAll across the world \\nIn every nation \\nIt\\u00b4s time for the good times \\nForget about the bad times, oh yeah \\nOne day to come together \\nTo release the pressure \\nWe need a holiday \\n\\n(chorus)\\n\\nYou can turn this world around \\nAnd bring back all of those happy days \\nPut your troubles down \\nIt\\u00b4s time to celebrate \\nLet love shine \\nAnd we will find \\nA way to come together \\nAnd make things better \\nWe need a holiday \\n\\n(chorus)\\n\\nHoliday Celebrate \\nHoliday Celebrate \\nHoliday Celebrate \\nHoliday Celebrate \\nHoliday, Celebration \\nCome together in every nation\"";

    //TRADUCAO
    public static final String MADONA_TR_ID= "3ade68b6g417afda3";
    public static final Integer MADONA_TR_LANG=1 ;
    public static final String MADONA_TR_TEXT= "[Feriado]\\nFeriado, comemore \\nFeriado, comemore \\nSe n\\u00f3s tir\\u00e1ssemos uma folga \\nTir\\u00e1ssemos um dia para comemorar \\nS\\u00f3 um dia da vida\\nSeria t\\u00e3o, seria t\\u00e3o legal (refr\\u00e3o)\\n\\nTodo mundo espalhando a not\\u00edcia \\nN\\u00f3s vamos fazer uma comemora\\u00e7\\u00e3o \\nPelo mundo inteiro \\nEm todas as na\\u00e7\\u00f5es \\n\\u00c9 hora dos bons momentos \\nEsque\\u00e7a os maus momentos oh yeah \\nUm dia para nos unirmos \\nPara aliviar a press\\u00e3o \\nN\\u00f3s precisamos de uma folga \\n\\n(refr\\u00e3o)\\n\\nVoc\\u00ea pode mudar este mundo \\nE trazer de voltas aqueles dias felizes\\nAcabe com seus problemas \\n\\u00c9 hora de comemorar\\nDeixe o amor brilhar \\nE encontraremos \\nUm jeito de nos unirmos \\nE fazer as coisas melhor \\nPrecisamos de uma folga \\n\\n(refr\\u00e3o)\\n\\nFeriado, comemore \\nFeriado, comemore \\nFeriado, comemore \\nFeriado, comemore \\nFeriado, celebra\\u00e7\\u00e3o\\nUnam-se em todas as na\\u00e7\\u00f5es";
    public static final String MADONA_TR_URL= "https:\\/\\/www.vagalume.com.br\\/madonna\\/holiday-traducao.html";





















}
