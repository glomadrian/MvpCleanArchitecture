package com.github.glomadrian.mvpcleanarchitecture.domain.interactor;

import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacter;

import java.util.Collection;

/**
 * @author glomadrian
 */
public interface GetMarvelCharactersPaginated {

    void execute(final int limit, final int offset, final Callback callback);

    interface Callback {

        void onMarvelCharacterList(Collection<MarvelCharacter> marvelCharacters);

        void onError();
    }
}
