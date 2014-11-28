package com.github.glomadrian.mvpcleanarchitecture.domain.repository.api.model;

import java.util.Collection;

/**
 * @author glomadrian
 */
public class CharacterDataContainer {

    private int limit;
    private int total;
    private int count;
    private Collection<Character> results;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Collection<Character> getCharacter() {
        return results;
    }

    public void setCharacter(Collection<Character> results) {
        this.results = results;
    }
}
