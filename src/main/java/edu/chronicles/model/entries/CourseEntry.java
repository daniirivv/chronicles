package edu.chronicles.model.entries;

import edu.chronicles.model.enums.CompletionState;
import edu.chronicles.model.enums.CoursePlatform;
import edu.chronicles.model.enums.Topic;
import edu.chronicles.model.exceptions.InvalidStateException;
import edu.chronicles.model.value_objects.UserRating;

import java.time.Year;

public class CourseEntry extends Entry{

    private Year releaseYear;
    private Topic topic;
    private CoursePlatform platform;
    private CompletionState completionState;

    public CourseEntry(String title,
                       UserRating userRating,
                       String comments,
                       Year releaseYear,
                       Topic topic,
                       CoursePlatform platform,
                       CompletionState completionState) {
        super(title, userRating, comments);
        this.releaseYear = releaseYear;
        this.topic = topic;
        this.platform = platform;
        this.completionState = completionState;
    }

    public CourseEntry(String title) {
        super(title);
        this.releaseYear = null;
        this.topic = null;
        this.platform = null;
        this.completionState = CompletionState.PLANEADO;
    }

    @Override
    protected void validateRate() {
        if (completionState != CompletionState.TERMINADO) throw new InvalidStateException(completionState);
    }

    public Year getReleaseYear() {
        return this.releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Topic getTopic() {
        return this.topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public CoursePlatform getPlatform() {
        return this.platform;
    }

    public void setPlatform(CoursePlatform platform) {
        this.platform = platform;
    }

    public CompletionState getState() {
        return this.completionState;
    }

    public void setState(CompletionState completionState) {
        this.completionState = completionState;
    }
}
