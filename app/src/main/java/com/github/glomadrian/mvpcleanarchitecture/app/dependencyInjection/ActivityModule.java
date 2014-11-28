package com.github.glomadrian.mvpcleanarchitecture.app.dependencyInjection;

import android.app.Activity;
import android.content.Context;

import com.github.glomadrian.mvpcleanarchitecture.app.dependencyInjection.qualifier.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * @author glomadrian
 */
@Module(library = true)
public class ActivityModule {

    private final Activity activity;

    /**
     * When a activity is created a new activity module is crate with the actual context and
     * added to the object graph
     *
     * @param activity
     */
    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideActivityContext() {
        return activity;
    }

}
