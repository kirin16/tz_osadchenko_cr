package tz.com.tz_osadchenko_cr.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.List;

import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import tz.com.tz_osadchenko_cr.R;
import tz.com.tz_osadchenko_cr.engine.adapter.ArticlesAdapter;
import tz.com.tz_osadchenko_cr.mvp.model.Article;
import tz.com.tz_osadchenko_cr.mvp.presenter.ArticlePresenter;
import tz.com.tz_osadchenko_cr.mvp.presenter.ProjectPresenter;
import tz.com.tz_osadchenko_cr.mvp.view.ArticleView;

/**
 * Created by artem on 05.03.2018.
 */

public class MainActivity extends AppCompatActivity implements ArticleView{

    private ProgressDialog mProgressDialog;
    private ArticlesAdapter mArticleAdapter;
    private ArticlePresenter mPresenter;

    @BindString(R.string.dialog_title)
    String dialogTitle;

    @BindView(R.id.rvArticlesList)
    RecyclerView mRecyclerView;

    @BindDrawable(R.drawable.divider)
    Drawable dividerXml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle(dialogTitle);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration divider = new DividerItemDecoration(getAppContext(),
                DividerItemDecoration.VERTICAL);
        divider.setDrawable(dividerXml);
        mRecyclerView.addItemDecoration(divider);

        mPresenter = new ProjectPresenter(this);
        mPresenter.getResponse();

    }

    @Override
    public void setArticlesData(List<Article> articleList) {

        mArticleAdapter = new ArticlesAdapter(articleList,this);
        mRecyclerView.setAdapter(mArticleAdapter);

    }

    @Override
    public void showProgressBar() {

        mProgressDialog.show();

    }

    @Override
    public void dismissProgressBar() {

        mProgressDialog.dismiss();

    }

    @Override
    public Context getAppContext() {

        return getApplicationContext();

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        mPresenter.onDestroy();

    }
}
