package com.github.glomadrian.mpvcleanarchitecture.domain.repository.api.retrofit;

import com.github.glomadrian.mpvcleanarchitecture.domain.model.MarvelCharacter;
import com.github.glomadrian.mpvcleanarchitecture.domain.repository.MarvelRepository;
import com.github.glomadrian.mpvcleanarchitecture.domain.repository.ResponseMapper;
import com.github.glomadrian.mpvcleanarchitecture.domain.repository.api.model.CharacterDataWrapper;
import com.github.glomadrian.mpvcleanarchitecture.domain.repository.exception.GetCharactersException;

import java.util.Collection;

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
    private RetrofitMarvelAPI marvelAPI;
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

        marvelAPI = restAdapter.create(RetrofitMarvelAPI.class);

    }

    @Override
    public Collection<MarvelCharacter> getCharacterCollection(int limit) throws GetCharactersException {
        //The request using retrofit

        try {
            CharacterDataWrapper characterDataWrapper = marvelAPI.getCharacterCollection(limit);
            //Map response from api to domain model
            return responseMapper.mapResponse(characterDataWrapper);
        } catch (RetrofitError retrofitError) {
            GetCharactersException getCharactersException = new GetCharactersException();
            getCharactersException.setStackTrace(retrofitError.getStackTrace());
            throw getCharactersException;
        }


    }

    @Override
    public Collection<MarvelCharacter> getCharacterCollectionPaginated(int limit, int offset) throws GetCharactersException {
        try {
            CharacterDataWrapper characterDataWrapper = marvelAPI.getCharacterCollection(limit, offset);
            //Map response from api to domain model
            return responseMapper.mapResponse(characterDataWrapper);
        } catch (RetrofitError retrofitError) {
            GetCharactersException getCharactersException = new GetCharactersException();
            getCharactersException.setStackTrace(retrofitError.getStackTrace());
            throw getCharactersException;
        }
    }
}
