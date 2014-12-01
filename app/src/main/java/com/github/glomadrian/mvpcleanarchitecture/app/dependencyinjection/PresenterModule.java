package com.github.glomadrian.mvpcleanarchitecture.app.dependencyinjection;

import android.content.Context;

import com.github.glomadrian.mvpcleanarchitecture.domain.interactor.GetMarvelCharactersLimit;
import com.github.glomadrian.mvpcleanarchitecture.domain.interactor.GetMarvelCharactersPaginated;
import com.github.glomadrian.mvpcleanarchitecture.ui.presenter.CharacterInfoPresenter;
import com.github.glomadrian.mvpcleanarchitecture.ui.presenter.CharacterInfoPresenterImp;
import com.github.glomadrian.mvpcleanarchitecture.ui.presenter.CharacterListPresenter;
import com.github.glomadrian.mvpcleanarchitecture.ui.presenter.CharacterListPresenterImp;
import com.github.glomadrian.mvpcleanarchitecture.ui.reactive.CharacterSelectedObservable;

import dagger.Module;
import dagger.Provides;

/**
 * @author glomadrian
 */
@Module(
        complete = false,
        library = true
)
public class PresenterModule {

    @Provides
    public CharacterListPresenter provideCharacterCollectionPresenter(Context context, GetMarvelCharactersLimit getMarvelCharactersLimit, GetMarvelCharactersPaginated getMarvelCharactersPaginated, CharacterSelectedObservable characterSelectedObservable) {
        return new CharacterListPresenterImp(context, getMarvelCharactersLimit, getMarvelCharactersPaginated, characterSelectedObservable);
    }

    @Provides
    public CharacterInfoPresenter provideCharacterInfoPresenter() {
        return new CharacterInfoPresenterImp();
    }

}
