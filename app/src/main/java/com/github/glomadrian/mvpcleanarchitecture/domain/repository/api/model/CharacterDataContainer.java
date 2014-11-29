package com.github.glomadrian.mvpcleanarchitecture.domain.repository.api.model;

import java.util.List;

/**
 * @author glomadrian
 */
public class CharacterDataContainer {

    private int limit;
    private int total;
    private int count;
    private List<Character> results;

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

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }
}
