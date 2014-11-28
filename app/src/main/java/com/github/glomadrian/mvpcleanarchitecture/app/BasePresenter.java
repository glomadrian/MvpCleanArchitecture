package com.github.glomadrian.mvpcleanarchitecture.app;

import android.content.Context;

/**
 * @author glomadrian
 */
public class BasePresenter {

    public BasePresenter(Context context) {
        ((MVPCleanArchitectureApplication) context.getApplicationContext()).inject(this);

    }
}
