package com.github.glomadrian.mpvcleanarchitecture.domain.repository;

import com.github.glomadrian.mpvcleanarchitecture.domain.model.MarvelCharacter;
import com.github.glomadrian.mpvcleanarchitecture.domain.repository.exception.GetCharactersException;

import java.util.Collection;

/**
 * Repository to get marvel information
 *
 * @author glomadrian
 */
public interface MarvelRepository {

    Collection<MarvelCharacter> getCharacterCollection(int limit) throws GetCharactersException;
    Collection<MarvelCharacter> getCharacterCollectionPaginated(int limit, int offset) throws GetCharactersException;

}
