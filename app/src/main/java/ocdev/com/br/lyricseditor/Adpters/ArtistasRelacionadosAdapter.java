package ocdev.com.br.lyricseditor.Adpters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.siyamed.shapeimageview.CircularImageView;

import java.util.List;

import ocdev.com.br.lyricseditor.Constants.Constants;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.Related;
import ocdev.com.br.lyricseditor.R;

/**
 * Created by Oto on 04/04/2018.
 */

public class ArtistasRelacionadosAdapter extends RecyclerView.Adapter<ArtistasRelacionadosAdapter.ArtistasRelacionadosAdapterViewHolder> {
    private Context context;
    private List<Related> resutadolistadeArtistasRelacionados;
    int layoutIdForListItem;
    private GetClick getClick;

    public interface GetClick {
        void getIndiceRelArtistas(int id, String urlimg, String name);
    }


    public ArtistasRelacionadosAdapter(GetClick getClick) {
        this.getClick = getClick;
    }


    @Override
    public ArtistasRelacionadosAdapter.ArtistasRelacionadosAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        layoutIdForListItem = R.layout.list_item_artistas_relacionados;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);


        return new ArtistasRelacionadosAdapter.ArtistasRelacionadosAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ArtistasRelacionadosAdapter.ArtistasRelacionadosAdapterViewHolder holder, final int position) {

        final String urlimgrel = resutadolistadeArtistasRelacionados.get(position).getUrl();

        holder.txtnomedoartistarel.setText(resutadolistadeArtistasRelacionados.get(position).getName());
        Glide.with(context)
                .load(Constants.BASE_URL_ARTISTAS + urlimgrel + Constants.IMAGES + Constants.PROFILE_JPG)
                .asBitmap()
                .thumbnail(0.5f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(true)
                .into(holder.imgartistarel);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getClick.getIndiceRelArtistas(position, Constants.BASE_URL_ARTISTAS + urlimgrel + Constants.IMAGES + "profile.jpg", resutadolistadeArtistasRelacionados.get(position).getName());
            }
        });


    }

    @Override
    public int getItemCount() {
        if (resutadolistadeArtistasRelacionados == null) {

            return 0;
        } else {
            return resutadolistadeArtistasRelacionados.size();

        }
    }


    public class ArtistasRelacionadosAdapterViewHolder extends RecyclerView.ViewHolder {
        private TextView txtnomedoartistarel;
        private CircularImageView imgartistarel;
        public View view;

        public ArtistasRelacionadosAdapterViewHolder(View view) {
            super(view);
            this.view = view;
            imgartistarel = (CircularImageView) view.findViewById(R.id.img_related_artista);
            txtnomedoartistarel = (TextView) view.findViewById(R.id.id_nome_artista_relacionado);


        }


    }


    public void setListadeArtistasRelacionados(List<Related> listadeArtistasRelacionados) {
        this.resutadolistadeArtistasRelacionados = listadeArtistasRelacionados;
    }

}
