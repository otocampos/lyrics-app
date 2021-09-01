package ocdev.com.br.lyricseditor.TelasFragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.siyamed.shapeimageview.CircularImageView;

import ocdev.com.br.lyricseditor.AsyncTasksApi.AsyncTaskArtista;
import ocdev.com.br.lyricseditor.AsyncTasksApi.ResultadosUnicosArtista;
import ocdev.com.br.lyricseditor.Constants.Constants;
import ocdev.com.br.lyricseditor.Interfaces.ResultadoAsynctaskArtistas;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.ResultArtista;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Result;
import ocdev.com.br.lyricseditor.R;

/**
 * Created by Oto on 04/03/2018.
 */

public class FragmentBottomMusicasArtista extends BottomSheetDialogFragment implements ResultadoAsynctaskArtistas {
    private Result result;
    private TextView txtnomeartista, categoriadoArtista;
    private ImageView imgartista;
    int indice;
    private LinearLayout contentViewBottomSheet;
    int categoriaExibida;
    ResultadosUnicosArtista resultadosUnicosArtista;
    private Animation slideUpAnimation;
    private String nomeDoArtista, urlpicture, nomedamusica, urldoartista;
    AsyncTaskArtista asyncTaskArtista;

    public FragmentBottomMusicasArtista() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.bottom_sheet_musicas_artista, container, false);

        contentViewBottomSheet = (LinearLayout) rootview.findViewById(R.id.bottom_sheet);
        txtnomeartista = (TextView) rootview.findViewById(R.id.txtnomeartista);
        categoriadoArtista = (TextView) rootview.findViewById(R.id.txtcategoriadoartista);
        ProgressBar progressBar = (ProgressBar) rootview.findViewById(R.id.progressBar);


        resultadosUnicosArtista = new ResultadosUnicosArtista();

        imgartista = (CircularImageView) rootview.findViewById(R.id.img_artista_bottom_sheet);
        slideUpAnimation = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.slide_up_animation);

        if (categoriaExibida == Constants.RANKING_LISTA_INDEX_ARTISTAS_NACIONAL) {
            nomeDoArtista = result.getArt().getWeek().getNacional().get(indice).getName();
            urldoartista = result.getArt().getWeek().getNacional().get(indice).getUrl();
            urlpicture = result.getArt().getWeek().getNacional().get(indice).getPicMedium();

        }
        if (categoriaExibida == Constants.RANKING_LISTA_INDEX_ARTISTAS_INTERNACIONAL) {
            nomeDoArtista = result.getArt().getWeek().getInternacional().get(indice).getName();
            urldoartista = result.getArt().getWeek().getInternacional().get(indice).getUrl();
            urlpicture = result.getArt().getWeek().getInternacional().get(indice).getPicMedium();
        }
        if (categoriaExibida == Constants.RANKING_LISTA_INDEX_MUSICAS_LYRICS) {
            nomeDoArtista = result.getMus().getWeek().getLyrics().get(indice).getArt().getName();
            nomedamusica = result.getMus().getWeek().getLyrics().get(indice).getName();
            urldoartista = result.getMus().getWeek().getLyrics().get(indice).getArt().getUrl();
            urlpicture = result.getMus().getWeek().getLyrics().get(indice).getArt().getPicMedium();

        }
        if (categoriaExibida == Constants.RANKING_LISTA_INDEX_MUSICAS_TRADUCOES) {
            nomeDoArtista = result.getMus().getWeek().getTranslations().get(indice).getArt().getName();
            nomedamusica = result.getMus().getWeek().getTranslations().get(indice).getName();
            urldoartista = result.getMus().getWeek().getTranslations().get(indice).getArt().getUrl();
            urlpicture = result.getMus().getWeek().getTranslations().get(indice).getArt().getPicMedium();

        }

        txtnomeartista.setText(nomeDoArtista);
        asyncTaskArtista = new AsyncTaskArtista(this, progressBar);
        asyncTaskArtista.execute(urldoartista);
        Glide.with(getActivity().getApplicationContext())
                .load(urlpicture)
                .asBitmap()
                .thumbnail(0.5f)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .skipMemoryCache(true)
                .into(imgartista);

        //animarTextos();
        return rootview;

    }


    @SuppressLint("ValidFragment")
    public FragmentBottomMusicasArtista(Result result, int indice, int categoriaExibida) {
        this.result = result;
        this.indice = indice;
        this.categoriaExibida = categoriaExibida;
    }


    @Override
    public void getResultadoArtista(ResultArtista resultArtista) {
        resultadosUnicosArtista.setResultArtista(resultArtista);
        try {
            if (categoriaExibida == Constants.RANKING_LISTA_INDEX_ARTISTAS_INTERNACIONAL || categoriaExibida == Constants.RANKING_LISTA_INDEX_ARTISTAS_NACIONAL) {
                for (int i = 0; i < resultadosUnicosArtista.getNameGenero().size() && i < 3; i++) {
                    if (i <= 3) {
                        categoriadoArtista.append(resultadosUnicosArtista.getNameGenero().get(i) + "/");
                    }


                }
            } else {
                categoriadoArtista.setText(nomedamusica);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        animarTextos();
    }

    public void animarTextos() {

        contentViewBottomSheet.setVisibility(View.VISIBLE);
        imgartista.startAnimation(slideUpAnimation);
        txtnomeartista.setAnimation(slideUpAnimation);
        categoriadoArtista.setAnimation(slideUpAnimation);

    }


}
