package ocdev.com.br.lyricseditor.ElementosFragments;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ocdev.com.br.lyricseditor.Constants.Constants;
import ocdev.com.br.lyricseditor.Loader.CarregarFavoritos;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Historico.HistoricoLetra;
import ocdev.com.br.lyricseditor.R;
import ocdev.com.br.lyricseditor.Utils.NetworkUtils;

import static ocdev.com.br.lyricseditor.Constants.Constants.ID_DETAIL_LOADER;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLetradeMusicaFavoritos extends DialogFragment implements CarregarFavoritos.ResultadoConferirFavoritado {

    private CarregarFavoritos carregarFavoritos;
    String idmusica;
    CircularImageView favoriteimg, artistaimg;
    TextView txtletra, nomemusica, nomeartista;
    ProgressBar progressBar;
    CircularImageView share;
    FirebaseDatabase database;
    DatabaseReference myRef;
    public FragmentLetradeMusicaFavoritos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_letra_musica_elemento, container, false);
        Bundle bundle = this.getArguments();
        favoriteimg = (CircularImageView) rootview.findViewById(R.id.favoritar);
        share = (CircularImageView) rootview.findViewById(R.id.shareletra);
        txtletra = (TextView) rootview.findViewById(R.id.idletrademusica);
        nomeartista = (TextView) rootview.findViewById(R.id.nomeartista);
        nomemusica = (TextView) rootview.findViewById(R.id.nome);
        artistaimg = (CircularImageView) rootview.findViewById(R.id.img_artista);
        if (bundle != null) {
            idmusica = bundle.getString(Constants.CHAVE_FAVORITO);
            carregarFavoritos = new CarregarFavoritos(this);


        }

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("historico");



        progressBar = (ProgressBar) rootview.findViewById(R.id.progressbarinicial);
        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isAdded())
            carregarFavoritos.setIdfavorito(getActivity().getApplicationContext(), idmusica);
        getLoaderManager().initLoader(ID_DETAIL_LOADER, null, carregarFavoritos);
        progressBar.setVisibility(View.GONE);
    }


    @Override
    public void isFavoritado(boolean favoritado, final String nomeart, final String nomemus, String urlimg, final String urlmus, final String letramus) {
        if (favoritado) {
            favoriteimg.setImageResource(R.drawable.ic_favorite);
            txtletra.setText(letramus);
            nomeartista.setText(nomeart);
            nomemusica.setText(nomemus);

            Glide.with(getActivity().getApplicationContext())
                    .load(urlimg)
                    .asBitmap()
                    .thumbnail(0.5f)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .skipMemoryCache(true)
                    .into(artistaimg);
        }

        myRef.child("info").push().setValue(new HistoricoLetra(nomemus,nomeart));



        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkUtils.Compartilhar(getActivity().getApplicationContext(), nomeart + "\n" + nomemus + "\n" + urlmus + "\n" + letramus);
            }
        });
    }
}
