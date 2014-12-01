package com.github.glomadrian.mvpcleanarchitecture.ui.viewmodel;

import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacter;

/**
 * Custom implementation for use with the view ModelInfoView, in this case the model is a Character
 *
 * @author glomadrian
 */
public class CharacterInfoViewModel extends ModelInfo {

    private MarvelCharacter marvelCharacter;

    public CharacterInfoViewModel(MarvelCharacter model) {
        marvelCharacter = model;
    }

    @Override
    public String getInfoImageUrl() {
        return marvelCharacter.getImageURL();
    }

    @Override
    public String getInfoNumber1() {
        return String.valueOf(marvelCharacter.getComics());
    }

    @Override
    public String getInfoNumber2() {
        return String.valueOf(marvelCharacter.getComics());
    }

    @Override
    public String getInfoNumber3() {
        return String.valueOf(marvelCharacter.getStories());
    }

    @Override
    public String getInfoDescription() {
        return String.valueOf(marvelCharacter.getDescription());
    }

    @Override
    public String getInfoTitle() {
        return String.valueOf(marvelCharacter.getName());
    }
}
