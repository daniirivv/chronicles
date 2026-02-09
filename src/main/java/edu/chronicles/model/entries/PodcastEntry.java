package edu.chronicles.model.entries;

import edu.chronicles.model.enums.CompletionState;
import edu.chronicles.model.enums.MODPlatform;
import edu.chronicles.model.value_objects.Rating;
import edu.chronicles.model.exceptions.InvalidStateException;

import java.time.Year;

public class PodcastEntry extends Entry {

    private String podcaster;
    private Year releaseYear;
    private MODPlatform platform;
    private CompletionState completionState;

    public PodcastEntry(String name, Rating rating, String comments, String podcaster, Year releaseYear, MODPlatform platform, CompletionState completionState) {
        super(name, rating, comments);
        this.podcaster = podcaster;
        this.releaseYear = releaseYear;
        this.platform = platform;
        this.completionState = completionState;
    }

    public PodcastEntry(String name) {
        super(name);
        this.podcaster = "";
        this.releaseYear = null;
        this.platform = null;
        this.completionState = CompletionState.PLANEADO;
    }

    @Override
    protected void validateRate() {
        if (completionState != CompletionState.TERMINADO) throw new InvalidStateException(completionState);
    }

    public String getPodcaster() {
        return podcaster;
    }

    public void setPodcaster(String podcaster) {
        this.podcaster = podcaster;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public MODPlatform getPlatform() {
        return platform;
    }

    public void setPlatform(MODPlatform platform) {
        this.platform = platform;
    }

    public CompletionState getCompletionState() {
        return completionState;
    }

    public void setCompletionState(CompletionState completionState) {
        this.completionState = completionState;
    }
}
