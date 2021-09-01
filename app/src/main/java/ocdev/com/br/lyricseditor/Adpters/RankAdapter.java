package ocdev.com.br.lyricseditor.Adpters;

import android.app.Activity;
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
import ocdev.com.br.lyricseditor.Model.RankingMusica.Result;
import ocdev.com.br.lyricseditor.R;

/**
 * Created by Oto on 02/03/2018.
 */

public class RankAdapter extends RecyclerView.Adapter<RankAdapter.RankAdapterViewHolder> {

    private Context context;
    private List<Result> RankingData;
    private int categoriaexibida;
    private RankAdapteronClickHandler mOnclickHandler;


    public RankAdapter(RankAdapteronClickHandler mOnclickHandler, Context mContext, Activity activity) {
        this.mOnclickHandler = mOnclickHandler;
        this.context = mContext;
    }


    public interface RankAdapteronClickHandler {
        void onClick(int indice);

        void onLongClcick(int indice);
    }

    public RankAdapter() {
    }

    public void setRankingData(List<Result> rankingData) {
        RankingData = rankingData;
    }

    public void setCategoriaexibida(int categoriaexibida) {
        this.categoriaexibida = categoriaexibida;
    }


    @Override
    public RankAdapter.RankAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_item_ranking, parent, false);

        return new RankAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final RankAdapterViewHolder holder, final int position) {
        Result result = RankingData.get(categoriaexibida);

        if (categoriaexibida == Constants.RANKING_LISTA_INDEX_MUSICAS_LYRICS) {
            Glide.with(context)
                    .load(result.getMus().getWeek().getLyrics().get(position).getArt().getPicMedium())
                    .thumbnail(0.5f)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .skipMemoryCache(true)
                    .into(holder.imgpasso);
            holder.txtnomeartista.setText(result.getMus().getWeek().getLyrics().get(position).getArt().getName());
            holder.txtnomemusica.setText(result.getMus().getWeek().getLyrics().get(position).getName());
        }
        if (categoriaexibida == Constants.RANKING_LISTA_INDEX_MUSICAS_TRADUCOES) {
            Glide.with(context)
                    .load(result.getMus().getWeek().getTranslations().get(position).getArt().getPicMedium())
                    .thumbnail(0.5f)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .skipMemoryCache(true)
                    .into(holder.imgpasso);
            holder.txtnomeartista.setText(result.getMus().getWeek().getTranslations().get(position).getArt().getName());
            holder.txtnomemusica.setText(result.getMus().getWeek().getTranslations().get(position).getName());

        }

        if (categoriaexibida == Constants.RANKING_LISTA_INDEX_ARTISTAS_NACIONAL) {
            Glide.with(context)
                    .load(result.getArt().getWeek().getNacional().get(position).getPicMedium())
                    .thumbnail(0.5f)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .skipMemoryCache(true)
                    .into(holder.imgpasso);
            holder.txtnomeartista.setText(result.getArt().getWeek().getNacional().get(position).getName());
            holder.txtnomemusica.setText("");
        }

        if (categoriaexibida == Constants.RANKING_LISTA_INDEX_ARTISTAS_INTERNACIONAL) {
            Glide.with(context)
                    .load(result.getArt().getWeek().getInternacional().get(position).getPicMedium())
                    .thumbnail(0.5f)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .skipMemoryCache(true)
                    .into(holder.imgpasso);
            holder.txtnomeartista.setText(result.getArt().getWeek().getInternacional().get(position).getName());
            holder.txtnomemusica.setText("");
        }


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnclickHandler.onClick(position);
            }
        });

        holder.view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mOnclickHandler.onLongClcick(position);
                return false;
            }
        });
    }


    @Override
    public int getItemCount() {
        if (null == RankingData) return 0;
        if (categoriaexibida == Constants.RANKING_LISTA_INDEX_MUSICAS_LYRICS) {

            return RankingData.get(Constants.RANKING_LISTA_INDEX_MUSICAS_LYRICS).getMus().getWeek().getLyrics().size();

        }
        if (categoriaexibida == Constants.RANKING_LISTA_INDEX_MUSICAS_TRADUCOES) {
            return RankingData.get(Constants.RANKING_LISTA_INDEX_MUSICAS_TRADUCOES).getMus().getWeek().getTranslations().size();
        }
        if (categoriaexibida == Constants.RANKING_LISTA_INDEX_ARTISTAS_NACIONAL) {
            return RankingData.get(Constants.RANKING_LISTA_INDEX_ARTISTAS_NACIONAL).getArt().getWeek().getNacional().size();
        }
        if (categoriaexibida == Constants.RANKING_LISTA_INDEX_ARTISTAS_INTERNACIONAL) {
            return RankingData.get(Constants.RANKING_LISTA_INDEX_ARTISTAS_INTERNACIONAL).getArt().getWeek().getInternacional().size();
        }


        return Constants.QNT_RANK;
    }


    public class RankAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final ImageView imgpasso;
        public final TextView txtnomeartista;
        public final TextView txtnomemusica;

        public View view;


        public RankAdapterViewHolder(View view) {
            super(view);
            this.view = view;
            imgpasso = (ImageView) view.findViewById(R.id.item_letras_img);
            txtnomeartista = (TextView) view.findViewById(R.id.id_nome_artista);
            txtnomemusica = (TextView) view.findViewById(R.id.id_nome_musica);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {


        }


    }

}
