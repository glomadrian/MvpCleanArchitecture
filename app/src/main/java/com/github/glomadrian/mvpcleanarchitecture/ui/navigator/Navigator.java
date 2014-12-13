package com.github.glomadrian.mvpcleanarchitecture.ui.navigator;

import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacter;

/**
 * Interface for handle navigation between activities, the implementations of this class will
 * open all new activities with the information necessary to work, the interface allow to change
 * the navigation implementation if is needed (debug, or different compilation flavors)
 *
 * @author glomadrian
 */
public interface Navigator {

    void openCharacterInfoView(MarvelCharacter marvelCharacter);

}
