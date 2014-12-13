package com.github.glomadrian.mvpcleanarchitecture.domain.model;

import org.parceler.Parcel;

/**
 * Parcel is a library to manage parcelable in a easy way, for default serialization
 * is necessary to avoid private fields if you want to use proguard
 *
 * @author glomadrian
 */
@Parcel
public class MarvelCharacter {

    int id;
    String name;
    String description;
    String imageURL;
    int comics;
    int stories;
    int series;


    public MarvelCharacter() {
    }

    public MarvelCharacter(int id, String name, String description, String imageURL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getComics() {
        return comics;
    }

    public void setComics(int comics) {
        this.comics = comics;
    }

    public int getStories() {
        return stories;
    }

    public void setStories(int stories) {
        this.stories = stories;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
