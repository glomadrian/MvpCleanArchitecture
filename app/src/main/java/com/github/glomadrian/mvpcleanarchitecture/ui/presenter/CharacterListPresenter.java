package com.github.glomadrian.mvpcleanarchitecture.ui.presenter;

import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacterList;
import com.github.glomadrian.mvpcleanarchitecture.ui.view.CharacterListView;
<<<<<<< HEAD
=======
import com.github.glomadrian.mvpcleanarchitecture.ui.view.CharacterListView;
>>>>>>> 546c101c57264276a397087a22e9847094903ffc

/**
 * @author glomadrian
 */
public interface CharacterListPresenter extends Presenter<CharacterListView> {


    void onLastCharacterViewed();

    MarvelCharacterList getParcelableCollection();

    void restoreParcelableCollection(MarvelCharacterList marvelCharacters);

    void onCharacterSelected(int position);

}
