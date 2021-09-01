package ocdev.com.br.lyricseditor.TelasFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import ocdev.com.br.lyricseditor.Constants.Constants;
import ocdev.com.br.lyricseditor.ElementosFragments.RankInicialFragment;
import ocdev.com.br.lyricseditor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InicialFragment extends Fragment {
    private RankInicialFragment rankTopLyricsFragment;
    private RankInicialFragment rankTopTraducaoFragment;
    private RankInicialFragment rankTopArtistaNacionalFragment;
    private RankInicialFragment rankTopArtistaInternacionalFragment;

    private android.support.v4.app.FragmentManager fragmentManager;

    boolean fragmentadicionado;

    public InicialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
View rootview=inflater.inflate(R.layout.fragment_inicial, container, false);
        rankTopLyricsFragment = new RankInicialFragment();
        rankTopTraducaoFragment = new RankInicialFragment();
        rankTopArtistaNacionalFragment = new RankInicialFragment();
        rankTopArtistaInternacionalFragment = new RankInicialFragment();


        fragmentManager = getActivity().getSupportFragmentManager();


        rankTopLyricsFragment.setCategoriaExibida(Constants.RANKING_LISTA_INDEX_MUSICAS_LYRICS);
        rankTopTraducaoFragment.setCategoriaExibida(Constants.RANKING_LISTA_INDEX_MUSICAS_TRADUCOES);
        rankTopArtistaNacionalFragment.setCategoriaExibida(Constants.RANKING_LISTA_INDEX_ARTISTAS_NACIONAL);
        rankTopArtistaInternacionalFragment.setCategoriaExibida(Constants.RANKING_LISTA_INDEX_ARTISTAS_INTERNACIONAL);
        if (savedInstanceState != null) {
            if (savedInstanceState.getString(Constants.CHAVE_FRAGMENT_CARREGADO).equals(Constants.CHAVE_FRAGMENT)) {
                fragmentadicionado = true;
            }
        }

        AdView mAdView = (AdView) rootview.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!rankTopLyricsFragment.isAdded() && !fragmentadicionado) {
            fragmentManager.beginTransaction()
                    .add(R.id.lyrics_inicial_fragment, rankTopLyricsFragment, Constants.FRAGMENT_TOP_LYRICS)
                    .add(R.id.lyrics_inicial_fragment, rankTopTraducaoFragment, Constants.FRAGMENT_TOP_TRADUCOES)
                    .add(R.id.lyrics_inicial_fragment, rankTopArtistaNacionalFragment, Constants.FRAGMENT_TOP_ARTISTA_NACIONAL)
                    .add(R.id.lyrics_inicial_fragment, rankTopArtistaInternacionalFragment, Constants.FRAGMENT_TOP_ARTISTA_INTERNACIONAL)
                    .commit();
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(Constants.CHAVE_FRAGMENT_CARREGADO, Constants.CHAVE_FRAGMENT);
    }
}
