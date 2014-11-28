package com.github.glomadrian.mvpcleanarchitecture.ui.presenter;

import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacter;
import com.github.glomadrian.mvpcleanarchitecture.ui.view.ModelInfoView;

/**
 * @author glomadrian
 */
public interface CharacterInfoPresenter extends Presenter<ModelInfoView> {

    /**
     * When the view is created it will recibe a marvel character into the bundle, then
     * call the presenter
     *
     * @param marvelCharacter
     */
    void onCharacter(MarvelCharacter marvelCharacter);

}
