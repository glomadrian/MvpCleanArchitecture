package com.github.glomadrian.mvpcleanarchitecture.app;

import android.app.Application;
import android.content.Context;

<<<<<<< HEAD
import com.github.glomadrian.mvpcleanarchitecture.app.dependencyinjection.RootModule;
=======
import com.github.glomadrian.mvpcleanarchitecture.app.dependencyInjection.RootModule;
>>>>>>> 546c101c57264276a397087a22e9847094903ffc

import dagger.ObjectGraph;

/**
 * @author glomadrian
 */
public class MVPCleanArchitectureApplication extends Application {

    private ObjectGraph objectGraph;

    /**
     * Static method for get application context
     *
     * @param context
     * @return
     */
    public static MVPCleanArchitectureApplication get(Context context) {
        return (MVPCleanArchitectureApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(new RootModule(this));
        objectGraph.inject(this);
<<<<<<< HEAD
=======
//        objectGraph.injectStatics();
>>>>>>> 546c101c57264276a397087a22e9847094903ffc
    }

    public void inject(Object object) {
        objectGraph.inject(object);
    }

    /**
     * Add a new module to the dependency graph
     *
     * @param modules
     */
    public void addModules(Object... modules) {
        objectGraph.plus(modules);
    }
}
