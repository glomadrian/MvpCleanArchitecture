package com.github.glomadrian.mpvcleanarchitecture.ui.presenter;

import com.github.glomadrian.mpvcleanarchitecture.domain.model.MarvelCharacterCollection;
import com.github.glomadrian.mpvcleanarchitecture.ui.view.CharacterCollectionView;

/**
 * @author glomadrian
 */
public interface CharacterCollectionPresenter extends Presenter<CharacterCollectionView> {


    void onLastCharacterViewed();

    MarvelCharacterCollection getParcelableCollection();

    void restoreParcelableCollection(MarvelCharacterCollection marvelCharacters);

    void onCharacterSelected(int position);

}
