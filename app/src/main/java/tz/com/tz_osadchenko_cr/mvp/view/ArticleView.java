package tz.com.tz_osadchenko_cr.mvp.view;

import android.content.Context;

import java.util.List;

import tz.com.tz_osadchenko_cr.mvp.model.Article;

/**
 * Created by artem on 05.03.2018.
 */

public interface ArticleView {

    void setArticlesData(List<Article> articleList);

    void showProgressBar();

    void dismissProgressBar();

    Context getAppContext();

}
