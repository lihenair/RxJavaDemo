package com.none.rxretrodemo.app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.none.rxretrodemo.R;
import com.none.rxretrodemo.model.NewsModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 *
 * @author liwei
 * @version 1.0
 * @since 2016/2/1.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    Context context;
    List<NewsModel> models;

    public NewsAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<NewsModel> models) {
        this.models = models;
        notifyDataSetChanged();
    }


    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NewsViewHolder holder = new NewsViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.newsitem, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        NewsModel model = models.get(position);
        holder.title.setText(model.getTitle());
        holder.desc.setText(model.getDesc());
        Picasso.with(context).load(model.getPicUrl())
                .error(R.mipmap.ic_launcher)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        if (models == null) {
            return 0;
        }
        return models.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.news_title)
        TextView title;
        @Bind(R.id.news_desc)
        TextView desc;
        @Bind(R.id.news_img)
        ImageView image;

        public NewsViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
