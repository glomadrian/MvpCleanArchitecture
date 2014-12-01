package com.github.glomadrian.mvpcleanarchitecture.executor;

/**
 * The interactors callbacks are executed in a different thread, in Android the ui thread to perform
 * view changes
<<<<<<< HEAD
 *
=======
>>>>>>> 546c101c57264276a397087a22e9847094903ffc
 * @author glomadrian
 */
public interface MainThreadExecutor {

    void execute(Runnable runnable);
}
