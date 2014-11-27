package com.github.glomadrian.mpvcleanarchitecture.ui.reactive;

import com.github.glomadrian.mpvcleanarchitecture.domain.model.MarvelCharacter;

/**
 * @author glomadrian
 */
public interface CharacterSelectedObserver {

    void characterSelected(MarvelCharacter marvelCharacter);
}
