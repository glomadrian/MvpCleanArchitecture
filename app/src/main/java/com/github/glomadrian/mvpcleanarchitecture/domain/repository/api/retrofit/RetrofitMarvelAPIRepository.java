package com.github.glomadrian.mvpcleanarchitecture.domain.repository.api.retrofit;

import android.util.Log;

import com.github.glomadrian.mvpcleanarchitecture.domain.LogUtils;
import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacter;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.MarvelRepository;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.ResponseMapper;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.api.model.CharacterDataWrapper;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.exception.GetCharactersException;

import java.util.List;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Implementation of MarvelRepository using Retrofit as client, every call is synchronous
 * because the asynchronous is done by the concrete interactor (use case) for this repository
 *
 * @author glomadrian
 */
public class RetrofitMarvelAPIRepository implements MarvelRepository {

    private String endpoint;
    private RequestInterceptor requestInterceptor;
    private RetrofitMarvelService marvelAPI;
    private ResponseMapper responseMapper;

    public RetrofitMarvelAPIRepository(String endpoint, RequestInterceptor requestInterceptor, ResponseMapper responseMapper) {
        this.endpoint = endpoint;
        this.requestInterceptor = requestInterceptor;
        this.responseMapper = responseMapper;

        init();
    }

    private void init() {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .setRequestInterceptor(requestInterceptor)
                .build();

        marvelAPI = restAdapter.create(RetrofitMarvelService.class);

    }

    @Override
    public List<MarvelCharacter> getCharacterCollection(int limit) throws GetCharactersException {
        //The request using retrofit

        try {
            CharacterDataWrapper characterDataWrapper = marvelAPI.getCharacters(limit);
            //Map response from api to domain model
            return responseMapper.mapResponse(characterDataWrapper);
        } catch (RetrofitError retrofitError) {
            Log.e(LogUtils.generateTag(this), "Error on marvel api repository");
            GetCharactersException getCharactersException = new GetCharactersException();
            getCharactersException.setStackTrace(retrofitError.getStackTrace());
            throw getCharactersException;
        }


    }

    @Override
    public List<MarvelCharacter> getCharacterCollectionPaginated(int limit, int offset) throws GetCharactersException {
        try {
            CharacterDataWrapper characterDataWrapper = marvelAPI.getCharacters(limit, offset);
            //Map response from api to domain model
            return responseMapper.mapResponse(characterDataWrapper);
        } catch (RetrofitError retrofitError) {
            Log.e(LogUtils.generateTag(this), "Error on marvel api repository");
            GetCharactersException getCharactersException = new GetCharactersException();
            getCharactersException.setStackTrace(retrofitError.getStackTrace());
            throw getCharactersException;
        }
    }
}
