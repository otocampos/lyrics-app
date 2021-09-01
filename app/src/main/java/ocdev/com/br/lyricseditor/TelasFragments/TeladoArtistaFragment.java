package ocdev.com.br.lyricseditor.TelasFragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.siyamed.shapeimageview.CircularImageView;

import java.util.ArrayList;
import java.util.List;

import ocdev.com.br.lyricseditor.AsyncTasksApi.AsyncTaskArtista;
import ocdev.com.br.lyricseditor.AsyncTasksApi.ResultadosUnicosArtista;
import ocdev.com.br.lyricseditor.Constants.Constants;
import ocdev.com.br.lyricseditor.ElementosFragments.AlbunsdoArtistaFragment;
import ocdev.com.br.lyricseditor.ElementosFragments.ArtistaRelacionadosFragment;
import ocdev.com.br.lyricseditor.ElementosFragments.ListadeMusicasDoArtistaFragment;
import ocdev.com.br.lyricseditor.Interfaces.ResultadoAsynctaskArtistas;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.ItemAlbums;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.ItemTopLyrics;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.Related;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.ResultArtista;
import ocdev.com.br.lyricseditor.R;
import ocdev.com.br.lyricseditor.Utils.NetworkUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeladoArtistaFragment extends DialogFragment implements ResultadoAsynctaskArtistas {
    private CircularImageView img_artista;
    ResultadosUnicosArtista resultadosUnicosArtista;
    private ListadeMusicasDoArtistaFragment listademusicasFragment;
    private AlbunsdoArtistaFragment listadealbunsFragment;
    private ArtistaRelacionadosFragment artistaRelacionadosFragment;
    private FragmentManager fragmentManager;
    Bundle bundle;
    String iddoartista;
    List<ItemTopLyrics> listadenomesdemusicas;
    List<ItemAlbums> listadealbuns;
    List<Related> listadeartistasRel;
    InicialFragment inicialFragment;
    private String urlimg;
    LinearLayout linearLayoutartista;
    LinearLayout linearLayoutnointernet;
    AppCompatActivity activity;
    String nomedoartista;
    Button recarregar;
    TeladoArtistaFragment teladoArtistaFragment;

    public TeladoArtistaFragment() {
        // Required empty public constructor
    }


    @SuppressLint("RestrictedApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_telado_artista, container, false);
        ProgressBar progressBar = (ProgressBar) rootview.findViewById(R.id.progressBar_tela_artista);
        // txtview = (TextView) rootview.findViewById(R.id.teste);
        Toolbar toolbar_tela_artista = (Toolbar) rootview.findViewById(R.id.toolbar_tela_artista);
        img_artista = (CircularImageView) rootview.findViewById(R.id.photo_tela_artista);
        AsyncTaskArtista asyncTaskArtista = new AsyncTaskArtista(this, progressBar);
        resultadosUnicosArtista = new ResultadosUnicosArtista();
        teladoArtistaFragment = new TeladoArtistaFragment();
        fragmentManager = getActivity().getSupportFragmentManager();
        listademusicasFragment = new ListadeMusicasDoArtistaFragment();
        listadealbunsFragment = new AlbunsdoArtistaFragment();
        artistaRelacionadosFragment = new ArtistaRelacionadosFragment();
        fragmentManager = getActivity().getSupportFragmentManager();
        activity = (AppCompatActivity) getActivity();
        recarregar = (Button) rootview.findViewById(R.id.btnrecarregar);
        listadealbuns = new ArrayList<>();
        listadeartistasRel = new ArrayList<>();
        linearLayoutartista = (LinearLayout) rootview.findViewById(R.id.framelayout_tela_artista);
        linearLayoutnointernet = (LinearLayout) rootview.findViewById(R.id.layout_nointernet);
        inicialFragment = new InicialFragment();
        activity.setSupportActionBar(toolbar_tela_artista);
        bundle = this.getArguments();
        listadenomesdemusicas = new ArrayList<>();
        if (bundle != null) {
            iddoartista = bundle.getString(Constants.CHAVE_ID_ARTISTA);
            nomedoartista = bundle.getString(Constants.CHAVE_NOME_ARTISTA);
            urlimg = bundle.getString(Constants.CHAVE_URL_IMG);
        }

        if (NetworkUtils.isNetworkConnected(getActivity().getApplicationContext())) {

            asyncTaskArtista.execute(iddoartista);
        } else {
            Errormessageinternet();

        }


        recarregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.id_fragment_home, teladoArtistaFragment, teladoArtistaFragment.getTag())
                        .commit();
                bundle.putString(Constants.CHAVE_URL_IMG, urlimg);
                bundle.putString(Constants.CHAVE_ID_ARTISTA, iddoartista);
                bundle.putString(Constants.CHAVE_NOME_ARTISTA, nomedoartista);
                teladoArtistaFragment.setArguments(bundle);
            }
        });

        return rootview;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(Constants.CHAVE_ID_ARTISTA, iddoartista);
        outState.putString(Constants.CHAVE_NOME_ARTISTA, nomedoartista);
        outState.putString(Constants.CHAVE_URL_IMG, urlimg);

        super.onSaveInstanceState(outState);
    }

    @Override
    public void getResultadoArtista(ResultArtista resultArtista) {
        resultadosUnicosArtista.setResultArtista(resultArtista);
        if (isAdded()) {


            if (!listademusicasFragment.isAdded() && resultArtista.getArtist().getToplyrics() != null) {
                fragmentManager.beginTransaction()
                        .add(R.id.framelayout_tela_artista, listademusicasFragment, listademusicasFragment.getTag())
                        .commit();

                //Envia dados para o fragment de lista de letras de musicas
                listadenomesdemusicas = resultArtista.getArtist().getToplyrics().getItem();
                bundle.putParcelableArrayList("listademusicas", (ArrayList<? extends Parcelable>) listadenomesdemusicas);
                listademusicasFragment.setArguments(bundle);
            }
            //Evia dados para o fragment de lista de albuns.

            if (!listadealbunsFragment.isAdded() && resultArtista.getArtist().getAlbums() != null) {
                fragmentManager.beginTransaction()
                        .add(R.id.framelayout_tela_artista, listadealbunsFragment, listadealbunsFragment.getTag())
                        .commit();

                listadealbuns = resultArtista.getArtist().getAlbums().getItem();
                bundle.putParcelableArrayList(Constants.CHAVE_LISTA_ALBUM, (ArrayList<? extends Parcelable>) listadealbuns);
                listadealbunsFragment.setArguments(bundle);
            }
            if (!artistaRelacionadosFragment.isAdded() && resultArtista.getArtist().getRelated() != null) {
                fragmentManager.beginTransaction()
                        .add(R.id.framelayout_tela_artista, artistaRelacionadosFragment, artistaRelacionadosFragment.getTag())
                        .commit();
                //Envia dadps para o fragment de lista de artistas relacionados
                listadeartistasRel = resultArtista.getArtist().getRelated();
                bundle.putParcelableArrayList(Constants.CHAVE_ARTISTA_REL, (ArrayList<? extends Parcelable>) listadeartistasRel);
                artistaRelacionadosFragment.setArguments(bundle);

            }


        }


    }

    @Override
    public void onResume() {
        super.onResume();
        Glide.with(getActivity().getApplicationContext())
                .load(urlimg)
                .asBitmap()
                .thumbnail(0.5f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(true)
                .into(img_artista);
        activity.getSupportActionBar().setTitle(nomedoartista);

    }


    public void Errormessageinternet() {
        linearLayoutnointernet.setVisibility(View.VISIBLE);
        linearLayoutartista.setVisibility(View.GONE);
    }


}

