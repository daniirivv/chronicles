package edu.chronicles.state.entries;

import edu.chronicles.state.enums.CompletionState;
import edu.chronicles.state.enums.MODPlatform;
import edu.chronicles.logic.exceptions.InvalidStateException;
import edu.chronicles.state.value_objects.UserRating;

import java.time.Year;

public class PodcastEntry extends Entry {

    private String podcaster;
    private Year releaseYear;
    private MODPlatform platform;
    private CompletionState completionState;

    public PodcastEntry(String name, UserRating userRating, String comments, String podcaster, Year releaseYear, MODPlatform platform, CompletionState completionState) {
        super(name, userRating, comments);
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
