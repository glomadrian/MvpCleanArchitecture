package com.github.glomadrian.mvpcleanarchitecture.domain.interactor;

<<<<<<< HEAD
import android.util.Log;

import com.github.glomadrian.mvpcleanarchitecture.domain.LogUtils;
=======
>>>>>>> 546c101c57264276a397087a22e9847094903ffc
import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacter;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.MarvelRepository;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.exception.GetCharactersException;
import com.github.glomadrian.mvpcleanarchitecture.executor.InteractorExecutor;
import com.github.glomadrian.mvpcleanarchitecture.executor.MainThreadExecutor;

<<<<<<< HEAD
=======
import java.util.Collection;
>>>>>>> 546c101c57264276a397087a22e9847094903ffc
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
<<<<<<< HEAD
            Log.e(LogUtils.generateTag(this), "Error on GetMarvelCharactersPaginatedImp interactor");
=======
>>>>>>> 546c101c57264276a397087a22e9847094903ffc
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
