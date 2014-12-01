package com.github.glomadrian.mvpcleanarchitecture.ui.presenter;

import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacterList;
import com.github.glomadrian.mvpcleanarchitecture.ui.view.CharacterListView;


/**
 * @author glomadrian
 */
public interface CharacterListPresenter extends Presenter<CharacterListView> {


    void onLastCharacterViewed();

    MarvelCharacterList getParcelableCollection();

    void restoreParcelableCollection(MarvelCharacterList marvelCharacters);

    void onCharacterSelected(int position);

}
