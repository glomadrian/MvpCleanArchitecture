package com.github.glomadrian.mvpcleanarchitecture.app;

import android.app.Activity;
import android.os.Bundle;

<<<<<<< HEAD
import com.github.glomadrian.mvpcleanarchitecture.app.dependencyinjection.ActivityModule;
=======
import com.github.glomadrian.mvpcleanarchitecture.app.dependencyInjection.ActivityModule;
>>>>>>> 546c101c57264276a397087a22e9847094903ffc

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
        mvpCleanArchitectureApplication.addModules(new ActivityModule(this));
        mvpCleanArchitectureApplication.inject(this);
    }

    private void injectViews() {
        ButterKnife.inject(this);
    }
}
