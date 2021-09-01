package ocdev.com.br.lyricseditor.Adpters;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ocdev.com.br.lyricseditor.Constants.Constants;
import ocdev.com.br.lyricseditor.Interfaces.ResultadoLetraFavoritos;
import ocdev.com.br.lyricseditor.R;
import ocdev.com.br.lyricseditor.data.FavoriteContract;

/**
 * Created by Oto on 26/04/2018.
 */

public class FavoritosAdapter extends RecyclerView.Adapter<FavoritosAdapter.FavoritosAdapterViewHolder> {

    private Context context;

    private DeleteRestart deleteRestart;
    private Cursor mCursor;
    private ResultadoLetraFavoritos resultadoLetraFavoritos;
    int id;
    String musica, artista, img, idletra, letralang, urlletra, letramus, idart,
            urlart, trid, trlang, trtext, trurl;

    public FavoritosAdapter(Context mContext, ResultadoLetraFavoritos resultadoLetraFavoritos, Activity activity, DeleteRestart deleteRestart) {
        this.context = mContext;
        this.resultadoLetraFavoritos = resultadoLetraFavoritos;
        this.deleteRestart = deleteRestart;
    }




    public interface DeleteRestart {
        void onDelete(boolean deletado);
    }




    @Override
    public FavoritosAdapter.FavoritosAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_item_ranking, parent, false);

        return new FavoritosAdapter.FavoritosAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final FavoritosAdapter.FavoritosAdapterViewHolder holder, final int position) {
//INDEX ARTISTA
        int idIndex = mCursor.getColumnIndex(FavoriteContract.FavoriteEntry._ID);
        int id_art = mCursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_ID_ART);
        int nome_artista = mCursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_NOME_ART);
        int url_art = mCursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_URL_ART);
        int url_img_artista = mCursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_URL_IMG_ART);

//INDEX LETRA
        final int id_letra = mCursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_ID_LETRA);
        int letra_lang = mCursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_LETRA_LANG);
        final int url_letra = mCursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_LETRA_URL);
        int letra_mus = mCursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_LETRA_MUS);
        final int nome_musica = mCursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_NOME_MUS);

//INDEX TRAD
        int tr_id = mCursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_TRANSLATE_ID);
        int tr_lang = mCursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_TRANSLATE_LANG);
        int tr_text = mCursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_TRANSLATE_TEXT);
        int tr_url = mCursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_TRANSLATE_URL);


        mCursor.moveToPosition(position);

        //
        id = mCursor.getInt(idIndex);
        //LETRA
        idletra = mCursor.getString(id_letra);
        letralang = mCursor.getString(letra_lang);
        urlletra = mCursor.getString(url_letra);
        letramus = mCursor.getString(letra_mus);
        musica = mCursor.getString(nome_musica);
//ARTISTA
        idart = mCursor.getString(id_art);
        artista = mCursor.getString(nome_artista);
        img = mCursor.getString(url_img_artista);
        urlart = mCursor.getString(url_art);
//TRAD
        trid = mCursor.getString(tr_id);
        trlang = mCursor.getString(tr_lang);
        trtext = mCursor.getString(tr_text);
        trurl = mCursor.getString(tr_url);


        holder.itemView.setTag(id);
        holder.txtnomemusica.setText(musica);
        holder.txtnomeartista.setText(artista);
        Glide.with(context)
                .load(img)
                .thumbnail(0.5f)
                .into(holder.imgpasso);


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCursor.moveToPosition(position);



                resultadoLetraFavoritos.getResultadoFavoritos(mCursor.getString(id_letra));


            }

        });

        holder.view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
        holder.imgdelete.setVisibility(View.VISIBLE);

        holder.imgdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCursor.moveToPosition(position);
                Uri uri_item = FavoriteContract.FavoriteEntry.CONTENT_URI.buildUpon().appendPath(mCursor.getString(id_letra)).build();
                context.getContentResolver().delete(uri_item, Constants.ID_COLLUMN_CONSULTA_UNICA_LETRA, null);
                deleteRestart.onDelete(true);
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {

        if (mCursor == null) {

            return 0;
        }
        return mCursor.getCount();


    }


    public Cursor swapCursor(Cursor c) {
        if (mCursor == c) {

            return null;
        }
        Cursor temp = mCursor;
        this.mCursor = c;

        if (c != null) {
            this.notifyDataSetChanged();

        }
        return temp;
    }


    public class FavoritosAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final ImageView imgpasso;
        public final TextView txtnomeartista;
        public final TextView txtnomemusica;
        public final ImageView imgdelete;

        public View view;


        public FavoritosAdapterViewHolder(View view) {
            super(view);
            this.view = view;
            imgpasso = (ImageView) view.findViewById(R.id.item_letras_img);
            txtnomeartista = (TextView) view.findViewById(R.id.id_nome_artista);
            txtnomemusica = (TextView) view.findViewById(R.id.id_nome_musica);
            imgdelete = (ImageView) view.findViewById(R.id.delete_letra);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }


    }


}
