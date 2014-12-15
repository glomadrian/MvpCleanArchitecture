package com.github.glomadrian.mvpcleanarchitecture.app;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

/**
 * Base activity for doing the Dependency
 *
 * @author glomadrian
 */
public abstract class BaseActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        injectViews();
    }

    private void injectDependencies() {
        MVPCleanArchitectureApplication mvpCleanArchitectureApplication = (MVPCleanArchitectureApplication) getApplication();
        mvpCleanArchitectureApplication.inject(this);
    }


    private void injectViews() {
        ButterKnife.inject(this);
    }
}
