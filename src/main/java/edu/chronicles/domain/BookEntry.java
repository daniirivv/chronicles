package edu.chronicles.domain;

import java.time.Year;
import java.util.Objects;

public class BookEntry {

    private String title;
    private String author;
    private int numberOfPages;
    private Year releaseDate;
    private boolean completed;

    public BookEntry(String title,
                     String author,
                     int numberOfPages,
                     Year releaseDate,
                     boolean completed) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.releaseDate = releaseDate;
        this.completed = completed;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
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
}
