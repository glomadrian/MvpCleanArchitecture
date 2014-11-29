package com.github.glomadrian.mvpcleanarchitecture.domain.model;/**
 * @author glomadrian
 */

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author glomadrian
 */
@Parcel
public class MarvelCharacterList {

    public final List<MarvelCharacter> marvelCharacters;

    public MarvelCharacterList() {
        this.marvelCharacters = new ArrayList<MarvelCharacter>();
    }

    public List<MarvelCharacter> getMarvelCharacters() {
        return (List<MarvelCharacter>) ((ArrayList<MarvelCharacter>) marvelCharacters).clone();
    }

    public void add(MarvelCharacter marvelCharacter) {
        this.marvelCharacters.add(marvelCharacter);
    }

    public void addAll(List<MarvelCharacter> marvelCharacter) {
        this.marvelCharacters.addAll(marvelCharacter);
    }

}
