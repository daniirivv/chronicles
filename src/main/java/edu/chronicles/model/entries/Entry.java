package edu.chronicles.model.entries;

import edu.chronicles.model.Rating;

import java.time.LocalDate;

public abstract class Entry {

    protected String name;
    protected Rating rating;
    protected String comments;
    protected final LocalDate entryDate;

    protected Entry(String name, Rating rating, String comments) {
        this.name = name;
        this.rating = rating;
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

    public Rating getRating() {
        return this.rating;
    }

    public final void rate(Rating rating) {
        validateRate();
        setRating(rating);
    }

    protected void setRating(Rating rating) {
        this.rating = rating;
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
