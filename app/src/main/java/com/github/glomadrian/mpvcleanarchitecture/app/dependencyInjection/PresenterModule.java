package com.github.glomadrian.mpvcleanarchitecture.app.dependencyInjection;

import android.content.Context;

import com.github.glomadrian.mpvcleanarchitecture.domain.interactor.GetMarvelCharactersLimit;
import com.github.glomadrian.mpvcleanarchitecture.domain.interactor.GetMarvelCharactersPaginated;
import com.github.glomadrian.mpvcleanarchitecture.ui.presenter.CharacterCollectionPresenter;
import com.github.glomadrian.mpvcleanarchitecture.ui.presenter.CharacterCollectionPresenterImp;
import com.github.glomadrian.mpvcleanarchitecture.ui.presenter.CharacterInfoPresenter;
import com.github.glomadrian.mpvcleanarchitecture.ui.presenter.CharacterInfoPresenterImp;
import com.github.glomadrian.mpvcleanarchitecture.ui.reactive.CharacterSelectedObservable;

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
