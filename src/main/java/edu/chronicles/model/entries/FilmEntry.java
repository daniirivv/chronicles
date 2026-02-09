package edu.chronicles.model.entries;

import edu.chronicles.model.enums.FilmAward;
import edu.chronicles.model.enums.VODPlatform;
import edu.chronicles.model.value_objects.IMDBRating;
import edu.chronicles.model.value_objects.UserRating;

import java.time.Year;
import java.util.List;

public class FilmEntry extends Entry {

    private String director;
    private Year releaseYear;
    private VODPlatform platform;
    private IMDBRating imdbRating;
    private List<FilmAward> receivedAwards;

    public FilmEntry(String title,
                     UserRating userRating,
                     String comments,
                     String director,
                     Year releaseYear,
                     VODPlatform platform,
                     IMDBRating imdbRating,
                     List<FilmAward> receivedAwards) {
        super(title, userRating, comments);
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

    public IMDBRating getImdbRating() {
        return this.imdbRating;
    }

    public void setImdbRating(IMDBRating imdbRating) {
        this.imdbRating = imdbRating;
    }

    public List<FilmAward> getReceivedAwards() {
        return this.receivedAwards;
    }

    public void setReceivedAwards(List<FilmAward> receivedAwards) {
        this.receivedAwards = receivedAwards;
    }
}
