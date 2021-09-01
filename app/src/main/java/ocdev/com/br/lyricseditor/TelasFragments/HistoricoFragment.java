package ocdev.com.br.lyricseditor.TelasFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

import ocdev.com.br.lyricseditor.Model.RankingMusica.Historico.HistoricoLetra;
import ocdev.com.br.lyricseditor.R;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoricoFragment extends Fragment {

    private DatabaseReference mDatabase;
    private ArrayList<String> listahistorico;
    ListView list;
    Query recentPostsQuery;
    Button btnrecarregar;

    public HistoricoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_historico, container, false);
        list = (ListView) rootview.findViewById(R.id.listadehistorico);

        btnrecarregar = (Button) getActivity().findViewById(R.id.btnrecarregar) ;
        mDatabase = FirebaseDatabase.getInstance().getReference().child("historico").child("info");
        recentPostsQuery = mDatabase.limitToLast(3).orderByPriority();
        listahistorico = new ArrayList<>();


        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();
        recentPostsQuery.addChildEventListener(new ChildEventListener() {
                                                   @Override
                                                   public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                                       Log.d(TAG, "onChildChanged:" + dataSnapshot.getKey());
                                                       HistoricoLetra post = dataSnapshot.getValue(HistoricoLetra.class);
                                                       listahistorico.add(post.getNomemusica() + "\n" + post.getIdmusica());
if (isAdded()) {
    ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, listahistorico);
    list.setAdapter(itemsAdapter);
    Log.v("testefirebase", post.getNomemusica());
}
                                                   }

                                                   @Override
                                                   public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                                                   }

                                                   @Override
                                                   public void onChildRemoved(DataSnapshot dataSnapshot) {

                                                   }

                                                   @Override
                                                   public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                                                   }

                                                   @Override
                                                   public void onCancelled(DatabaseError databaseError) {

                                                   }


                                               }


        );


    }
}

