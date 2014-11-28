package com.github.glomadrian.mvpcleanarchitecture.app.dependencyInjection;

import android.content.Context;

import com.github.glomadrian.mvpcleanarchitecture.domain.interactor.GetMarvelCharactersLimit;
import com.github.glomadrian.mvpcleanarchitecture.domain.interactor.GetMarvelCharactersPaginated;
import com.github.glomadrian.mvpcleanarchitecture.ui.presenter.CharacterCollectionPresenter;
import com.github.glomadrian.mvpcleanarchitecture.ui.presenter.CharacterCollectionPresenterImp;
import com.github.glomadrian.mvpcleanarchitecture.ui.presenter.CharacterInfoPresenter;
import com.github.glomadrian.mvpcleanarchitecture.ui.presenter.CharacterInfoPresenterImp;
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
    public CharacterCollectionPresenter provideCharacterCollectionPresenter(Context context, GetMarvelCharactersLimit getMarvelCharactersLimit, GetMarvelCharactersPaginated getMarvelCharactersPaginated, CharacterSelectedObservable characterSelectedObservable) {
        return new CharacterCollectionPresenterImp(context, getMarvelCharactersLimit, getMarvelCharactersPaginated, characterSelectedObservable);
    }

    @Provides
    public CharacterInfoPresenter provideCharacterInfoPresenter() {
        return new CharacterInfoPresenterImp();
    }

}
