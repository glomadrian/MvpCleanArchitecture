package com.github.glomadrian.mvpcleanarchitecture.app.dependencyinjection;

import com.github.glomadrian.mvpcleanarchitecture.ui.reactive.CharacterSelectedObservable;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author glomadrian
 */
@Module(
        complete = false,
        library = true
)
public class ReactiveModule {

    @Singleton
    @Provides
    CharacterSelectedObservable proviCharacterSelectedObservable() {
        return new CharacterSelectedObservable();
    }
}
