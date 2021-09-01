package ocdev.com.br.lyricseditor.ElementosFragments;


import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import ocdev.com.br.lyricseditor.Adpters.RankAdapter;
import ocdev.com.br.lyricseditor.AsyncTasksApi.ResultadosUnicosArtista;
import ocdev.com.br.lyricseditor.Constants.Constants;
import ocdev.com.br.lyricseditor.Loader.CarregarFavoritos;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Result;
import ocdev.com.br.lyricseditor.R;
import ocdev.com.br.lyricseditor.TelasFragments.FragmentBottomMusicasArtista;
import ocdev.com.br.lyricseditor.TelasFragments.TelaDaLetraFragment;
import ocdev.com.br.lyricseditor.TelasFragments.TeladoArtistaFragment;
import ocdev.com.br.lyricseditor.Utils.NetworkUtils;
import ocdev.com.br.lyricseditor.Utils.OpenJsonUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class RankInicialFragment extends Fragment implements RankAdapter.RankAdapteronClickHandler {

    private RecyclerView mRecyclerview_Top_musicas;
    private RankAdapter mRankAdapter;
    private int categoriaExibida;
    private TextView txtTituloCategorias;
    private FetchTask fetchTask;
    private Result result;
    private ArrayList<Result> listaresultados;
    private Bundle bundle;
    private android.support.v4.app.FragmentManager fragmentManager;
    private TeladoArtistaFragment teladoArtistaFragment;

    CarregarFavoritos carregarFavoritos;
    LinearLayoutManager linearLayoutManager;
    private ArrayList<String> listadeEscopossalvos;
    private ProgressBar progressBar;

    public RankInicialFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public RankInicialFragment(ArrayList<Result> listaresultados) {
        this.listaresultados = listaresultados;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_rank_inicial, container, false);
        mRecyclerview_Top_musicas = (RecyclerView) rootview.findViewById(R.id.recycler_top_musicas);
        mRankAdapter = new RankAdapter(this, getActivity().getApplicationContext(), getActivity());
        txtTituloCategorias = (TextView) rootview.findViewById(R.id.txt_top_musicas);
        teladoArtistaFragment = new TeladoArtistaFragment();
        fetchTask = new FetchTask();
        bundle = new Bundle();
        result = new Result();
        listaresultados = new ArrayList<>();
        carregarFavoritos = new CarregarFavoritos();
        linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        ResultadosUnicosArtista resultadosUnicosArtista = new ResultadosUnicosArtista();
        listadeEscopossalvos = new ArrayList<>();
        progressBar = (ProgressBar) rootview.findViewById(R.id.progressbarinicial);


        if (savedInstanceState != null) {
            listaresultados = savedInstanceState.getParcelableArrayList(Constants.CHAVE_LISTA_DE_ESCOPOS);
            mRankAdapter.setRankingData(listaresultados);
            mRankAdapter.setCategoriaexibida(categoriaExibida);

        } else {
            fetchTask.execute();
        }

        setTextTituloCategoria();
        fragmentManager = getActivity().getSupportFragmentManager();


        return rootview;
    }


    @SuppressLint("RestrictedApi")
    @Override
    public void onClick(int indice) {
        // intent = new Intent();
        result = fetchTask.getResults().get(categoriaExibida);

        if (categoriaExibida == Constants.RANKING_LISTA_INDEX_MUSICAS_LYRICS) {
            String nomemusica = result.getMus().getWeek().getLyrics().get(indice).getName();
            String nomeartista = result.getMus().getWeek().getLyrics().get(indice).getArt().getName();
            categoriaExibida = Constants.RANKING_LISTA_INDEX_MUSICAS_LYRICS;
            CarregarTeladeLetra(result.getMus().getWeek().getLyrics().get(indice).getId(), nomemusica, nomeartista);

        } else if (categoriaExibida == Constants.RANKING_LISTA_INDEX_MUSICAS_TRADUCOES) {
            String nomemusica = result.getMus().getWeek().getTranslations().get(indice).getName();
            String nomeartista = result.getMus().getWeek().getTranslations().get(indice).getArt().getName();
            categoriaExibida = Constants.RANKING_LISTA_INDEX_MUSICAS_TRADUCOES;

            CarregarTeladeLetra(result.getMus().getWeek().getTranslations().get(indice).getId(), nomemusica, nomeartista);
        } else if (categoriaExibida == Constants.RANKING_LISTA_INDEX_ARTISTAS_NACIONAL) {
            CarregarTeladoArtista(result.getArt().getWeek().getNacional().get(indice).getUrl(), result.getArt().getWeek().getNacional().get(indice).getPicMedium(), result.getArt().getWeek().getNacional().get(indice).getName());
        } else if (categoriaExibida == Constants.RANKING_LISTA_INDEX_ARTISTAS_INTERNACIONAL) {
            CarregarTeladoArtista(result.getArt().getWeek().getInternacional().get(indice).getUrl(), result.getArt().getWeek().getInternacional().get(indice).getPicMedium(), result.getArt().getWeek().getInternacional().get(indice).getName());

        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (!fetchTask.getListadeEscopos().isEmpty()) {
            outState.putParcelableArrayList(Constants.CHAVE_LISTA_DE_ESCOPOS, fetchTask.getResults());
            Log.v("ototeste", fetchTask.getListadeEscopos().toString() + "saveinstance");
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onLongClcick(int indice) {

        result = fetchTask.getResults().get(categoriaExibida);

        FragmentBottomMusicasArtista bottomSheetFragment = new FragmentBottomMusicasArtista(result, indice, categoriaExibida);
        bottomSheetFragment.show(getActivity().getSupportFragmentManager(), bottomSheetFragment.getTag());
    }

    @SuppressLint("ResourceType")
    public void CarregarTeladeLetra(String id, String nomemusica, String nomeartista) {

        TelaDaLetraFragment telaDaLetraFragment = new TelaDaLetraFragment(nomemusica, nomeartista);

        telaDaLetraFragment.setStyle(0, android.R.style.Theme_Black_NoTitleBar_Fullscreen);

        telaDaLetraFragment.show(getActivity().getSupportFragmentManager(), telaDaLetraFragment.getTag());


        bundle.putString(Constants.FRAGMENT_TELA_DETALHE, Constants.FRAGMENT_ELEMENTO_LETRA);
        bundle.putString(Constants.CHAVE_ID_LETRA, id);

        telaDaLetraFragment.setArguments(bundle);


    }

    @Override
    public void onDetach() {
        super.onDetach();


    }

    public void CarregarTeladoArtista(String urldoartista, String picMedium, String nomedoartista) {


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

            ImageView ivProfile = (ImageView) getActivity().findViewById(R.id.item_letras_img);
            fragmentManager.beginTransaction().addToBackStack(Constants.TRANSACTION)
                    .addSharedElement(ivProfile, Constants.ANIM_ART)
                    .replace(R.id.id_fragment_home, teladoArtistaFragment)
                    .commit();


        } else {

            fragmentManager.beginTransaction().addToBackStack(null)
                    .replace(R.id.id_fragment_home, teladoArtistaFragment)
                    .commit();
        }

        bundle.putString(Constants.CHAVE_URL_IMG, picMedium);
        bundle.putString(Constants.CHAVE_NOME_ARTISTA, nomedoartista);
        bundle.putString(Constants.CHAVE_ID_ARTISTA, urldoartista);

        teladoArtistaFragment.setArguments(bundle);

    }

    @Override
    public void onResume() {
        super.onResume();
        if (isAdded())
            if (listadeEscopossalvos != null && listadeEscopossalvos.size() > 0) {
                mRankAdapter.setRankingData(listaresultados);
                mRankAdapter.setCategoriaexibida(categoriaExibida);

                mRecyclerview_Top_musicas.setLayoutManager(linearLayoutManager);
                mRecyclerview_Top_musicas.setAdapter(mRankAdapter);
            }

    }


    public class FetchTask extends AsyncTask<Void, Void, ArrayList<Result>> {
        private ArrayList<Result> results = new ArrayList<>();
        private ArrayList<String> listadeEscopos = new ArrayList<>();
        private RankInicialFragment rankInicialFragment;

        @Override
        protected ArrayList<Result> doInBackground(Void... voids) {
            OpenJsonUtils openJsonUtils = new OpenJsonUtils();
            URL RankingLyricsRequest = NetworkUtils.buildUrlRankingMusicas(Constants.TYPE_MUSICA, Constants.ESCOPO_LYRICS);
            URL RankingArtistaNacionalRequest = NetworkUtils.buildUrlRankingMusicas(Constants.TYPE_ARTISTA, Constants.ESCOPO_NACIONAL);
            URL RankingArtistaInternacionalRequest = NetworkUtils.buildUrlRankingMusicas(Constants.TYPE_ARTISTA, Constants.ESCOPO_INTERNATIONAL);
            URL RankingTraducaoRequest = NetworkUtils.buildUrlRankingMusicas(Constants.TYPE_MUSICA, Constants.ESCOPO_TRANSLATIONS);

            try {
                ArrayList<String> listadeEscopos = new ArrayList<>();
                listadeEscopos.add(NetworkUtils.getResponseFromHttpUrl(RankingLyricsRequest));
                listadeEscopos.add(NetworkUtils.getResponseFromHttpUrl(RankingArtistaNacionalRequest));
                listadeEscopos.add(NetworkUtils.getResponseFromHttpUrl(RankingArtistaInternacionalRequest));
                listadeEscopos.add(NetworkUtils.getResponseFromHttpUrl(RankingTraducaoRequest));

                setListadeEscopos(listadeEscopos);
                return OpenJsonUtils.getListaResultados(listadeEscopos);
            } catch (IOException e) {
                e.printStackTrace();
                return null;

            }
        }

        @Override
        protected void onPostExecute(ArrayList<Result> results) {
            this.results = results;
            if (results != null)
                rankInicialFragment = new RankInicialFragment(results);
            mRankAdapter.setRankingData(results);
            mRankAdapter.setCategoriaexibida(categoriaExibida);

            mRecyclerview_Top_musicas.setLayoutManager(linearLayoutManager);
            mRecyclerview_Top_musicas.setAdapter(mRankAdapter);

            progressBar.setVisibility(View.GONE);
        }

        public ArrayList<Result> getResults() {
            return results;
        }


        public ArrayList<String> getListadeEscopos() {
            return listadeEscopos;
        }

        public void setListadeEscopos(ArrayList<String> listadeEscopos) {
            this.listadeEscopos = listadeEscopos;
        }
    }


    public void setCategoriaExibida(int categoriaExibida) {
        this.categoriaExibida = categoriaExibida;
    }

    public void setTextTituloCategoria() {
        if (categoriaExibida == Constants.RANKING_LISTA_INDEX_MUSICAS_LYRICS) {
            txtTituloCategorias.setText(getString(R.string.top_letras));
        }
        if (categoriaExibida == Constants.RANKING_LISTA_INDEX_ARTISTAS_NACIONAL) {
            txtTituloCategorias.setText(getString(R.string.top_nacional_titulo));
        }
        if (categoriaExibida == Constants.RANKING_LISTA_INDEX_ARTISTAS_INTERNACIONAL) {
            txtTituloCategorias.setText(getString(R.string.top_internacional_titulo));
        }
        if (categoriaExibida == Constants.RANKING_LISTA_INDEX_MUSICAS_TRADUCOES) {
            txtTituloCategorias.setText(getString(R.string.top_traducoes_titulo));
        }

    }

    @Override
    public void onDestroyView() {

        if (fetchTask != null) {
            fetchTask.cancel(true);
        }
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        if (fetchTask != null) {
            fetchTask.cancel(true);
        }

        super.onDestroy();
    }


}
