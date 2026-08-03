package edu.chronicles.logic.models;

import java.time.Year;
import java.util.Objects;

public record BookEntry(
        String title,
        String author,
        int pages,
        Year releaseDate,
        boolean completed,
        Rating rating
) {


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

    public Year getReleaseDate() {
        return releaseDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Integer getRating() {
        if (this.rating == null) {
            return null;
        }
        return rating.value();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String title;
        private String author;
        private Integer pages;
        private Year releaseDate;
        private boolean completed;
        private Rating rating;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder pages(Integer pages) {
            this.pages = pages;
            return this;
        }

        public Builder releaseDate(Year releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder completed(boolean completed) {
            this.completed = completed;
            return this;
        }

        public Builder rating(Integer rating) {
            this.rating = new Rating(rating);
            return this;
        }

        public BookEntry build() {
            return new BookEntry(title, author, pages, releaseDate, completed, rating);
        }

        @Override
        public String toString() {

            return "Title: " + this.title + "\n" +
                    "Author: " + this.author + "\n" +
                    "Pages: " + this.pages + "\n" +
                    "ReleaseDate: " + this.releaseDate + "\n" +
                    "Completed: " + this.completed + "\n" +
                    "Rating: " + this.rating + "\n";
        }
    }
}
