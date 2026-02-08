package edu.chronicles.model.entries;

import edu.chronicles.model.Platform;
import edu.chronicles.model.State;
import edu.chronicles.model.TopicType;

import java.time.LocalDate;
import java.time.Year;

public class CourseEntry extends Entry{

    private Year releaseYear;
    private TopicType topic;
    private Platform platform;
    private State state;

    public CourseEntry(String title,
                       Float rating,
                       String comments,
                       LocalDate entryDate,
                       Year releaseYear,
                       TopicType topic,
                       Platform platform,
                       State state) {
        super(title, rating, comments, entryDate);
        this.releaseYear = releaseYear;
        this.topic = topic;
        this.platform = platform;
        this.state = state;
    }

    public CourseEntry(String title, LocalDate entryDate) {
        super(title, entryDate);
        this.releaseYear = null;
        this.topic = null;
        this.platform = null;
        this.state = State.SIN_COMENZAR;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public TopicType getTopic() {
        return topic;
    }

    public void setTopic(TopicType topic) {
        this.topic = topic;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
