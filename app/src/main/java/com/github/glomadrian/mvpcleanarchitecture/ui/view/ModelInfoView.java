package com.github.glomadrian.mvpcleanarchitecture.ui.view;

import com.github.glomadrian.mvpcleanarchitecture.ui.viewModel.CharacterInfoViewModel;

/**
 * @author glomadrian
 */
public interface ModelInfoView extends View {

    void showCharacterInfo(CharacterInfoViewModel characterInfoViewModel);
}
