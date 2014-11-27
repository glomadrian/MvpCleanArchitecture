package com.github.glomadrian.mpvcleanarchitecture.domain.model;/**
 * @author glomadrian
 */

import org.parceler.Parcel;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author glomadrian
 */
@Parcel
public class MarvelCharacterCollection implements Iterable<MarvelCharacter>, Serializable {

    private final Set<MarvelCharacter> marvelCharacters;

    public MarvelCharacterCollection() {
        this.marvelCharacters = new LinkedHashSet<MarvelCharacter>();
    }

    public Collection<MarvelCharacter> getMarvelCharacters() {
        return (Collection<MarvelCharacter>) ((LinkedHashSet<MarvelCharacter>) marvelCharacters).clone();
    }

    public void add(MarvelCharacter marvelCharacter) {
        this.marvelCharacters.add(marvelCharacter);
    }

    public void addAll(Collection<MarvelCharacter> marvelCharacter) {
        this.marvelCharacters.addAll(marvelCharacter);
    }

    @Override
    public Iterator<MarvelCharacter> iterator() {
        return marvelCharacters.iterator();
    }


}
