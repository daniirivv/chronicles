package edu.chronicles.model.entries;

import edu.chronicles.model.Award;
import edu.chronicles.model.Gender;
import edu.chronicles.model.Platform;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

public class VideogameEntry extends Entry{

    private Year releaseYear;
    private Gender gender;
    private String studio;
    private List<Platform> availablePlatforms;
    private List<Award> receivedAwards;

    public VideogameEntry(String name,
                          Float rating,
                          String comments,
                          LocalDate entryDate,
                          Year releaseYear,
                          Gender gender,
                          String studio,
                          List<Platform> availablePlatforms,
                          List<Award> receivedAwards) {
        super(name, rating, comments, entryDate);
        this.releaseYear = releaseYear;
        this.gender = gender;
        this.studio = studio;
        this.availablePlatforms = availablePlatforms;
        this.receivedAwards = receivedAwards;
    }

    public VideogameEntry(String name, LocalDate entryDate) {
        super(name, entryDate);
        this.releaseYear = null;
        this.gender = null;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public List<Platform> getAvailablePlatforms() {
        return availablePlatforms;
    }

    public void setAvailablePlatforms(List<Platform> availablePlatforms) {
        this.availablePlatforms = availablePlatforms;
    }

    public List<Award> getReceivedAwards() {
        return receivedAwards;
    }

    public void setReceivedAwards(List<Award> receivedAwards) {
        this.receivedAwards = receivedAwards;
    }
}
