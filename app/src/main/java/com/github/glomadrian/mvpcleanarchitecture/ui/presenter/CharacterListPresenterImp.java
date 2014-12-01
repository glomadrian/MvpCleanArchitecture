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
import com.github.glomadrian.mvpcleanarchitecture.ui.viewmodel.CharacterViewModel;
import com.github.glomadrian.mvpcleanarchitecture.ui.viewmodel.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author glomadrian
 */
public class CharacterListPresenterImp extends BasePresenter implements CharacterListPresenter {

    private static final int LIMIT_GET_CHARACTERS = 10;
    private static final int LIMIT_MORE_CHARACTERS = 5;

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
        //Do nothing
    }

    @Override
    public void onViewDestroy() {
        //Do nothing
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

        getMarvelCharactersLimit.execute(LIMIT_GET_CHARACTERS, new GetMarvelCharactersLimit.Callback() {
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

        getMarvelCharactersPaginated.execute(LIMIT_MORE_CHARACTERS, modelCollectionView.getModelsRenderer(), new GetMarvelCharactersPaginated.Callback() {
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
