package edu.chronicles.model;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import edu.chronicles.model.State;

public class TVShowEntry extends Entry{

    private String director;
    private Year releaseYear;
    private VODPlatform platform;
    private State state;
    private Float imdbRating;
    private List<Award> receivedAwards;

    public TVShowEntry(String title,
                       Float rating,
                       String comments,
                       LocalDate entryDate,
                       String director,
                       Year releaseYear,
                       VODPlatform platform,
                       State state,
                       Float imdbRating,
                       List<Award> receivedAwards) {
        super(title, rating, comments, entryDate);
        this.director = director;
        this.releaseYear = releaseYear;
        this.platform = platform;
        this.state = state;
        this.imdbRating = imdbRating;
        this.receivedAwards = receivedAwards;
    }

    public TVShowEntry(String title, LocalDate entryDate) {
        super(title, entryDate);
        this.director = "";
        this.releaseYear = null;
        this.platform = null;
        this.state = State.SIN_COMENZAR;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Float getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Float imdbRating) {
        this.imdbRating = imdbRating;
    }

    public List<Award> getReceivedAwards() {
        return receivedAwards;
    }

    public void setReceivedAwards(List<Award> receivedAwards) {
        this.receivedAwards = receivedAwards;
    }
}
