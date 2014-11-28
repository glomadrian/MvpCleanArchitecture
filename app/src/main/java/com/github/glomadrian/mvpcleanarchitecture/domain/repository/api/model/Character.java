package com.github.glomadrian.mvpcleanarchitecture.domain.repository.api.model;

/**
 * @author glomadrian
 */
public class Character {

    private int id;
    private String name;
    private String description;
    private Image thumbnail;
    private Comic comics;
    private Serie series;
    private Story stories;

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

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Comic getComics() {
        return comics;
    }

    public void setComics(Comic comics) {
        this.comics = comics;
    }

    public Serie getSeries() {
        return series;
    }

    public void setSeries(Serie series) {
        this.series = series;
    }

    public Story getStories() {
        return stories;
    }

    public void setStories(Story stories) {
        this.stories = stories;
    }
}
