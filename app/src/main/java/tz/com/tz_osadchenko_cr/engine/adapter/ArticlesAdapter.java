package tz.com.tz_osadchenko_cr.engine.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import tz.com.tz_osadchenko_cr.R;
import tz.com.tz_osadchenko_cr.mvp.model.Article;

/**
 * Created by artem on 05.03.2018.
 */

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticleItemViewHolder> {

    private List<Article> articleList;
    private Context context;

    public ArticlesAdapter(List<Article> articleList, Context context) {

        this.articleList = articleList;
        this.context = context;
    }

    @Override
    public ArticleItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_item, parent, false);
        return new ArticleItemViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ArticlesAdapter.ArticleItemViewHolder holder, int position) {

        holder.author.setText(holder.nullCheck(articleList.get(position).getAuthor()));
        holder.title.setText(holder.nullCheck(articleList.get(position).getTitle()));
        holder.url.setText(holder.nullCheck(articleList.get(position).getUrl()));
        holder.description.setText(holder.nullCheck(articleList.get(position).getDescription()));
        holder.published.setText(holder.nullCheck(articleList.get(position).getPublishedAt()));
        Picasso.with(context).load(articleList.get(position).getUrlToImage()).into(holder.img);

    }

    @Override
    public int getItemCount() {

        return articleList.size();

    }

    class ArticleItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvAuthor) 
        TextView author;
        @BindView(R.id.tvTitle)
        TextView title;
        @BindView(R.id.tvUrl)
        TextView url;
        @BindView(R.id.tvDescription)
        TextView description;
        @BindView(R.id.tvPublished)
        TextView published;
        
        @BindView(R.id.ivImg)
        ImageView img;

        ArticleItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        String nullCheck(String str){
            return str = (str == null || str.equals("")) ? "" : str;
        }

    }

}
