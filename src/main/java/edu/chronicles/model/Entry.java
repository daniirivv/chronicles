package edu.chronicles.model;

import java.time.LocalDate;

public abstract class Entry {

    protected String name;
    protected Float rating;
    protected String comments;
    protected final LocalDate entryDate;

    protected Entry(String name, Float rating, String comments, LocalDate entryDate) {
        this.name = name;
        this.rating = rating;
        this.comments = comments;
        this.entryDate = entryDate;
    }

    protected Entry(String name, LocalDate entryDate) {
        this(name, null, "", entryDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
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
