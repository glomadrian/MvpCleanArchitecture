package com.github.glomadrian.mvpcleanarchitecture.app;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.ButterKnife;

/**
 * @author glomadrian
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectViews(view);
    }

    private void injectDependencies() {
        MVPCleanArchitectureApplication mvpCleanArchitectureApplication = (MVPCleanArchitectureApplication) getActivity().getApplication();
        mvpCleanArchitectureApplication.inject(this);
    }

    private void injectViews(View view) {
        ButterKnife.inject(this, view);
    }
}
