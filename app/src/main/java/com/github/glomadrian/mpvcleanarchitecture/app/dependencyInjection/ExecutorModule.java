package com.github.glomadrian.mpvcleanarchitecture.app.dependencyInjection;

import com.github.glomadrian.mpvcleanarchitecture.executor.InteractorExecutor;
import com.github.glomadrian.mpvcleanarchitecture.executor.MainThreadExecutor;
import com.github.glomadrian.mpvcleanarchitecture.executor.MainThreadExecutorImp;
import com.github.glomadrian.mpvcleanarchitecture.executor.ThreadExecutor;

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
