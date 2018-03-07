package tz.com.tz_osadchenko_cr.engine.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tz.com.tz_osadchenko_cr.engine.common.Constants;

/**
 * Created by artem on 06.03.2018.
 */

public class RetrofitClient {

    public static Retrofit newInstance(){

        return new Retrofit.Builder()
                .baseUrl(Constants.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

}
