package com.github.glomadrian.mvpcleanarchitecture.executor;


import android.os.Handler;
import android.os.Looper;

/**
 * Main Thread executor using classic Looper.getMainLooper() from Android
 *
 * @author glomadrian
 */
public class MainThreadExecutorImp implements MainThreadExecutor {

    private Handler handler;

    public MainThreadExecutorImp() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(Runnable runnable) {
        handler.post(runnable);
    }
}
