package com.none.rxretrodemo.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.none.rxretrodemo.BuildConfig;
import com.none.rxretrodemo.R;
import com.none.rxretrodemo.data.Const;
import com.none.rxretrodemo.net.NewService;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 功能：
 *
 * @author liwei
 * @version 1.0
 * @since 2016/1/27.
 */
public class NewsFragment extends Fragment {

    private static final String TPEY_ARGS_KEY = "TYPE_KEY";

    @Bind(R.id.newslist)
    RecyclerView recyclerView;
    private NewsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_news, container, false);
        ButterKnife.bind(this, root);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter = new NewsAdapter(getActivity()));

        NewService service = new NewService();
        service.getNewsApi().loadnews(Const.MEINV, BuildConfig.KEY, "20")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(news -> adapter.setData(news.newslist));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public static NewsFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt(TPEY_ARGS_KEY, type);
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
