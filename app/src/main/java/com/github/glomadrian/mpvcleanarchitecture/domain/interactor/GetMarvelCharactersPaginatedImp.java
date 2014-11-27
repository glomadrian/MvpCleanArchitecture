package com.github.glomadrian.mpvcleanarchitecture.domain.interactor;

import com.github.glomadrian.mpvcleanarchitecture.domain.model.MarvelCharacter;
import com.github.glomadrian.mpvcleanarchitecture.domain.repository.MarvelRepository;
import com.github.glomadrian.mpvcleanarchitecture.domain.repository.exception.GetCharactersException;
import com.github.glomadrian.mpvcleanarchitecture.executor.InteractorExecutor;
import com.github.glomadrian.mpvcleanarchitecture.executor.MainThreadExecutor;

import java.util.Collection;

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
            final Collection<MarvelCharacter> marvelCharacters = marvelRepository.getCharacterCollectionPaginated(limit, offset);

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
    public void execute(int limit, int offset, Callback callback) {
        this.limit = limit;
        this.offset = offset;
        this.callback = callback;
        getInteractorExecutor().run(this);
    }
}
