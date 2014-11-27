package com.github.glomadrian.mpvcleanarchitecture.app.dependencyInjection;

import com.github.glomadrian.mpvcleanarchitecture.domain.interactor.GetMarvelCharactersLimit;
import com.github.glomadrian.mpvcleanarchitecture.domain.interactor.GetMarvelCharactersLimitImp;
import com.github.glomadrian.mpvcleanarchitecture.domain.interactor.GetMarvelCharactersPaginated;
import com.github.glomadrian.mpvcleanarchitecture.domain.interactor.GetMarvelCharactersPaginatedImp;
import com.github.glomadrian.mpvcleanarchitecture.domain.repository.MarvelRepository;
import com.github.glomadrian.mpvcleanarchitecture.executor.InteractorExecutor;
import com.github.glomadrian.mpvcleanarchitecture.executor.MainThreadExecutor;

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
    public GetMarvelCharactersLimit provideGetMarvelCharactersLimit(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor, MarvelRepository marvelRepository) {
        return new GetMarvelCharactersLimitImp(interactorExecutor, mainThreadExecutor, marvelRepository);
    }

    @Provides
    public GetMarvelCharactersPaginated provideGetMarvelCharactersPaginated(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor, MarvelRepository marvelRepository) {
        return new GetMarvelCharactersPaginatedImp(interactorExecutor, mainThreadExecutor, marvelRepository);
    }
}
