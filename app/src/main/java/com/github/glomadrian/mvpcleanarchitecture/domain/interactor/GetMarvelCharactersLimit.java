package com.github.glomadrian.mvpcleanarchitecture.domain.interactor;

import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacter;

import java.util.List;

/**
 * Interface for define this interactor
 *
 * @author glomadrian
 */
public interface GetMarvelCharactersLimit {

    void execute(final int limit, final Callback callback);

    interface Callback {

        void onMarvelCharacterList(List<MarvelCharacter> marvelCharacters);

        void onError();
    }
}
