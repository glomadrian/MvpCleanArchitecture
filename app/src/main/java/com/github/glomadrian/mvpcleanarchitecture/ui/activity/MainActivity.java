package com.github.glomadrian.mvpcleanarchitecture.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;

import com.github.glomadrian.mvpcleanarchitecture.R;
import com.github.glomadrian.mvpcleanarchitecture.app.BaseActivity;
import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacter;
import com.github.glomadrian.mvpcleanarchitecture.ui.fragment.CharacterInfoFragment;
import com.github.glomadrian.mvpcleanarchitecture.ui.reactive.CharacterSelectedObservable;
import com.github.glomadrian.mvpcleanarchitecture.ui.reactive.CharacterSelectedObserver;

import org.parceler.Parcels;

import javax.inject.Inject;


/**
 * Main activity of the Application, it decide if launch a new activity or update the fragment
 * depending of the view inflated
 * <p/>
 * This activity is the container of one fragment if is in portrait and 2 if is in landscape
 * The type of the layout inflated will be checked and use for navigation
 *
 * @author glomadrian
 */
public class MainActivity extends BaseActivity implements CharacterSelectedObserver {


    public static final String TAG_PORTRAIT = "V11-portrait";
    public static final String TAG_LANDSCAPE = "V11-landscape";

    @Inject
    CharacterSelectedObservable characterSelectedObservable;


    //The viewTag is the key for the navigation with different sizes
    private String viewTag;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(this).inflate(R.layout.main, null);
        viewTag = (String) view.getTag();
        setContentView(view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        characterSelectedObservable.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        characterSelectedObservable.unregister(this);
    }

    /**
     * This method is called when a new marvel character is selected
     *
     * @param marvelCharacter
     */
    @Override
    public void characterSelected(MarvelCharacter marvelCharacter) {
        if (viewTag.equals(TAG_PORTRAIT)) {
            launchCharacterInfoActivity(marvelCharacter);
        }

        if (viewTag.equals(TAG_LANDSCAPE)) {
            replaceCharacterInfoFragment(marvelCharacter);
        }
    }

    //TODO Change to navigator class with activity context
    private void launchCharacterInfoActivity(MarvelCharacter marvelCharacter) {
        Intent intent = new Intent(this, ModelInfoActivity.class);
        Parcelable parcelable = Parcels.wrap(marvelCharacter);
        intent.putExtra(ModelInfoActivity.KEY_CHARACTER, parcelable);
        startActivity(intent);
    }

    private void replaceCharacterInfoFragment(MarvelCharacter marvelCharacter) {
        CharacterInfoFragment characterInfoFragment = CharacterInfoFragment.newInstance(marvelCharacter);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.character_info_fragment, characterInfoFragment)
                .disallowAddToBackStack()
                .commit();
    }
}
