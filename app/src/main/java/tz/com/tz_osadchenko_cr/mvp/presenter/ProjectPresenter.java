package tz.com.tz_osadchenko_cr.mvp.presenter;

import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindString;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tz.com.tz_osadchenko_cr.R;
import tz.com.tz_osadchenko_cr.engine.network.RetrofitClient;
import tz.com.tz_osadchenko_cr.engine.service.ApiService;

import tz.com.tz_osadchenko_cr.mvp.model.Reply;
import tz.com.tz_osadchenko_cr.mvp.view.ArticleView;

/**
 * Created by artem on 05.03.2018.
 */

public class ProjectPresenter implements ArticlePresenter {

    private ArticleView mView;

    @BindString(R.string.response_failure)
    String mOnFailure;

    public ProjectPresenter(ArticleView view) {

        mView = view;
        mView.showProgressBar();

    }

    @Override
    public void getResponse() {

        ApiService apiService = RetrofitClient.newInstance().create(ApiService.class);
        Call<Reply> call = apiService.getResponseAsJson();
        call.enqueue(new Callback<Reply>() {
            @Override
            public void onResponse(Call<Reply> call, Response<Reply> response) {

                mView.setArticlesData(new ArrayList<>(response.body().getArticles()));
                mView.dismissProgressBar();

            }

            @Override
            public void onFailure(Call<Reply> call, Throwable t) {

                Toast.makeText(mView.getAppContext(), mOnFailure + t.getMessage(), Toast.LENGTH_SHORT)
                        .show();
                mView.dismissProgressBar();

            }
        });

    }

    @Override
    public void onDestroy() {
        mView = null;
    }
}
