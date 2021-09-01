package ocdev.com.br.lyricseditor.Adpters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.ItemTopLyrics;
import ocdev.com.br.lyricseditor.R;

/**
 * Created by Oto on 27/03/2018.
 */

public class ListadeMusicasAdapter extends RecyclerView.Adapter<ListadeMusicasAdapter.TelaArtistaAdapterViewHolder> {
    private List<ItemTopLyrics> resultArtista;
    int layoutIdForListItem;
    private GetClickListadeMusicas getClickListadeMusicas;

    public interface GetClickListadeMusicas {
        void getindicelistademusicas(int indice);
    }

    public ListadeMusicasAdapter(GetClickListadeMusicas getClickListadeMusicas) {
        this.getClickListadeMusicas = getClickListadeMusicas;
    }

    public ListadeMusicasAdapter() {
    }


    @Override
    public ListadeMusicasAdapter.TelaArtistaAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();


        layoutIdForListItem = R.layout.lista_de_musicas_artista;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);


        return new TelaArtistaAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(TelaArtistaAdapterViewHolder holder, final int position) {

        holder.txtnomedamusica.setText(resultArtista.get(position).getDesc());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getClickListadeMusicas.getindicelistademusicas(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultArtista.size();
    }


    public class TelaArtistaAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtnomedamusica;

        public View view;

        public TelaArtistaAdapterViewHolder(View view) {
            super(view);
            this.view = view;
            txtnomedamusica = (TextView) view.findViewById(R.id.nomedamusica);


            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        }


    }

    public void setListadeMusicas(List<ItemTopLyrics> result) {
        this.resultArtista = result;
    }


}
