package com.github.glomadrian.mvpcleanarchitecture.app.dependencyinjection;

import com.github.glomadrian.mvpcleanarchitecture.domain.interactor.GetMarvelCharactersLimit;
import com.github.glomadrian.mvpcleanarchitecture.domain.interactor.GetMarvelCharactersLimitImp;
import com.github.glomadrian.mvpcleanarchitecture.domain.interactor.GetMarvelCharactersPaginated;
import com.github.glomadrian.mvpcleanarchitecture.domain.interactor.GetMarvelCharactersPaginatedImp;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.MarvelRepository;
import com.github.glomadrian.mvpcleanarchitecture.executor.InteractorExecutor;
import com.github.glomadrian.mvpcleanarchitecture.executor.MainThreadExecutor;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @author glomadrian
 */
@Module(
        complete = false,
        library = true
)
public class InteractorModule {


    @Provides
    public GetMarvelCharactersLimit provideGetMarvelCharactersLimit(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor, @Named("mock_api") MarvelRepository marvelRepository) {
        return new GetMarvelCharactersLimitImp(interactorExecutor, mainThreadExecutor, marvelRepository);
    }

    @Provides
    public GetMarvelCharactersPaginated provideGetMarvelCharactersPaginated(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor, @Named("mock_api") MarvelRepository marvelRepository) {
        return new GetMarvelCharactersPaginatedImp(interactorExecutor, mainThreadExecutor, marvelRepository);
    }
}
