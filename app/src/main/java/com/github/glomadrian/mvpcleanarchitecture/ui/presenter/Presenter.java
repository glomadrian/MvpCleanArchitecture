package com.github.glomadrian.mvpcleanarchitecture.ui.presenter;

import com.github.glomadrian.mvpcleanarchitecture.ui.view.View;

/**
 * Presenter with lifecycle
 *
 * @author glomadrian
 */
<<<<<<< HEAD
public interface Presenter<T extends View> {
=======
public interface Presenter<T1 extends View> {
>>>>>>> 546c101c57264276a397087a22e9847094903ffc

    void initialize();

    void onViewCreate();

    void onViewResume();

    void onViewDestroy();

<<<<<<< HEAD
    void setView(T view);
=======
    void setView(T1 view);
>>>>>>> 546c101c57264276a397087a22e9847094903ffc
}
