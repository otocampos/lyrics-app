package ocdev.com.br.lyricseditor.ElementosFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ocdev.com.br.lyricseditor.Adpters.AlbunsAdapter;
import ocdev.com.br.lyricseditor.Constants.Constants;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.ItemAlbums;
import ocdev.com.br.lyricseditor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlbunsdoArtistaFragment extends Fragment {
    RecyclerView mRecyclerview;
    private AlbunsAdapter albunsAdapter;
    List<ItemAlbums> albuns;
    private TextView txtTituloAlbuns;

    public AlbunsdoArtistaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_elementosdo_artista, container, false);
        mRecyclerview = (RecyclerView) rootview.findViewById(R.id.recycler_elemento_artistas);
        txtTituloAlbuns = (TextView) rootview.findViewById(R.id.txttituloelementosdoartista);

        albunsAdapter = new AlbunsAdapter();

        Bundle bundle = new Bundle();
        if (bundle != null) {
            bundle = this.getArguments();
            albuns = bundle.getParcelableArrayList(Constants.CHAVE_LISTA_ALBUM);

        }

        albunsAdapter.setListadeAlbuns(albuns);

        return rootview;


    }

    @Override
    public void onResume() {
        super.onResume();
        txtTituloAlbuns.setText(getString(R.string.albuns));
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerview.setLayoutManager(layoutManager);
        mRecyclerview.setAdapter(albunsAdapter);


    }

}
