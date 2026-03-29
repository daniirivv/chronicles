package edu.chronicles.domain.models;

import java.time.Year;
import java.util.Objects;

public class BookEntry {

    private final String title;
    private final String author;
    private int pages;
    private Year releaseDate;
    private boolean completed;
    private Rating rating;

    public BookEntry(String title,
                     String author,
                     int pages,
                     Year releaseDate,
                     boolean completed,
                     Rating rating) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.releaseDate = releaseDate;
        this.completed = completed;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BookEntry bookEntry)) return false;
        return Objects.equals(title, bookEntry.title) && Objects.equals(author, bookEntry.author) && Objects.equals(releaseDate, bookEntry.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, releaseDate);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Year getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Year releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getRating() {
        return rating.value();
    }

    public void setRating(int rating) {
        this.rating = new Rating(rating);
    }
}
