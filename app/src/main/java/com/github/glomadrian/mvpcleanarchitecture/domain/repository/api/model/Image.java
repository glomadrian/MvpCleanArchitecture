package com.github.glomadrian.mvpcleanarchitecture.domain.repository.api.model;

/**
 * @author glomadrian
 */
public class Image {

    private String path;
    private String extension;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
