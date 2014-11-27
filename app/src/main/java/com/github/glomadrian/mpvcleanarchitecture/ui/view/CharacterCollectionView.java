package com.github.glomadrian.mpvcleanarchitecture.ui.view;

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
