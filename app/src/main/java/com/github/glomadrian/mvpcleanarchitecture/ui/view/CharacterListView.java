package com.github.glomadrian.mvpcleanarchitecture.ui.view;

/**
 * @author glomadrian
 */
public interface CharacterListView extends ModelListView {

    int getModelsRenderer();

    void showLoading();

    void hideLoading();

    void activateLastCharacterViewListener();

    void disableLastCharacterViewListener();

    void onError();

}
