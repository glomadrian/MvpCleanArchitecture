package com.github.glomadrian.mpvcleanarchitecture.app;

import android.content.Context;

import com.github.glomadrian.mpvcleanarchitecture.app.MVPCleanArchitectureApplication;

/**
 * @author glomadrian
 */
public class BasePresenter {

    public BasePresenter(Context context) {
        ((MVPCleanArchitectureApplication) context.getApplicationContext()).inject(this);

    }
}
