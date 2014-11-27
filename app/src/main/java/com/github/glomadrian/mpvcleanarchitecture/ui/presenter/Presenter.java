package com.github.glomadrian.mpvcleanarchitecture.ui.presenter;

import com.github.glomadrian.mpvcleanarchitecture.ui.view.View;

/**
 * Presenter with lifecycle
 *
 * @author glomadrian
 */
public interface Presenter<T1 extends View> {

    void initialize();

    void onViewCreate();

    void onViewResume();

    void onViewDestroy();

    void setView(T1 view);
}
