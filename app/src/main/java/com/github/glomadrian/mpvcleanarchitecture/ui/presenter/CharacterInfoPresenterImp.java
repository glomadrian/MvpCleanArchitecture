package com.github.glomadrian.mpvcleanarchitecture.ui.presenter;

import com.github.glomadrian.mpvcleanarchitecture.domain.model.MarvelCharacter;
import com.github.glomadrian.mpvcleanarchitecture.ui.view.ModelInfoView;
import com.github.glomadrian.mpvcleanarchitecture.ui.viewModel.CharacterInfoViewModel;

/**
 * @author glomadrian
 */
public class CharacterInfoPresenterImp implements CharacterInfoPresenter {

    ModelInfoView modelInfoView;


    @Override
    public void initialize() {
        //Do nothing
    }

    @Override
    public void onViewCreate() {
        //Do nothing
    }

    @Override
    public void onViewResume() {
        //Do nothing
    }

    @Override
    public void onViewDestroy() {
        //Do nothing
    }

    @Override
    public void setView(ModelInfoView view) {
        this.modelInfoView = view;
    }

    @Override
    public void onCharacter(MarvelCharacter marvelCharacter) {
        //Parse the character to characterInfoModelView and call the view to show
        CharacterInfoViewModel characterInfoViewModel = new CharacterInfoViewModel(marvelCharacter);
        modelInfoView.showCharacterInfo(characterInfoViewModel);
    }
}
