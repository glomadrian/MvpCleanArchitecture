package com.github.glomadrian.mvpcleanarchitecture.executor;

/**
 * The interactors callbacks are executed in a different thread, in Android the ui thread to perform
 * view changes
 *
 * @author glomadrian
 */
public interface MainThreadExecutor {

    void execute(Runnable runnable);
}
