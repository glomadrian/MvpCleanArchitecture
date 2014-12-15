package com.github.glomadrian.mvpcleanarchitecture.app.dependencyinjection;

import com.github.glomadrian.mvpcleanarchitecture.domain.repository.MarvelRepository;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.ResponseMapper;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.api.mapper.MarvelApiResponseMapper;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.api.retrofit.RetrofitMarvelAPIRepository;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.api.retrofit.interceptor.MarvelRequestInterceptor;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.mock.MarvelMockRepository;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;

/**
 * @author glomadrian
 */
@Module(
        complete = false,
        library = true
)
public class RepositoryModule {


    @Provides
    @Named("api_public_key")
    public String provideApiKey() {
        return "fakePublicKey";
    }

    @Provides
    @Named("api_private_key")
    public String providePrivateKey() {
        return "fakePrivateKey";
    }

    @Provides
    @Named("api_base_url")
    public String provideApiBaseUrl() {
        return "http://gateway.marvel.com";
    }


    @Provides
    public RequestInterceptor provideRequestInterceptor(@Named("api_public_key") String publicKey,
                                                        @Named("api_private_key") String privateKey) {
        return new MarvelRequestInterceptor(publicKey, privateKey);

    }

    @Provides
    public ResponseMapper provideResponseMapper() {
        return new MarvelApiResponseMapper();
    }

    @Provides
    @Named("production_api")
    public MarvelRepository provideMarvelRepository(RequestInterceptor requestInterceptor, ResponseMapper responseMapper, @Named("api_base_url") String endpoint) {
        return new RetrofitMarvelAPIRepository(endpoint, requestInterceptor, responseMapper);
    }

    @Provides
    @Named("mock_api")
    public MarvelRepository provideMarvelRepository() {
        return new MarvelMockRepository();
    }
}
