package ocdev.com.br.lyricseditor.ElementosFragments;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ocdev.com.br.lyricseditor.Adpters.ArtistasRelacionadosAdapter;
import ocdev.com.br.lyricseditor.Constants.Constants;
import ocdev.com.br.lyricseditor.R;
import ocdev.com.br.lyricseditor.TelasFragments.TeladoArtistaFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtistaRelacionadosFragment extends Fragment implements ArtistasRelacionadosAdapter.GetClick {
    private RecyclerView mRecyclerview;
    private ArtistasRelacionadosAdapter artistasRelacionadosAdapter;
    private List<ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.Related> listrel;
    private TextView txttituloRel;
    private FragmentManager fragmentManager;
    private TeladoArtistaFragment teladoArtistaFragment;
    private Bundle bundle;

    public ArtistaRelacionadosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_elementosdo_artista, container, false);
        mRecyclerview = (RecyclerView) rootview.findViewById(R.id.recycler_elemento_artistas);
        artistasRelacionadosAdapter = new ArtistasRelacionadosAdapter(this);
        teladoArtistaFragment = new TeladoArtistaFragment();
        txttituloRel = (TextView) rootview.findViewById(R.id.txttituloelementosdoartista);
        fragmentManager = this.getFragmentManager();
        bundle = new Bundle();
        if (bundle != null) {
            bundle = this.getArguments();
            listrel = bundle.getParcelableArrayList(Constants.CHAVE_ARTISTA_REL);
        }
        artistasRelacionadosAdapter.setListadeArtistasRelacionados(listrel);
        return rootview;
    }


    @Override
    public void onResume() {
        super.onResume();
        txttituloRel.setText(getString(R.string.artrel));
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerview.setLayoutManager(layoutManager);
        mRecyclerview.setAdapter(artistasRelacionadosAdapter);

    }

    @Override
    public void getIndiceRelArtistas(int id, String urlimg, String name) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition changeTransform = TransitionInflater.from(getActivity().getApplicationContext()).
                    inflateTransition(R.transition.change_image_transform);
            Transition explodeTransform = TransitionInflater.from(getActivity().getApplicationContext()).
                    inflateTransition(android.R.transition.explode);
            explodeTransform.setDuration(300);
            this.setSharedElementReturnTransition(changeTransform);
            this.setExitTransition(explodeTransform);

            // Setup enter transition on second fragment
            teladoArtistaFragment.setSharedElementEnterTransition(changeTransform);
            teladoArtistaFragment.setEnterTransition(explodeTransform);

            ImageView ivProfile = (ImageView) getActivity().findViewById(R.id.img_related_artista);
            fragmentManager.beginTransaction().addToBackStack(null)
                    .replace(R.id.id_fragment_home, teladoArtistaFragment)
                    .addToBackStack(Constants.TRANSACTION)
                    .addSharedElement(ivProfile, Constants.ANIM_ART)
                    .commit();
        } else {
            fragmentManager.beginTransaction().addToBackStack(null)
                    .replace(R.id.id_fragment_home, teladoArtistaFragment)
                    .commit();


        }


        bundle.putString(Constants.CHAVE_URL_IMG, urlimg);
        bundle.putString(Constants.CHAVE_ID_ARTISTA, Constants.BASE_URL_ARTISTAS + listrel.get(id).getUrl());
        bundle.putString(Constants.CHAVE_NOME_ARTISTA, name);
        teladoArtistaFragment.setArguments(bundle);

    }


}
