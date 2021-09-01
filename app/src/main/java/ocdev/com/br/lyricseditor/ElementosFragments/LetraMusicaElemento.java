package ocdev.com.br.lyricseditor.ElementosFragments;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ocdev.com.br.lyricseditor.AsyncTasksApi.AsyncTaskLetra;
import ocdev.com.br.lyricseditor.AsyncTasksApi.ResultadosUnicosLetras;
import ocdev.com.br.lyricseditor.Constants.Constants;
import ocdev.com.br.lyricseditor.Interfaces.ResultadoAsynctaskLetra;
import ocdev.com.br.lyricseditor.Loader.CarregarFavoritos;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Letra.ResultadoLetras;
import ocdev.com.br.lyricseditor.R;
import ocdev.com.br.lyricseditor.TelasFragments.TelaDaLetraFragment;
import ocdev.com.br.lyricseditor.Utils.NetworkUtils;
import ocdev.com.br.lyricseditor.Widget.LetraWidgetService;
import ocdev.com.br.lyricseditor.data.FavoriteContract;

import static ocdev.com.br.lyricseditor.Constants.Constants.ID_DETAIL_LOADER;

/**
 * A simple {@link Fragment} subclass.
 */
public class LetraMusicaElemento extends Fragment implements ResultadoAsynctaskLetra, CarregarFavoritos.ResultadoConferirFavoritado {
    TextView textView;
    CircularImageView imgartista, favoritar;
    Switch mSwitch;
    AsyncTaskLetra asyncTaskLetra;
    android.support.v7.widget.Toolbar toolbar;
    int categoriaexibida;
    TelaDaLetraFragment telaDaLetraFragment;
    FragmentManager fragmentManager;
    TextView txtnomedamusica;
    TextView txtnomedoartista;
    CarregarFavoritos carregarFavoritos;
    private boolean isfavoritado;
    Context mContext;
    String id_musica;
    ProgressBar pb;
    CircularImageView share;
    FirebaseDatabase database;
    DatabaseReference myRef;

    public LetraMusicaElemento() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_letra_musica_elemento, container, false);
        textView = (TextView) rootview.findViewById(R.id.idletrademusica);
        mSwitch = (Switch) rootview.findViewById(R.id.toggleButton);
        imgartista = (CircularImageView) rootview.findViewById(R.id.img_artista);
        favoritar = (CircularImageView) rootview.findViewById(R.id.favoritar);
        txtnomedamusica = (TextView) rootview.findViewById(R.id.nome);
        txtnomedoartista = (TextView) rootview.findViewById(R.id.nomeartista);
        telaDaLetraFragment = new TelaDaLetraFragment();
        carregarFavoritos = new CarregarFavoritos(this);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("historico");

        mContext = getActivity().getApplicationContext();
        pb = (ProgressBar) rootview.findViewById(R.id.progressbarinicial);
        Bundle extrasbundle = this.getArguments();
        share = (CircularImageView) rootview.findViewById(R.id.shareletra);

        if (extrasbundle != null) {
            id_musica = extrasbundle.getString(Constants.CHAVE_ID_LETRA);
            categoriaexibida = extrasbundle.getInt("categoria");

            setAsyncTaskLetra(asyncTaskLetra);
        }
        toolbar = (android.support.v7.widget.Toolbar) getActivity().findViewById(R.id.toolbar_tela_letra);
        fragmentManager = getActivity().getSupportFragmentManager();


        return rootview;


    }


    @Override
    public void getResultadoLetra(final ResultadoLetras resultadoLetras) {
        if (resultadoLetras != null) {
            pb.setVisibility(View.GONE
            );
        }

        if (resultadoLetras.getMus().get(0).getLang() == Constants.lINGUA_INGLES) {
            mSwitch.setVisibility(View.VISIBLE);
            if (resultadoLetras.getMus().get(0).getTranslate() != null) {
                if (textView.getText().equals(resultadoLetras.getMus().get(0).getTranslate().get(0).getText())) {
                    mSwitch.setVisibility(View.GONE);
                }
            }
        } else if (resultadoLetras.getMus().get(0).getLang() == Constants.lINGUA_PORTUGUES) {
            mSwitch.setVisibility(View.GONE);
        }

        mSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSwitch.isChecked()) {
                    textView.setText(resultadoLetras.getMus().get(0).getTranslate().get(0).getText());
                    mSwitch.setText(getString(R.string.letra));
                } else {

                    textView.setText(resultadoLetras.getMus().get(0).getText());

                    mSwitch.setText(getString(R.string.trad));
                }
            }
        });

        if (isAdded()) {
            Glide.with(mContext)
                    .load(resultadoLetras.getArt().getUrl() + "/images/profile.jpg")
                    .asBitmap()
                    .thumbnail(0.5f)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .skipMemoryCache(true)
                    .into(imgartista);

            txtnomedamusica.setText(resultadoLetras.getMus().get(0).getName());
            txtnomedoartista.setText(resultadoLetras.getArt().getName());
            if (categoriaexibida == Constants.RANKING_LISTA_INDEX_MUSICAS_TRADUCOES) {
                if (resultadoLetras.getMus().get(0).getTranslate() != null) {
                    textView.setText(resultadoLetras.getMus().get(0).getTranslate().get(0).getText());
                } else {
                    textView.setText(getString(R.string.semtrad) + " \n\n" + resultadoLetras.getMus().get(0).getText());
                }
            } else {
if (resultadoLetras.getMus().get(0)!=null){
                textView.setText(resultadoLetras.getMus().get(0).getText());
}else{
    Toast.makeText(mContext, getString(R.string.erro), Toast.LENGTH_SHORT).show();
}
            }

            favoritar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isfavoritado) {
                        final ResultadosUnicosLetras resultadosUnicosLetras = new ResultadosUnicosLetras(getActivity());
                        resultadosUnicosLetras.setResultLetra(resultadoLetras);
                        resultadosUnicosLetras.FavoritarLetras();
                        favoritar.setImageResource(R.drawable.ic_favorite);
                        LetraWidgetService.startActionUpdateLetraWidgets(getActivity().getApplicationContext());

                    } else {
                        isfavoritado = false;
                        Uri uri_item = FavoriteContract.FavoriteEntry.CONTENT_URI.buildUpon().appendPath(resultadoLetras.getMus().get(0).getId()).build();
                        favoritar.setImageResource(R.drawable.ic_favorite_border);
                        getActivity().getContentResolver().delete(uri_item, Constants.ID_COLLUMN_CONSULTA_UNICA_LETRA, null);
                        Toast.makeText(getActivity().getApplicationContext(), getString(R.string.deletado), Toast.LENGTH_SHORT).show();

                    }


                }
            });

            carregarFavoritos.setIdfavorito(mContext, resultadoLetras.getMus().get(0).getId());

            getLoaderManager().restartLoader(ID_DETAIL_LOADER, null, carregarFavoritos);
            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NetworkUtils.Compartilhar(getActivity().getApplicationContext(), resultadoLetras.getMus().get(0).getName() + "\n" + resultadoLetras.getMus().get(0).getUrl() + "\n" + resultadoLetras.getMus().get(0).getText());


                }
            });
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        asyncTaskLetra = new AsyncTaskLetra(this);
        asyncTaskLetra.execute(id_musica);


    }


    public void setAsyncTaskLetra(AsyncTaskLetra asyncTaskLetra) {
        this.asyncTaskLetra = asyncTaskLetra;
    }


    @Override
    public void isFavoritado(boolean favoritado, String nomeart, String nomemus, String urlimg, String urlmus, String letramus) {
        this.isfavoritado = favoritado;
        if (favoritado) {
            favoritar.setImageResource(R.drawable.ic_favorite);

        }
    }

}

