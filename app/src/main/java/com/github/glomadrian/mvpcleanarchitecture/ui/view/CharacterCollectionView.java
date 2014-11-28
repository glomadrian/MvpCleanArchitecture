package com.github.glomadrian.mvpcleanarchitecture.ui.view;

/**
 * @author glomadrian
 */
public interface CharacterCollectionView extends ModelCollectionView {

    int getModelsRenderer();

    void showLoading();

    void hideLoading();

    void activateLastCharacterViewListener();

    void disableLastCharacterViewListener();

}
