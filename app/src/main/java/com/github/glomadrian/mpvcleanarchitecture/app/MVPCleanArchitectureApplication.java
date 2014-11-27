package com.github.glomadrian.mpvcleanarchitecture.app;

import android.app.Application;
import android.content.Context;

import com.github.glomadrian.mpvcleanarchitecture.app.dependencyInjection.RootModule;

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
//        objectGraph.injectStatics();
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
