package com.none.rxretrodemo.net;

import com.none.rxretrodemo.BuildConfig;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * 功能：
 *
 * @author liwei
 * @version 1.0
 * @since 2016/1/27.
 */
public class NewService {

    public NewApi getNewsApi() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient();
        httpClient.interceptors().add(logging);
        httpClient.interceptors().add(interceptor);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BuildConfig.BASE_COMMON_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
        return retrofit.create(NewApi.class);
    }

    private Interceptor interceptor = chain -> {
        Request request = chain.request();
        com.squareup.okhttp.Response response = chain.proceed(request);
        int maxAge = 60 * 60;
        response.newBuilder()
                .removeHeader("Pragma")
                .header("Cache-Control", "public, max-age=" + maxAge)
                .build();
        return response;
    };
}
