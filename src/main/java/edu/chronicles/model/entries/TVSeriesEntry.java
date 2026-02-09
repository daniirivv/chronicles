package edu.chronicles.model.entries;

import java.time.Year;
import java.util.List;

import edu.chronicles.model.Rating;
import edu.chronicles.model.TVSeriesAward;
import edu.chronicles.model.VODPlatform;
import edu.chronicles.model.CompletionState;

public class TVSeriesEntry extends Entry{

    private String director;
    private Year releaseYear;
    private VODPlatform platform;
    private CompletionState completionState;
    private Integer imdbRating;
    private List<TVSeriesAward> receivedAwards;

    public TVSeriesEntry(String title,
                         Rating rating,
                         String comments,
                         String director,
                         Year releaseYear,
                         VODPlatform platform,
                         CompletionState completionState,
                         Integer imdbRating,
                         List<TVSeriesAward> receivedAwards) {
        super(title, rating, comments);
        this.director = director;
        this.releaseYear = releaseYear;
        this.platform = platform;
        this.completionState = completionState;
        this.imdbRating = imdbRating;
        this.receivedAwards = receivedAwards;
    }

    public TVSeriesEntry(String title) {
        super(title);
        this.director = "";
        this.releaseYear = null;
        this.platform = null;
        this.completionState = CompletionState.PLANEADO;
        this.imdbRating = null;
        this.receivedAwards = null;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Year getReleaseYear() {
        return this.releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public VODPlatform getPlatform() {
        return this.platform;
    }

    public void setPlatform(VODPlatform platform) {
        this.platform = platform;
    }

    public CompletionState getState() {
        return this.completionState;
    }

    public void setState(CompletionState completionState) {
        this.completionState = completionState;
    }

    public Integer getImdbRating() {
        return this.imdbRating;
    }

    public void setImdbRating(Integer imdbRating) {
        this.imdbRating = imdbRating;
    }

    public List<TVSeriesAward> getReceivedAwards() {
        return this.receivedAwards;
    }

    public void setReceivedAwards(List<TVSeriesAward> receivedAwards) {
        this.receivedAwards = receivedAwards;
    }
}
