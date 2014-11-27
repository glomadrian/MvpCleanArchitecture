package com.github.glomadrian.mpvcleanarchitecture.domain.interactor;

import com.github.glomadrian.mpvcleanarchitecture.domain.model.MarvelCharacter;

import java.util.Collection;

/**
 * Interface for define this interactor
 *
 * @author glomadrian
 */
public interface GetMarvelCharactersLimit {

    void execute(final int limit, final Callback callback);

    interface Callback {

        void onMarvelCharacterList(Collection<MarvelCharacter> marvelCharacters);

        void onError();
    }
}
