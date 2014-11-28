package com.github.glomadrian.mvpcleanarchitecture.domain.repository.api.retrofit;

import com.github.glomadrian.mvpcleanarchitecture.domain.repository.api.model.CharacterDataWrapper;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * @author glomadrian
 */
public interface RetrofitMarvelAPI {

    @GET("/v1/public/characters")
    CharacterDataWrapper getCharacterCollection(@Query("limit") int limit);

    @GET("/v1/public/characters")
    CharacterDataWrapper getCharacterCollection(@Query("limit") int limit, @Query("offset") int offset);
}
