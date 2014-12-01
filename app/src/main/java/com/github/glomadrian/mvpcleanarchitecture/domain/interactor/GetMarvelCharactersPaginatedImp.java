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
 * @author glomadrian
 */
public class GetMarvelCharactersPaginatedImp extends AbstractInteractor implements GetMarvelCharactersPaginated {

    private MarvelRepository marvelRepository;
    private Callback callback;
    private int limit;
    private int offset;

    public GetMarvelCharactersPaginatedImp(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor, MarvelRepository marvelRepository) {
        super(interactorExecutor, mainThreadExecutor);
        this.marvelRepository = marvelRepository;
    }


    @Override
    public void run() {
        try {
            final List<MarvelCharacter> marvelCharacters = marvelRepository.getCharacterCollectionPaginated(limit, offset);

            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    callback.onMarvelCharacterList(marvelCharacters);
                }
            });
        } catch (GetCharactersException e) {
            Log.e(LogUtils.generateTag(this), "Error on GetMarvelCharactersPaginatedImp interactor");
            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    callback.onError();
                }
            });
        }
    }

    @Override
    public void execute(int limit, int offset, Callback callback) {
        this.limit = limit;
        this.offset = offset;
        this.callback = callback;
        getInteractorExecutor().run(this);
    }
}
