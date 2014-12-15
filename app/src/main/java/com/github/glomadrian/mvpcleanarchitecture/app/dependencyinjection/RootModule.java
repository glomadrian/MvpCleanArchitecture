package com.github.glomadrian.mvpcleanarchitecture.app.dependencyinjection;

import android.content.Context;
import android.view.LayoutInflater;

import com.github.glomadrian.mvpcleanarchitecture.app.MVPCleanArchitectureApplication;
import com.github.glomadrian.mvpcleanarchitecture.ui.activity.MainActivity;
import com.github.glomadrian.mvpcleanarchitecture.ui.activity.ModelInfoActivity;
import com.github.glomadrian.mvpcleanarchitecture.ui.fragment.CharacterInfoFragment;
import com.github.glomadrian.mvpcleanarchitecture.ui.fragment.CharacterListFragment;
import com.github.glomadrian.mvpcleanarchitecture.ui.presenter.CharacterListPresenterImp;

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
                ReactiveModule.class,
        },
        injects = {
                MVPCleanArchitectureApplication.class,
                CharacterListFragment.class,
                CharacterInfoFragment.class,
                CharacterListPresenterImp.class,
                MainActivity.class,
                CharacterInfoFragment.class,
                ModelInfoActivity.class,
                MainActivity.class
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
