package ocdev.com.br.lyricseditor;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import ocdev.com.br.lyricseditor.AsyncTasksApi.ResultadosUnicosLetras;
import ocdev.com.br.lyricseditor.Constants.Constants;
import ocdev.com.br.lyricseditor.Loader.CarregarFavoritos;
import ocdev.com.br.lyricseditor.TelasFragments.HistoricoFragment;
import ocdev.com.br.lyricseditor.TelasFragments.InicialFragment;
import ocdev.com.br.lyricseditor.TelasFragments.TelaFavoritosFragment;
import ocdev.com.br.lyricseditor.Utils.NetworkUtils;

public class MainActivity extends AppCompatActivity {

    private android.support.v4.app.FragmentManager fragmentManager;
    private InicialFragment inicialFragment;
    private TelaFavoritosFragment telaFavoritosFragment;
    private FrameLayout frameLayout;
    boolean telafavoritos;
    boolean conexao;
    int currentTela;
    private HistoricoFragment historicoFragment;
    LinearLayout linearLayout;
    Button btnrecarregar;
    CarregarFavoritos carregarFavoritos;
    ResultadosUnicosLetras resultadosUnicosLetras;
    boolean favoritado;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicialFragment = new InicialFragment();
        telaFavoritosFragment = new TelaFavoritosFragment();
        fragmentManager = getSupportFragmentManager();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        carregarFavoritos = new CarregarFavoritos();
        linearLayout = (LinearLayout) findViewById(R.id.layout_nointernet);
        frameLayout = (FrameLayout) findViewById(R.id.id_fragment_home);
        conexao = NetworkUtils.isNetworkConnected(getApplicationContext());
        btnrecarregar = (Button) findViewById(R.id.btnrecarregar);
        historicoFragment = new HistoricoFragment();
        resultadosUnicosLetras = new ResultadosUnicosLetras(this);


        if (savedInstanceState != null) {
            currentTela = savedInstanceState.getInt(Constants.CHAVE_CURRENT_TELA);
            setCurrentTela(currentTela);
        }
        btnrecarregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Conexao();
                ControllerFragments();

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        ControllerFragments();
        if (conexao) {
            ShowViewsconnected();
        }


            resultadosUnicosLetras.setDemoTestFavoritos();



    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(Constants.CHAVE_CURRENT_TELA, getCurrentTela());
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onBackPressed() {
        Conexao();

        if (findViewById(R.id.id_tela_do_artista) != null) {
            AddFragmentPrincipal();
            if (Conexao()) {
                ShowViewsconnected();
            } else {
                Errormessageinternet();
            }
        } else {
            super.onBackPressed();
        }

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_home:
                    Conexao();
                    if (conexao) {
                        ShowViewsconnected();
                        if (!inicialFragment.isAdded())
                            AddFragmentPrincipal();
                    } else {
                        Errormessageinternet();
                    }

                    setCurrentTela(Constants.TELA_PRINCIPAL_RANK);
                    return true;
                case R.id.navigation_dashboard:
                    Conexao();
                    ShowViewsconnected();
                    setCurrentTela(Constants.TELA_FAVORITOS);

                    if (!telaFavoritosFragment.isAdded())
                        AddFragmentFavoritos();
                    telafavoritos = true;
                    return true;

                case R.id.historico:
                    Conexao();
                    if (conexao) {
                        ShowViewsconnected();
                        if (!historicoFragment.isAdded())
                            AddFragmenthistorico();
                    } else {
                        Errormessageinternet();
                    }
                    setCurrentTela(Constants.TELA_HISTORICO);
                    return true;
            }
            return false;
        }
    };

    public int getCurrentTela() {
        return currentTela;
    }

    public void setCurrentTela(int currentTela) {
        this.currentTela = currentTela;
    }

    public void Errormessageinternet() {
        linearLayout.setVisibility(View.VISIBLE);
        frameLayout.setVisibility(View.GONE);
    }

    public void ShowViewsconnected() {
        linearLayout.setVisibility(View.GONE);
        frameLayout.setVisibility(View.VISIBLE);

    }

    public boolean Conexao() {
        conexao = NetworkUtils.isNetworkConnected(getApplicationContext());
        return conexao;
    }

    public void AddFragmentPrincipal() {

        fragmentManager.beginTransaction()
                .replace(R.id.id_fragment_home, inicialFragment, inicialFragment.getTag())
                .commit();

    }

    public void AddFragmenthistorico() {

        fragmentManager.beginTransaction()
                .replace(R.id.id_fragment_home, historicoFragment, historicoFragment.getTag())
                .commit();

    }


    public void AddFragmentFavoritos() {
        fragmentManager.beginTransaction().addToBackStack(null)
                .replace(R.id.id_fragment_home, telaFavoritosFragment, telaFavoritosFragment.getTag())
                .commit();
    }

    public void ControllerFragments() {

        if (conexao) {
            if (currentTela == 0) {
                if (!inicialFragment.isAdded()) {
                    AddFragmentPrincipal();
                    setCurrentTela(Constants.TELA_PRINCIPAL_RANK);
                    ShowViewsconnected();
                }
            } else if (getCurrentTela() == Constants.TELA_PRINCIPAL_RANK) {

                AddFragmentPrincipal();
                ShowViewsconnected();
            } else if (getCurrentTela() == Constants.TELA_HISTORICO) {

                setCurrentTela(Constants.TELA_HISTORICO);
                AddFragmenthistorico();
                ShowViewsconnected();
            }


        } else {
            Errormessageinternet();
        }

        if (getCurrentTela() == Constants.TELA_FAVORITOS) {
            AddFragmentFavoritos();
            ShowViewsconnected();
            setCurrentTela(Constants.TELA_FAVORITOS);
        }


    }



}
