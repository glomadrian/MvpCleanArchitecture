package com.github.glomadrian.mpvcleanarchitecture.ui.activity;

import android.os.Bundle;
import android.os.Parcelable;

import com.github.glomadrian.mpvcleanarchitecture.R;
import com.github.glomadrian.mpvcleanarchitecture.app.BaseActivity;
import com.github.glomadrian.mpvcleanarchitecture.domain.model.MarvelCharacter;
import com.github.glomadrian.mpvcleanarchitecture.ui.fragment.CharacterInfoFragment;

import org.parceler.Parcels;

/**
 * @author glomadrian
 */
public class ModelInfoActivity extends BaseActivity {

    public final static String KEY_CHARACTER = "character";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.model_info_activity);

        addInfoFragment();
    }

    public void addInfoFragment() {

        Parcelable marvelCharacterParcelable = getIntent().getExtras().getParcelable(KEY_CHARACTER);
        MarvelCharacter marvelCharacter = Parcels.unwrap(marvelCharacterParcelable);

        CharacterInfoFragment characterInfoFragment = CharacterInfoFragment.newInstance(marvelCharacter);

        getFragmentManager()
                .beginTransaction()
                .add(R.id.info_frame, characterInfoFragment)
                .commit();
    }

}
