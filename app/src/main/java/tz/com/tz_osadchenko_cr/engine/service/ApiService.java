package tz.com.tz_osadchenko_cr.engine.service;


import retrofit2.Call;
import retrofit2.http.GET;
import tz.com.tz_osadchenko_cr.engine.common.Constants;
import tz.com.tz_osadchenko_cr.mvp.model.Reply;

/**
 * Created by artem on 05.03.2018.
 */

public interface ApiService {
    @GET(Constants.GET_ARTICLES)
    Call<Reply> getResponseAsJson();
}
