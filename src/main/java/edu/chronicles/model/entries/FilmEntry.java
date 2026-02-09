package edu.chronicles.model.entries;

import edu.chronicles.model.FilmAward;
import edu.chronicles.model.Rating;
import edu.chronicles.model.VODPlatform;

import java.time.Year;
import java.util.List;

public class FilmEntry extends Entry {

    private String director;
    private Year releaseYear;
    private VODPlatform platform;
    private Integer imdbRating;
    private List<FilmAward> receivedAwards;

    public FilmEntry(String title,
                     Rating rating,
                     String comments,
                     String director,
                     Year releaseYear,
                     VODPlatform platform,
                     Integer imdbRating,
                     List<FilmAward> receivedAwards) {
        super(title, rating, comments);
        this.director = director;
        this.releaseYear = releaseYear;
        this.platform = platform;
        this.imdbRating = imdbRating;
        this.receivedAwards = receivedAwards;
    }

    public FilmEntry(String title) {
        super(title);
        this.platform = null;
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

    public Integer getImdbRating() {
        return this.imdbRating;
    }

    public void setImdbRating(Integer imdbRating) {
        this.imdbRating = imdbRating;
    }

    public List<FilmAward> getReceivedAwards() {
        return this.receivedAwards;
    }

    public void setReceivedAwards(List<FilmAward> receivedAwards) {
        this.receivedAwards = receivedAwards;
    }
}
