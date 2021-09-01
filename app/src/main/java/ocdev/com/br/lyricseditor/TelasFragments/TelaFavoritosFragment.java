package ocdev.com.br.lyricseditor.TelasFragments;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import ocdev.com.br.lyricseditor.Adpters.FavoritosAdapter;
import ocdev.com.br.lyricseditor.ElementosFragments.FragmentLetradeMusicaFavoritos;
import ocdev.com.br.lyricseditor.Interfaces.ResultadoLetraFavoritos;
import ocdev.com.br.lyricseditor.Loader.CarregarListadeFavoritos;
import ocdev.com.br.lyricseditor.R;
import ocdev.com.br.lyricseditor.Utils.ScreenUtils;

import static ocdev.com.br.lyricseditor.Constants.Constants.ID_LISTA_FAVORITOS;

/**
 * A simple {@link Fragment} subclass.
 */
public class TelaFavoritosFragment extends Fragment implements ResultadoLetraFavoritos, CarregarListadeFavoritos.GetResultadosListadeFavoritos, FavoritosAdapter.DeleteRestart {
    private CarregarListadeFavoritos carregarListadeFavoritos;
    private FavoritosAdapter favoritosAdapter;
    private android.support.v7.widget.RecyclerView recyclerView;
    Bundle bundle;
    ImageView imgdelete, imgnosong;

    FragmentLetradeMusicaFavoritos fragmentLetradeMusicaFavoritos;

    public TelaFavoritosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_tela_favoritos, container, false);
        recyclerView = (android.support.v7.widget.RecyclerView) rootview.findViewById(R.id.recyclerview_favoritos);
        favoritosAdapter = new FavoritosAdapter(getActivity().getApplicationContext(), this, getActivity(), this);
        carregarListadeFavoritos = new CarregarListadeFavoritos(this, getActivity().getApplicationContext());
        imgdelete = (ImageView) rootview.findViewById(R.id.delete_letra);
        fragmentLetradeMusicaFavoritos = new FragmentLetradeMusicaFavoritos();
        imgnosong = (ImageView) rootview.findViewById(R.id.nosongimg);
        bundle = new Bundle();
        android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        return rootview;
    }


    @Override
    public void onResume() {
        super.onResume();
        getLoaderManager().restartLoader(ID_LISTA_FAVORITOS, null, carregarListadeFavoritos);
    }


    @Override
    public void getResultadoFavoritos(String idletra) {
        fragmentLetradeMusicaFavoritos.setStyle(0, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        fragmentLetradeMusicaFavoritos.show(getActivity().getSupportFragmentManager(), fragmentLetradeMusicaFavoritos.getTag());

        bundle.putString("chavefavorito", idletra);

        fragmentLetradeMusicaFavoritos.setArguments(bundle);
    }

    @Override
    public void getDataCursor(Cursor mCursor) {
        if (mCursor.getCount() < 1) {
            imgnosong.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            imgnosong.setVisibility(View.GONE);
            favoritosAdapter.swapCursor(mCursor);
            GridLayoutManager layoutManager
                    = new GridLayoutManager(getActivity().getApplicationContext(), ScreenUtils.RecuperarNumerodeColunas(getActivity().getApplicationContext()));
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(favoritosAdapter);
            recyclerView.setHasFixedSize(true);
        }

    }

    @Override
    public void onDelete(boolean deletado) {
        if (deletado)
            getLoaderManager().restartLoader(ID_LISTA_FAVORITOS, null, carregarListadeFavoritos);
    }
}
