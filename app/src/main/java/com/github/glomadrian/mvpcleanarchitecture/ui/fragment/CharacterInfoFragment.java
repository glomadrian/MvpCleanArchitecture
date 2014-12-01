package com.github.glomadrian.mvpcleanarchitecture.ui.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.glomadrian.mvpcleanarchitecture.R;
import com.github.glomadrian.mvpcleanarchitecture.app.BaseFragment;
import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacter;
import com.github.glomadrian.mvpcleanarchitecture.ui.presenter.CharacterInfoPresenter;
import com.github.glomadrian.mvpcleanarchitecture.ui.view.ModelInfoView;
import com.github.glomadrian.mvpcleanarchitecture.ui.viewmodel.CharacterInfoViewModel;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import javax.inject.Inject;

import butterknife.InjectView;
import butterknife.Optional;

/**
 * @author glomadrian
 */
public class CharacterInfoFragment extends BaseFragment implements ModelInfoView {

    public static final String KEY_CHARACTER = "character";

    @Inject
    CharacterInfoPresenter characterInfoPresenter;
    @Optional
    @InjectView(R.id.info_image)
    ImageView infoImage;
    @InjectView(R.id.info_description)
    TextView infoDescription;
    @InjectView(R.id.info_title)
    TextView infoTitle;
    @InjectView(R.id.info_number_1)
    TextView infoNumber1;
    @InjectView(R.id.info_number_2)
    TextView infoNumber2;
    @InjectView(R.id.info_number_3)
    TextView infoNumber3;

    private String tag;

    public static CharacterInfoFragment newInstance(MarvelCharacter marvelCharacter) {

        Bundle args = new Bundle();
        Parcelable marvelCharacterParcel = Parcels.wrap(marvelCharacter);
        args.putParcelable(KEY_CHARACTER, marvelCharacterParcel);

        CharacterInfoFragment characterInfoFragment = new CharacterInfoFragment();
        characterInfoFragment.setArguments(args);
        return characterInfoFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.model_info, container, false);
        this.tag = String.valueOf(view.getTag());
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        characterInfoPresenter.onViewCreate();
        characterInfoPresenter.setView(this);

        //Get character info
        if (getArguments() != null) {
            MarvelCharacter marvelCharacter = getMarvelCharacterFromArgs();
            characterInfoPresenter.onCharacter(marvelCharacter);
        }
    }

    @Override
    public void showCharacterInfo(CharacterInfoViewModel characterInfoViewModel) {

        if (tag.equals("character_info_portrait")) {
            Picasso.with(getActivity()).load(characterInfoViewModel.getInfoImageUrl()).into(infoImage);
        }

        infoNumber1.setText(characterInfoViewModel.getInfoNumber1());
        infoNumber2.setText(characterInfoViewModel.getInfoNumber2());
        infoNumber3.setText(characterInfoViewModel.getInfoNumber3());
        infoDescription.setText(characterInfoViewModel.getInfoDescription());
        infoTitle.setText(characterInfoViewModel.getInfoTitle());
    }

    private MarvelCharacter getMarvelCharacterFromArgs() {
        Parcelable marvelCharacterParcelable = getArguments().getParcelable(KEY_CHARACTER);
        return Parcels.unwrap(marvelCharacterParcelable);
    }


}
