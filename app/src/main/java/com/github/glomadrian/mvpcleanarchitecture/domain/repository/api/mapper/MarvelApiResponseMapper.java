package com.github.glomadrian.mvpcleanarchitecture.domain.repository.api.mapper;

import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacter;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.ResponseMapper;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.api.model.Character;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.api.model.CharacterDataWrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This custom implementation of the mapper will map the response from the Marvel api to Domain model
 *
 * @author glomadrian
 */
public class MarvelApiResponseMapper implements ResponseMapper<CharacterDataWrapper> {

    @Override
    public List<MarvelCharacter> mapResponse(CharacterDataWrapper characterDataWrapper) {

        List<Character> characters = characterDataWrapper.getCharacterDataContainer().getResults();

        List<MarvelCharacter> marvelCharacters = Collections.emptyList();

        if (characterDataWrapper.getCharacterDataContainer().getCount() > 0) {
            marvelCharacters = new ArrayList<MarvelCharacter>();
        }

        for (Character character : characters) {
            marvelCharacters.add(createMarvelCharacterFromResponseCharacter(character));
        }

        return marvelCharacters;
    }


    private MarvelCharacter createMarvelCharacterFromResponseCharacter(Character character) {

        MarvelCharacter marvelCharacter = new MarvelCharacter();
        marvelCharacter.setName(character.getName());
        marvelCharacter.setDescription(character.getDescription());
        marvelCharacter.setId(character.getId());
        marvelCharacter.setComics(character.getComics().getAvailable());
        marvelCharacter.setSeries(character.getSeries().getAvailable());
        marvelCharacter.setStories(character.getStories().getAvailable());


        if (character.getThumbnail() != null) {
            marvelCharacter.setImageURL(character.getThumbnail().getPath() + "." + character.getThumbnail().getExtension());
        }

        return marvelCharacter;
    }
}
