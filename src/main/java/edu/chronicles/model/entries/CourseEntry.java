package edu.chronicles.model.entries;

import edu.chronicles.model.CompletionState;
import edu.chronicles.model.CoursePlatform;
import edu.chronicles.model.Rating;
import edu.chronicles.model.Topic;

import java.time.Year;

public class CourseEntry extends Entry{

    private Year releaseYear;
    private Topic topic;
    private CoursePlatform platform;
    private CompletionState completionState;

    public CourseEntry(String title,
                       Rating rating,
                       String comments,
                       Year releaseYear,
                       Topic topic,
                       CoursePlatform platform,
                       CompletionState completionState) {
        super(title, rating, comments);
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
