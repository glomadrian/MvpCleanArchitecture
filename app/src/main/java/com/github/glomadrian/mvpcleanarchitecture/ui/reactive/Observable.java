package com.github.glomadrian.mvpcleanarchitecture.ui.reactive;

/**
 * @author glomadrian
 */
public interface Observable<T1> {

    void register(T1 observer);

    void unregister(T1 observer);
}
