package ocdev.com.br.lyricseditor.ElementosFragments;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ocdev.com.br.lyricseditor.Adpters.ListadeMusicasAdapter;
import ocdev.com.br.lyricseditor.Constants.Constants;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.ItemTopLyrics;
import ocdev.com.br.lyricseditor.R;
import ocdev.com.br.lyricseditor.TelasFragments.TelaDaLetraFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListadeMusicasDoArtistaFragment extends DialogFragment implements ListadeMusicasAdapter.GetClickListadeMusicas {

    private RecyclerView recyclerView;
    private ListadeMusicasAdapter listadeMusicasAdapter;
    List<ItemTopLyrics> nomedamusica;
    TextView txttituloListadeMusicas;
    public LetraMusicaElemento letraMusicaElemento;
    private TelaDaLetraFragment telaDaLetraFragment;
    private Bundle bundle;

    public ListadeMusicasDoArtistaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewroot = inflater.inflate(R.layout.fragment_elementosdo_artista, container, false);
        recyclerView = (RecyclerView) viewroot.findViewById(R.id.recycler_elemento_artistas);
        txttituloListadeMusicas = (TextView) viewroot.findViewById(R.id.txttituloelementosdoartista);
        bundle = new Bundle();
        listadeMusicasAdapter = new ListadeMusicasAdapter(this);
        letraMusicaElemento = new LetraMusicaElemento();
        Bundle bundle = new Bundle();
        telaDaLetraFragment = new TelaDaLetraFragment();

        if (bundle != null) {
            bundle = this.getArguments();
            nomedamusica = bundle.getParcelableArrayList(Constants.CHAVE_LISTA_MUSICA);

        }
        listadeMusicasAdapter.setListadeMusicas(nomedamusica);

        return viewroot;
    }

    @Override
    public void onResume() {
        super.onResume();
        txttituloListadeMusicas.setText(getString(R.string.topmusicas));
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listadeMusicasAdapter);
    }


    @Override
    public void getindicelistademusicas(int indice) {

        String id = nomedamusica.get(indice).getId();

        bundle.putString(Constants.FRAGMENT_TELA_DETALHE, Constants.FRAGMENT_ELEMENTO_LETRA);
        bundle.putString(Constants.CHAVE_ID_LETRA, id);

        telaDaLetraFragment.setArguments(bundle);

        telaDaLetraFragment.setStyle(0, android.R.style.Theme_Black_NoTitleBar_Fullscreen);

        telaDaLetraFragment.show(getActivity().getSupportFragmentManager(), telaDaLetraFragment.getTag());


    }
}
