package com.github.glomadrian.mvpcleanarchitecture.ui.reactive;

/**
 * @author glomadrian
 */
public interface Observable<T> {

    void register(T observer);

    void unregister(T observer);
}
