package edu.chronicles.model.entries;

import java.time.Year;
import java.util.List;

import edu.chronicles.model.VideogameAward;
import edu.chronicles.model.CompletionState;

public class TVShowEntry extends Entry{

    private String director;
    private Year releaseYear;
    private VODPlatform platform;
    private CompletionState completionState;
    private Float imdbRating;
    private List<VideogameAward> receivedAwards;

    public TVShowEntry(String title,
                       Float rating,
                       String comments,
                       String director,
                       Year releaseYear,
                       VODPlatform platform,
                       CompletionState completionState,
                       Float imdbRating,
                       List<VideogameAward> receivedAwards) {
        super(title, rating, comments);
        this.director = director;
        this.releaseYear = releaseYear;
        this.platform = platform;
        this.completionState = completionState;
        this.imdbRating = imdbRating;
        this.receivedAwards = receivedAwards;
    }

    public TVShowEntry(String title) {
        super(title);
        this.director = "";
        this.releaseYear = null;
        this.platform = null;
        this.completionState = CompletionState.SIN_COMENZAR;
        this.imdbRating = null;
        this.receivedAwards = null;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public VODPlatform getPlatform() {
        return platform;
    }

    public void setPlatform(VODPlatform platform) {
        this.platform = platform;
    }

    public CompletionState getState() {
        return completionState;
    }

    public void setState(CompletionState completionState) {
        this.completionState = completionState;
    }

    public Float getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Float imdbRating) {
        this.imdbRating = imdbRating;
    }

    public List<VideogameAward> getReceivedAwards() {
        return receivedAwards;
    }

    public void setReceivedAwards(List<VideogameAward> receivedAwards) {
        this.receivedAwards = receivedAwards;
    }
}
