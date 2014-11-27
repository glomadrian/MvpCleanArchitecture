package com.github.glomadrian.mpvcleanarchitecture.ui.presenter;

import com.github.glomadrian.mpvcleanarchitecture.domain.model.MarvelCharacter;
import com.github.glomadrian.mpvcleanarchitecture.ui.view.ModelInfoView;

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
