package com.github.glomadrian.mvpcleanarchitecture.ui.viewmodel;

import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacter;

/**
 * Custom implementation of a model to use with ModelCollectionView
 *
 * @author glomadrian
 */
public class CharacterViewModel extends Model {

    MarvelCharacter model;

    public CharacterViewModel(MarvelCharacter model) {
        this.model = model;
    }

    @Override
    public String getImageUrl() {
        return model.getImageURL();
    }

    @Override
    public String getTitle() {
        return model.getName();
    }

    @Override
    public String getSubtitle() {
        return String.valueOf(model.getId());
    }
}
