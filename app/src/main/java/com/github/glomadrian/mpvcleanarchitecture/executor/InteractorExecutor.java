package com.github.glomadrian.mpvcleanarchitecture.executor;

/**
 * Interface for create executors, the executors will only execute Interactors
 *
 * @author glomadrian
 */
public interface InteractorExecutor {

    void run(Interactor interactor);
}
