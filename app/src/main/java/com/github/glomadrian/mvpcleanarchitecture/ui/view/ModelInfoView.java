package com.github.glomadrian.mvpcleanarchitecture.ui.view;

import com.github.glomadrian.mvpcleanarchitecture.ui.viewmodel.CharacterInfoViewModel;

/**
 * @author glomadrian
 */
public interface ModelInfoView extends View {

    void showCharacterInfo(CharacterInfoViewModel characterInfoViewModel);
}
