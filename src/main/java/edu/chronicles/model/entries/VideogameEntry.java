package edu.chronicles.model.entries;

import edu.chronicles.model.VideogameAward;
import edu.chronicles.model.VideogameGenderType;
import edu.chronicles.model.VideogamePlatform;

import java.time.Year;
import java.util.List;

public class VideogameEntry extends Entry{

    private Year releaseYear;
    private VideogameGenderType videogameGenderType;
    private String studio;
    private List<VideogamePlatform> availablePlatforms;
    private List<VideogameAward> receivedAwards;

    public VideogameEntry(String name,
                          Integer rating,
                          String comments,
                          Year releaseYear,
                          VideogameGenderType videogameGenderType,
                          String studio,
                          List<VideogamePlatform> availablePlatforms,
                          List<VideogameAward> receivedAwards) {
        super(name, rating, comments);
        this.releaseYear = releaseYear;
        this.videogameGenderType = videogameGenderType;
        this.studio = studio;
        this.availablePlatforms = availablePlatforms;
        this.receivedAwards = receivedAwards;
    }

    public VideogameEntry(String name) {
        super(name);
        this.releaseYear = null;
        this.videogameGenderType = null;
        this.studio = null;
        this.availablePlatforms = null;
        this.receivedAwards = null;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public VideogameGenderType getGender() {
        return videogameGenderType;
    }

    public void setGender(VideogameGenderType videogameGenderType) {
        this.videogameGenderType = videogameGenderType;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public List<VideogamePlatform> getAvailablePlatforms() {
        return availablePlatforms;
    }

    public void setAvailablePlatforms(List<VideogamePlatform> availablePlatforms) {
        this.availablePlatforms = availablePlatforms;
    }

    public List<VideogameAward> getReceivedAwards() {
        return receivedAwards;
    }

    public void setReceivedAwards(List<VideogameAward> receivedAwards) {
        this.receivedAwards = receivedAwards;
    }
}
