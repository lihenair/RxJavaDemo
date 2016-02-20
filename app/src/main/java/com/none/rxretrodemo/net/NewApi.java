package com.none.rxretrodemo.net;

import com.none.rxretrodemo.model.NewsList;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * 功能：
 *
 * @author liwei
 * @version 1.0
 * @since 2016/1/27.
 */
public interface NewApi {
    @GET("{type}/other")
    Observable<NewsList> loadnews(@Path("type") String type,
                                        @Query("key") String key,
                                        @Query("num") String num);
}
