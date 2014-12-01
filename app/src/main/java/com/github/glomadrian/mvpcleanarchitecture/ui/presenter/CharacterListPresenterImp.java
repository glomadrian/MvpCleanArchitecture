package com.github.glomadrian.mvpcleanarchitecture.ui.presenter;

import android.content.Context;
import android.util.Log;

import com.github.glomadrian.mvpcleanarchitecture.app.BasePresenter;
import com.github.glomadrian.mvpcleanarchitecture.domain.LogUtils;
import com.github.glomadrian.mvpcleanarchitecture.domain.interactor.GetMarvelCharactersLimit;
import com.github.glomadrian.mvpcleanarchitecture.domain.interactor.GetMarvelCharactersPaginated;
import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacter;
import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacterList;
import com.github.glomadrian.mvpcleanarchitecture.ui.reactive.CharacterSelectedObservable;
import com.github.glomadrian.mvpcleanarchitecture.ui.view.CharacterListView;
<<<<<<< HEAD
import com.github.glomadrian.mvpcleanarchitecture.ui.viewmodel.CharacterViewModel;
import com.github.glomadrian.mvpcleanarchitecture.ui.viewmodel.Model;
=======
import com.github.glomadrian.mvpcleanarchitecture.ui.viewModel.CharacterViewModel;
import com.github.glomadrian.mvpcleanarchitecture.ui.viewModel.Model;
>>>>>>> 546c101c57264276a397087a22e9847094903ffc

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author glomadrian
 */
public class CharacterListPresenterImp extends BasePresenter implements CharacterListPresenter {

<<<<<<< HEAD
    private static final int LIMIT_GET_CHARACTERS = 10;
    private static final int LIMIT_MORE_CHARACTERS = 5;
=======
>>>>>>> 546c101c57264276a397087a22e9847094903ffc

    private CharacterListView modelCollectionView;
    private GetMarvelCharactersLimit getMarvelCharactersLimit;
    private GetMarvelCharactersPaginated getMarvelCharactersPaginated;
    private MarvelCharacterList marvelCharacterCollection;
    private CharacterSelectedObservable characterSelectedObservable;
    private Context context;

    public CharacterListPresenterImp(Context context, GetMarvelCharactersLimit getMarvelCharactersLimit, GetMarvelCharactersPaginated getMarvelCharactersPaginated, CharacterSelectedObservable characterSelectedObservable) {
        super(context);
        this.context = context;
        this.getMarvelCharactersLimit = getMarvelCharactersLimit;
        this.getMarvelCharactersPaginated = getMarvelCharactersPaginated;
        this.characterSelectedObservable = characterSelectedObservable;
    }

    @Override
    public void initialize() {
        marvelCharacterCollection = new MarvelCharacterList();
        searchForCharacters();
    }

    @Override
    public void onViewCreate() {
        modelCollectionView.activateLastCharacterViewListener();
    }

    @Override
    public void onViewResume() {
<<<<<<< HEAD
        //Do nothing
=======

>>>>>>> 546c101c57264276a397087a22e9847094903ffc
    }

    @Override
    public void onViewDestroy() {
<<<<<<< HEAD
        //Do nothing
=======

>>>>>>> 546c101c57264276a397087a22e9847094903ffc
    }

    @Override
    public void setView(CharacterListView view) {
        this.modelCollectionView = view;
    }

    @Override
    public void onLastCharacterViewed() {
        searchForMoreCharacters();
    }

    @Override
    public MarvelCharacterList getParcelableCollection() {
        return marvelCharacterCollection;
    }

    @Override
    public void restoreParcelableCollection(MarvelCharacterList marvelCharacters) {
        this.marvelCharacterCollection = marvelCharacters;
        modelCollectionView.add(convertToModelViewList(marvelCharacters.getMarvelCharacters()));
    }

    @Override
    public void onCharacterSelected(int position) {
        Collection<MarvelCharacter> marvelCharacters = marvelCharacterCollection.getMarvelCharacters();
        MarvelCharacter marvelCharacter = (MarvelCharacter) marvelCharacters.toArray()[position];
        characterSelectedObservable.notifyObservers(marvelCharacter);
    }

    private void searchForCharacters() {

<<<<<<< HEAD
        getMarvelCharactersLimit.execute(LIMIT_GET_CHARACTERS, new GetMarvelCharactersLimit.Callback() {
=======
        getMarvelCharactersLimit.execute(10, new GetMarvelCharactersLimit.Callback() {
>>>>>>> 546c101c57264276a397087a22e9847094903ffc
            @Override
            public void onMarvelCharacterList(List<MarvelCharacter> marvelCharacters) {
                marvelCharacterCollection.addAll(marvelCharacters);
                modelCollectionView.add(convertToModelViewList(marvelCharacters));
            }

            @Override
            public void onError() {
                Log.e(LogUtils.generateTag(this), "Error on interactor getMarvelCharactersLimit");
                modelCollectionView.onError();
            }
        });
    }

    private void searchForMoreCharacters() {

        modelCollectionView.disableLastCharacterViewListener();
        modelCollectionView.showLoading();

<<<<<<< HEAD
        getMarvelCharactersPaginated.execute(LIMIT_MORE_CHARACTERS, modelCollectionView.getModelsRenderer(), new GetMarvelCharactersPaginated.Callback() {
=======
        getMarvelCharactersPaginated.execute(5, modelCollectionView.getModelsRenderer(), new GetMarvelCharactersPaginated.Callback() {
>>>>>>> 546c101c57264276a397087a22e9847094903ffc
            @Override
            public void onMarvelCharacterList(List<MarvelCharacter> marvelCharacters) {
                marvelCharacterCollection.addAll(marvelCharacters);
                modelCollectionView.add(convertToModelViewList(marvelCharacters));
                modelCollectionView.hideLoading();
                modelCollectionView.activateLastCharacterViewListener();
            }

            @Override
            public void onError() {
                Log.e(LogUtils.generateTag(this), "Error on interactor getMarvelCharactersPaginated");
                modelCollectionView.hideLoading();
                modelCollectionView.activateLastCharacterViewListener();
                modelCollectionView.onError();
            }
        });
    }

    private List<Model> convertToModelViewList(List<MarvelCharacter> marvelCharacters) {


        List<Model> modelList = new ArrayList<Model>();

        for (MarvelCharacter marvelCharacter : marvelCharacters) {
            modelList.add(new CharacterViewModel(marvelCharacter));
        }

        return modelList;
    }
}
