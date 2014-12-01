package com.github.glomadrian.mvpcleanarchitecture.domain.repository;

import com.github.glomadrian.mvpcleanarchitecture.domain.model.MarvelCharacter;

import java.util.List;

/**
 * The domain model is different from others resources models, in each case the repository must map
 * the response to a basic model
 *
 * @author glomadrian
 */
<<<<<<< HEAD
public interface ResponseMapper<T> {

    List<MarvelCharacter> mapResponse(T response);
=======
public interface ResponseMapper<From> {

    List<MarvelCharacter> mapResponse(From response);
>>>>>>> 546c101c57264276a397087a22e9847094903ffc
}
