package com.github.glomadrian.mvpcleanarchitecture.ui.presenter;

import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacterCollection;
import com.github.glomadrian.mvpcleanarchitecture.ui.view.CharacterCollectionView;

/**
 * @author glomadrian
 */
public interface CharacterCollectionPresenter extends Presenter<CharacterCollectionView> {


    void onLastCharacterViewed();

    MarvelCharacterCollection getParcelableCollection();

    void restoreParcelableCollection(MarvelCharacterCollection marvelCharacters);

    void onCharacterSelected(int position);

}
