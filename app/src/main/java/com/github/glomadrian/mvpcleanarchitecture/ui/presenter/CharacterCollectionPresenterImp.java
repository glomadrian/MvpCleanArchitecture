package com.github.glomadrian.mvpcleanarchitecture.ui.presenter;

import android.content.Context;

import com.github.glomadrian.mvpcleanarchitecture.app.BasePresenter;
import com.github.glomadrian.mvpcleanarchitecture.domain.interactor.GetMarvelCharactersLimit;
import com.github.glomadrian.mvpcleanarchitecture.domain.interactor.GetMarvelCharactersPaginated;
import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacter;
import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacterCollection;
import com.github.glomadrian.mvpcleanarchitecture.ui.reactive.CharacterSelectedObservable;
import com.github.glomadrian.mvpcleanarchitecture.ui.view.CharacterCollectionView;
import com.github.glomadrian.mvpcleanarchitecture.ui.viewModel.CharacterViewModel;
import com.github.glomadrian.mvpcleanarchitecture.ui.viewModel.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author glomadrian
 */
public class CharacterCollectionPresenterImp extends BasePresenter implements CharacterCollectionPresenter {


    private CharacterCollectionView modelCollectionView;
    private GetMarvelCharactersLimit getMarvelCharactersLimit;
    private GetMarvelCharactersPaginated getMarvelCharactersPaginated;
    private MarvelCharacterCollection marvelCharacterCollection;
    private CharacterSelectedObservable characterSelectedObservable;
    private Context context;

    public CharacterCollectionPresenterImp(Context context, GetMarvelCharactersLimit getMarvelCharactersLimit, GetMarvelCharactersPaginated getMarvelCharactersPaginated, CharacterSelectedObservable characterSelectedObservable) {
        super(context);
        this.context = context;
        this.getMarvelCharactersLimit = getMarvelCharactersLimit;
        this.getMarvelCharactersPaginated = getMarvelCharactersPaginated;
        this.characterSelectedObservable = characterSelectedObservable;
    }

    @Override
    public void initialize() {
        marvelCharacterCollection = new MarvelCharacterCollection();
        searchForCharacters();
    }

    @Override
    public void onViewCreate() {
        modelCollectionView.activateLastCharacterViewListener();
    }

    @Override
    public void onViewResume() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void setView(CharacterCollectionView view) {
        this.modelCollectionView = view;
    }

    @Override
    public void onLastCharacterViewed() {
        searchForMoreCharacters();
    }

    @Override
    public MarvelCharacterCollection getParcelableCollection() {
        return marvelCharacterCollection;
    }

    @Override
    public void restoreParcelableCollection(MarvelCharacterCollection marvelCharacters) {
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

        getMarvelCharactersLimit.execute(10, new GetMarvelCharactersLimit.Callback() {
            @Override
            public void onMarvelCharacterList(Collection<MarvelCharacter> marvelCharacters) {
                marvelCharacterCollection.addAll(marvelCharacters);
                modelCollectionView.add(convertToModelViewList(marvelCharacters));
            }

            @Override
            public void onError() {

            }
        });
    }

    private void searchForMoreCharacters() {

        modelCollectionView.disableLastCharacterViewListener();
        modelCollectionView.showLoading();

        getMarvelCharactersPaginated.execute(5, modelCollectionView.getModelsRenderer(), new GetMarvelCharactersPaginated.Callback() {
            @Override
            public void onMarvelCharacterList(Collection<MarvelCharacter> marvelCharacters) {
                marvelCharacterCollection.addAll(marvelCharacters);
                modelCollectionView.add(convertToModelViewList(marvelCharacters));
                modelCollectionView.hideLoading();
                modelCollectionView.activateLastCharacterViewListener();
            }

            @Override
            public void onError() {
                modelCollectionView.hideLoading();
                modelCollectionView.activateLastCharacterViewListener();
            }
        });
    }

    private List<Model> convertToModelViewList(Collection<MarvelCharacter> marvelCharacters) {


        List<Model> modelList = new ArrayList<Model>();

        for (MarvelCharacter marvelCharacter : marvelCharacters) {
            modelList.add(new CharacterViewModel(marvelCharacter));
        }

        return modelList;
    }
}
