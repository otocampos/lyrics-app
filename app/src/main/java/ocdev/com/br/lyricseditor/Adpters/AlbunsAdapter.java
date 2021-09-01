package ocdev.com.br.lyricseditor.Adpters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import ocdev.com.br.lyricseditor.Constants.Constants;
import ocdev.com.br.lyricseditor.Model.RankingMusica.Artista.ItemAlbums;
import ocdev.com.br.lyricseditor.R;

/**
 * Created by Oto on 03/04/2018.
 */
public class AlbunsAdapter extends RecyclerView.Adapter<AlbunsAdapter.AlbunsAdapterViewHolder> {
    private Context context;
    private List<ItemAlbums> resutadolistadealbuns;
    int layoutIdForListItem;


    public AlbunsAdapter() {
    }


    @Override
    public AlbunsAdapter.AlbunsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        layoutIdForListItem = R.layout.list_item_album;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);


        return new AlbunsAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(AlbunsAdapterViewHolder holder, int position) {


        holder.txtnomedoalbum.setText(resutadolistadealbuns.get(position).getDesc());
        holder.txtanodoalbum.setText(resutadolistadealbuns.get(position).getYear());
        Glide.with(context)
                .load(Constants.BASE_URLS2 + resutadolistadealbuns.get(position).getUrl().replace(".html", ".png"))
                .asBitmap()
                .thumbnail(0.5f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(true)
                .into(holder.imgcapadoalbum);


    }

    @Override
    public int getItemCount() {
        return resutadolistadealbuns.size();
    }


    public class AlbunsAdapterViewHolder extends RecyclerView.ViewHolder {
        private TextView txtnomedoalbum;
        private TextView txtanodoalbum;
        private ImageView imgcapadoalbum;
        public View view;

        public AlbunsAdapterViewHolder(View view) {
            super(view);
            this.view = view;

            txtanodoalbum = (TextView) view.findViewById(R.id.id_ano_album);
            txtnomedoalbum = (TextView) view.findViewById(R.id.id_nome_album);
            imgcapadoalbum = (ImageView) view.findViewById(R.id.capa_album);


        }


    }

    public void setListadeAlbuns(List<ItemAlbums> listadeAlbuns) {
        this.resutadolistadealbuns = listadeAlbuns;
    }

}
