package com.github.glomadrian.mvpcleanarchitecture.ui.reactive;

import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacter;

/**
 * @author glomadrian
 */
public interface CharacterSelectedObserver {

    void characterSelected(MarvelCharacter marvelCharacter);
}
