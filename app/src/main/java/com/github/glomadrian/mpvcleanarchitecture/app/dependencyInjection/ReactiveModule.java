package com.github.glomadrian.mpvcleanarchitecture.app.dependencyInjection;

import com.github.glomadrian.mpvcleanarchitecture.ui.reactive.CharacterSelectedObservable;

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
