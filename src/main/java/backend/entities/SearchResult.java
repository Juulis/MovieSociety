package backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResult {
    @JsonProperty("Search")
    private Movie[] searchArray;

    public SearchResult() {
    }

    public Movie[] getSearchArray() {
        return searchArray;
    }

    public void setSearchArray(Movie[] searchArray) {
        this.searchArray = searchArray;
    }
}
