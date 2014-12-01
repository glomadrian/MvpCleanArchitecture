package com.github.glomadrian.mvpcleanarchitecture.domain.interactor;

import android.util.Log;

import com.github.glomadrian.mvpcleanarchitecture.domain.LogUtils;
import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacter;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.MarvelRepository;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.exception.GetCharactersException;
import com.github.glomadrian.mvpcleanarchitecture.executor.InteractorExecutor;
import com.github.glomadrian.mvpcleanarchitecture.executor.MainThreadExecutor;

import java.util.List;

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
            final List<MarvelCharacter> marvelCharacters = marvelRepository.getCharacterCollection(limit);

            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    callback.onMarvelCharacterList(marvelCharacters);
                }
            });

        } catch (GetCharactersException e) {
            Log.e(LogUtils.generateTag(this), "Error on GerMarvelCharacters interactor");
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
