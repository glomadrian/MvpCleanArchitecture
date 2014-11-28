package com.github.glomadrian.mvpcleanarchitecture.ui.reactive;

import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacter;

import java.util.ArrayList;
import java.util.List;

/**
 * Observable to character selected, this observable call all observer subscribed when a
 * character is selected
 *
 * @author glomadrian
 */
public class CharacterSelectedObservable implements Observable<CharacterSelectedObserver> {

    List<CharacterSelectedObserver> characterSelectedObservers;

    public CharacterSelectedObservable() {
        characterSelectedObservers = new ArrayList<CharacterSelectedObserver>();
    }


    @Override
    public void register(CharacterSelectedObserver observer) {
        //To avoid duplicated register
        if (!characterSelectedObservers.contains(observer)) {
            characterSelectedObservers.add(observer);
        }
    }

    @Override
    public void unregister(CharacterSelectedObserver observer) {
        characterSelectedObservers.remove(observer);
    }


    public void notifyObservers(MarvelCharacter marvelCharacter) {
        for (CharacterSelectedObserver characterSelectedObserver : characterSelectedObservers) {
            characterSelectedObserver.characterSelected(marvelCharacter);
        }
    }
}
