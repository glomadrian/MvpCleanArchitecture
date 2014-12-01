<<<<<<< HEAD
package com.github.glomadrian.mvpcleanarchitecture.domain.model;
=======
package com.github.glomadrian.mvpcleanarchitecture.domain.model;/**
 * @author glomadrian
 */
>>>>>>> 546c101c57264276a397087a22e9847094903ffc

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author glomadrian
 */
@Parcel
public class MarvelCharacterList {

<<<<<<< HEAD
    private final List<MarvelCharacter> marvelCharacters;
=======
    public final List<MarvelCharacter> marvelCharacters;
>>>>>>> 546c101c57264276a397087a22e9847094903ffc

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
