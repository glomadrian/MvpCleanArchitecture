package com.github.glomadrian.mvpcleanarchitecture.domain.interactor;

<<<<<<< HEAD
import com.github.glomadrian.mvpcleanarchitecture.executor.Interactor;
import com.github.glomadrian.mvpcleanarchitecture.executor.InteractorExecutor;
=======
import com.github.glomadrian.mvpcleanarchitecture.executor.InteractorExecutor;
import com.github.glomadrian.mvpcleanarchitecture.executor.Interactor;
>>>>>>> 546c101c57264276a397087a22e9847094903ffc
import com.github.glomadrian.mvpcleanarchitecture.executor.MainThreadExecutor;

/**
 * @author glomadrian
 */
public abstract class AbstractInteractor implements Interactor {

    private InteractorExecutor interactorExecutor;
    private MainThreadExecutor mainThreadExecutor;

    public AbstractInteractor(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor) {
        this.interactorExecutor = interactorExecutor;
        this.mainThreadExecutor = mainThreadExecutor;
    }

    public InteractorExecutor getInteractorExecutor() {
        return interactorExecutor;
    }

    public void setInteractorExecutor(InteractorExecutor interactorExecutor) {
        this.interactorExecutor = interactorExecutor;
    }

    public MainThreadExecutor getMainThreadExecutor() {
        return mainThreadExecutor;
    }

    public void setMainThreadExecutor(MainThreadExecutor mainThreadExecutor) {
        this.mainThreadExecutor = mainThreadExecutor;
    }
}
