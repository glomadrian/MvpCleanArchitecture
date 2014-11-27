package com.github.glomadrian.mpvcleanarchitecture.domain.interactor;

import com.github.glomadrian.mpvcleanarchitecture.domain.model.MarvelCharacter;

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
