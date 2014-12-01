package com.github.glomadrian.mvpcleanarchitecture.app.dependencyinjection;

import com.github.glomadrian.mvpcleanarchitecture.executor.InteractorExecutor;
import com.github.glomadrian.mvpcleanarchitecture.executor.MainThreadExecutor;
import com.github.glomadrian.mvpcleanarchitecture.executor.MainThreadExecutorImp;
import com.github.glomadrian.mvpcleanarchitecture.executor.ThreadExecutor;

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
public class ExecutorModule {


    @Provides
    @Singleton
    public InteractorExecutor provideExecutor() {
        return new ThreadExecutor();
    }

    @Provides
    @Singleton
    public MainThreadExecutor provideMainThreadExecutor() {
        return new MainThreadExecutorImp();
    }
}
