package com.github.glomadrian.mvpcleanarchitecture.ui.navigator;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacter;
import com.github.glomadrian.mvpcleanarchitecture.ui.activity.ModelInfoActivity;

import org.parceler.Parcels;

/**
 * @author glomadrian
 * @see com.github.glomadrian.mvpcleanarchitecture.ui.navigator.Navigator
 */
public class MainNavigator implements Navigator {

    /**
     * This context will be injected and must be the actual activity context
     *
     * @see com.github.glomadrian.mvpcleanarchitecture.app.dependencyinjection.ActivityModule
     * @see com.github.glomadrian.mvpcleanarchitecture.app.BaseActivity
     */
    private Context context;

    public MainNavigator(Context context) {
        this.context = context;
    }

    @Override
    public void openCharacterInfoView(MarvelCharacter marvelCharacter) {
        Intent intent = new Intent(context, ModelInfoActivity.class);
        Parcelable parcelable = Parcels.wrap(marvelCharacter);
        intent.putExtra(ModelInfoActivity.KEY_CHARACTER, parcelable);
        startActivity(intent);
    }

    private void startActivity(Intent intent) {
        context.startActivity(intent);
    }
}
