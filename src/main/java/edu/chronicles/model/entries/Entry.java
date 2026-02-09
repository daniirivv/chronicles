package edu.chronicles.model.entries;

import edu.chronicles.model.value_objects.UserRating;

import java.time.LocalDate;

public abstract class Entry {

    protected String name;
    protected UserRating userRating;
    protected String comments;
    protected final LocalDate entryDate;

    protected Entry(String name, UserRating userRating, String comments) {
        this.name = name;
        this.userRating = userRating;
        this.comments = comments;
        this.entryDate = LocalDate.now();
    }

    protected Entry(String name) {
        this(name, null, "");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRating getRating() {
        return this.userRating;
    }

    public final void rate(UserRating userRating) {
        validateRate();
        setRating(userRating);
    }

    protected void setRating(UserRating userRating) {
        this.userRating = userRating;
    }

    protected void validateRate() {}

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDate getEntryDate() {
        return this.entryDate;
    }
}
