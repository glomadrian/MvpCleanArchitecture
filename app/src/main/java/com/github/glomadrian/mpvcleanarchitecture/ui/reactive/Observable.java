package com.github.glomadrian.mpvcleanarchitecture.ui.reactive;

/**
 * @author glomadrian
 */
public interface Observable<T1> {

    void register(T1 observer);

    void unregister(T1 observer);
}
