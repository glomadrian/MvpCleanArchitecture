package com.github.glomadrian.mvpcleanarchitecture.app.dependencyinjection;

import android.content.Context;

import com.github.glomadrian.mvpcleanarchitecture.app.dependencyinjection.qualifier.ActivityContext;
import com.github.glomadrian.mvpcleanarchitecture.ui.navigator.MainNavigator;
import com.github.glomadrian.mvpcleanarchitecture.ui.navigator.Navigator;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @author glomadrian
 */
@Module(
        complete = false,
        library = true
)
public class NavigatorModule {

    @Provides
    @Named("main_navigator")
    public Navigator provideMainNavigator(@ActivityContext Context context) {
        return new MainNavigator(context);
    }
}
