package edu.chronicles.model;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

public class MovieEntry extends Entry {

    private String director;
    private Year releaseYear;
    private VODPlatform platform;
    private Float imdbRating;
    private List<Award> receivedAwards;

    public MovieEntry(String title,
                      Float rating,
                      String comments,
                      LocalDate entryDate,
                      String director,
                      Year releaseYear,
                      VODPlatform platform,
                      Float imdbRating,
                      List<Award> receivedAwards) {
        super(title, rating, comments, entryDate);
        this.director = director;
        this.releaseYear = releaseYear;
        this.platform = platform;
        this.imdbRating = imdbRating;
        this.receivedAwards = receivedAwards;
    }

    public MovieEntry(String title, LocalDate entryDate) {
        super(title, entryDate);
        this.platform = null;
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
