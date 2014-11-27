package com.github.glomadrian.mpvcleanarchitecture.domain.interactor;

import com.github.glomadrian.mpvcleanarchitecture.domain.model.MarvelCharacter;
import com.github.glomadrian.mpvcleanarchitecture.domain.repository.MarvelRepository;
import com.github.glomadrian.mpvcleanarchitecture.domain.repository.exception.GetCharactersException;
import com.github.glomadrian.mpvcleanarchitecture.executor.InteractorExecutor;
import com.github.glomadrian.mpvcleanarchitecture.executor.MainThreadExecutor;

import java.util.Collection;

/**
 * This implementation of the interactor (case use) will use a repository (injected) to get a collection
 * of marvel characters
 *
 * @author glomadrian
 */
public class GetMarvelCharactersLimitImp extends AbstractInteractor implements GetMarvelCharactersLimit {

    private MarvelRepository marvelRepository;
    private Callback callback;
    private int limit;

    public GetMarvelCharactersLimitImp(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor, MarvelRepository marvelRepository) {
        super(interactorExecutor, mainThreadExecutor);
        this.marvelRepository = marvelRepository;
    }


    @Override
    public void run() {

        try {
            final Collection<MarvelCharacter> marvelCharacters = marvelRepository.getCharacterCollection(limit);

            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    callback.onMarvelCharacterList(marvelCharacters);
                }
            });

        } catch (GetCharactersException e) {
            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    callback.onError();
                }
            });
        }

    }

    @Override
    public void execute(int limit, Callback callback) {
        this.callback = callback;
        this.limit = limit;

        getInteractorExecutor().run(this);
    }

}
