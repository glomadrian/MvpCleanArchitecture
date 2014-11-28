package com.github.glomadrian.mvpcleanarchitecture.app.dependencyInjection;

import android.content.Context;
import android.view.LayoutInflater;

import com.github.glomadrian.mvpcleanarchitecture.app.MVPCleanArchitectureApplication;
import com.github.glomadrian.mvpcleanarchitecture.ui.activity.MainActivity;
import com.github.glomadrian.mvpcleanarchitecture.ui.activity.ModelInfoActivity;
import com.github.glomadrian.mvpcleanarchitecture.ui.fragment.CharacterCollectionFragment;
import com.github.glomadrian.mvpcleanarchitecture.ui.fragment.CharacterInfoFragment;
import com.github.glomadrian.mvpcleanarchitecture.ui.presenter.CharacterCollectionPresenterImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author glomadrian
 */

@Module(
        includes = {
                ExecutorModule.class,
                InteractorModule.class,
                RepositoryModule.class,
                PresenterModule.class,
                ReactiveModule.class
        },
        injects = {
                MVPCleanArchitectureApplication.class,
                CharacterCollectionFragment.class,
                CharacterInfoFragment.class,
                CharacterCollectionPresenterImp.class,
                MainActivity.class,
                CharacterInfoFragment.class,
                ModelInfoActivity.class
        },
        library = true
)
public class RootModule {

    private final Context context;

    public RootModule(Context context) {
        this.context = context;
    }


    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return context;
    }

    @Provides
    public LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(context);
    }


}
