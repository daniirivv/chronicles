package edu.chronicles.model.entries;

import edu.chronicles.model.exceptions.InvalidRatingException;

import java.time.LocalDate;

public abstract class Entry {

    protected String name;
    protected Integer rating;
    protected String comments;
    protected final LocalDate entryDate;

    protected Entry(String name, Integer rating, String comments) {
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        if (rating < 1 || rating > 5) throw new InvalidRatingException(rating);
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
