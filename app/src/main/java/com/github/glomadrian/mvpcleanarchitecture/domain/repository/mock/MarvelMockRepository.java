package com.github.glomadrian.mvpcleanarchitecture.domain.repository.mock;

import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacter;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.MarvelRepository;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.exception.GetCharactersException;

import java.util.ArrayList;
import java.util.List;

/**
 * Mock repository for testing
 *
 * @author glomadrian
 */
public class MarvelMockRepository implements MarvelRepository {

    @Override
    public List<MarvelCharacter> getCharacterCollection(int limit) throws GetCharactersException {
        return generateMockCharacters();
    }

    @Override
    public List<MarvelCharacter> getCharacterCollectionPaginated(int limit, int offset) throws GetCharactersException {
        return generateMockCharacters();
    }


    private List<MarvelCharacter> generateMockCharacters() {

        List<MarvelCharacter> marvelCharacters = new ArrayList<>();

        marvelCharacters.add(createMarvelCharacter("Thor",
                "Thor possesses a very high resistance to physical injury that approaches " +
                        "invulnerability. Thor possesses keen senses that allow him to" +
                        " track objects traveling faster than light and hear cries from the" +
                        " other side of the planet.[203] Thor has the ability to travel through time.",
                "http://www.tuexpertojuegos.com/wp-content/uploads//2010/07/thor-marvel.jpg"
        ));

        marvelCharacters.add(createMarvelCharacter("Captain America",
                "Captain America was the first Marvel Comics to have appeared in media outside " +
                        "comics with the release of the 1944 movie serial Captain America. Since " +
                        "then, the character has been featured in such other films and television" +
                        " series, more recently in the Marvel Cinematic Universe (MCU) portrayed " +
                        "by Chris Evans in Captain America: The First Avenger, The Avengers, " +
                        "Captain America: The Winter Soldier and the upcoming Avengers: " +
                        "Age of Ultron.",
                "http://www.marvelnoise.com/wp-content/uploads/2009/06/CaptainAmerica_Reborn_01_QuesadaVariant.jpg"
        ));

        marvelCharacters.add(createMarvelCharacter("Hulk",
                "Lee said that the Hulk's creation was inspired by a combination of " +
                        "Frankenstein and Dr. Jekyll and Mr. Hyde. Although the Hulk's" +
                        " coloration has varied throughout the character's publication history," +
                        " the most usual color is green. As a child, Banner's father Brian Banner" +
                        " often got mad and physically abused his mother Rebecca, creating the " +
                        "psychological complex of fear, anger, and the fear of anger and the " +
                        "destruction it can cause that underlies the character.",
                "http://cdn.screenrant.com/wp-content/uploads/Incredible-Hulk-Marvel-Now-Comics.jpg"
        ));
        marvelCharacters.add(createMarvelCharacter("Iron Man",
                "Iron Man (Tony Stark) is a fictional character, a superhero that appears in " +
                        "books published by Marvel Comics. The character was created by " +
                        "writer-editor Stan Lee, developed by scripter Larry Lieber, and designed" +
                        " by artists Don Heck and Jack Kirby. He made his first appearance in " +
                        "Tales of Suspense #39 (March 1963).",
                "http://bigfanboy.com/wp/wp-content/uploads/2010/04/ironman-royalp-front.jpg"
        ));
        marvelCharacters.add(createMarvelCharacter("Black Widow",
                "Natalia \"Natasha\" Alianovna Romanova is the first character to take on the " +
                        "Black Widow codename in the modern mainstream Marvel Comics. She was " +
                        "created by editor and plotter Stan Lee, scripter Don Rico and artist" +
                        " Don Heck, and first appeared in Tales of Suspense #52 (April 1964).",
                "http://static.comicvine.com/uploads/original/7/75210/1960320-black_widow_marvel_superheroines_8418333_796_545.jpg"
        ));
        marvelCharacters.add(createMarvelCharacter("Vision",
                "The first Vision was created by the writer-artist team of Joe Simon and Jack Kirby " +
                        "in Marvel Mystery Comics #13 (Nov. 1940), published by Marvel predecessor" +
                        " Timely Comics during the 1930s-1940s period which fans and historians " +
                        "call the Golden Age of Comic Books.",
                "http://www.beyondhollywood.com/uploads/2012/05/Vision-Comic-Book-e1336494560758.jpg"
        ));

        return marvelCharacters;
    }

    private MarvelCharacter createMarvelCharacter(String name, String description, String imageUrl) {

        MarvelCharacter marvelCharacter = new MarvelCharacter();
        marvelCharacter.setId(getRandomNumber());
        marvelCharacter.setName(name);
        marvelCharacter.setComics(getRandomNumber());
        marvelCharacter.setDescription(description);
        marvelCharacter.setImageURL(imageUrl);
        marvelCharacter.setStories(getRandomNumber());
        marvelCharacter.setSeries(getRandomNumber());

        return marvelCharacter;
    }

    private int getRandomNumber() {
        return 1 + (int) (Math.random() * 999);
    }
}
