package ocdev.com.br.lyricseditor.TelasFragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import ocdev.com.br.lyricseditor.Constants.Constants;
import ocdev.com.br.lyricseditor.ElementosFragments.LetraMusicaElemento;
import ocdev.com.br.lyricseditor.R;
import ocdev.com.br.lyricseditor.Utils.NetworkUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class TelaDaLetraFragment extends DialogFragment {
    private LetraMusicaElemento letraMusicaElemento;
    private String result;
    private Bundle bundle;
    private android.support.v7.widget.Toolbar toolbar;
    private LinearLayout linearLayout;
    private FrameLayout frameLayout;
    private String nomedamusica;
    private String nomedoartista;

    public TelaDaLetraFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ValidFragment")
    public TelaDaLetraFragment(String nomedamusica, String nomedoartista) {

        this.nomedamusica = nomedamusica;
        this.nomedoartista = nomedoartista;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewroot = inflater.inflate(R.layout.fragment_tela_da_letra, container, false);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        letraMusicaElemento = new LetraMusicaElemento();
        bundle = new Bundle();
        linearLayout = (LinearLayout) viewroot.findViewById(R.id.layout_nointernet);
        frameLayout = (FrameLayout) viewroot.findViewById(R.id.framelayout_letra);
        if (bundle != null) {
            bundle = this.getArguments();
            result = bundle.getString(Constants.CHAVE_ID_LETRA);


        }
        Button btnrecarregar = (Button) viewroot.findViewById(R.id.btnrecarregar);

        toolbar = (Toolbar) viewroot.findViewById(R.id.toolbar_tela_letra);
        activity.setSupportActionBar(toolbar);


        btnrecarregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddFragmentLetra();
            }
        });
        return viewroot;
    }


    @Override
    public void onResume() {
        super.onResume();

        AddFragmentLetra();

    }


    public Toolbar getToolbar() {

        return toolbar;
    }



    public void AddFragmentLetra() {
        if (NetworkUtils.isNetworkConnected(getActivity().getApplicationContext())) {

            if (!letraMusicaElemento.isAdded()) {
                this.getChildFragmentManager().beginTransaction().addToBackStack(null)
                        .replace(R.id.framelayout_letra, letraMusicaElemento, Constants.FRAGMENT_ELEMENTO_LETRA)
                        .commit();
                bundle.putString(Constants.CHAVE_ID_LETRA, result);


                letraMusicaElemento.setArguments(bundle);
                ShowViewsconnected();
            }
        } else {
            Errormessageinternet();

        }
    }

    public void Errormessageinternet() {
        linearLayout.setVisibility(View.VISIBLE);
        frameLayout.setVisibility(View.GONE);
    }

    public void ShowViewsconnected() {
        linearLayout.setVisibility(View.GONE);
        frameLayout.setVisibility(View.VISIBLE);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().onBackPressed();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
