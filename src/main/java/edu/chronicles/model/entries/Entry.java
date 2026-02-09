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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }
}
