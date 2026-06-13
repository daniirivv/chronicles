package edu.chronicles.state.entries;

import edu.chronicles.state.value_objects.UserRating;

import java.time.LocalDate;

public abstract class Entry {

    protected final Long id;
    protected UserRating userRating;
    protected String comments;
    protected final LocalDate entryDate;

    protected Entry(Long id, UserRating userRating, String comments) {
        this.id = id;
        this.userRating = userRating;
        this.comments = comments;
        this.entryDate = LocalDate.now();
    }

    protected Entry(Long id) {
        this.id = id;
        this.userRating = null;
        this.comments = null;
        this.entryDate = LocalDate.now();
    }

    public Long getId() {
        return this.id;
    }

    public UserRating getRating() {
        return this.userRating;
    }

    public final void rate(int rating) {
        this.userRating = new UserRating(rating);
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
