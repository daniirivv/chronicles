package edu.danilorena.chronicles.logic.models;

import java.time.Year;
import java.util.Objects;

public record BookEntry(
        Long id,
        String title,
        String author,
        Integer pages,
        Year releaseDate,
        boolean completed,
        Rating rating
) {

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BookEntry bookEntry)) return false;
        return Objects.equals(id, bookEntry.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Integer getRatingValue(){
        return this.rating.value();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String title;
        private String author;
        private Integer pages;
        private Year releaseDate;
        private boolean completed;
        private Rating rating;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

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

        public Builder rating(Integer ratingValue) {
            this.rating = new Rating(ratingValue);
            return this;
        }

        public BookEntry build() {
            if(!completed && rating.value() != null) {
                throw new IllegalStateException("Un libro no puede tener valoración si no se ha terminado de leer");
            }

            return new BookEntry(id, title, author, pages, releaseDate, completed, rating);
        }

        @Override
        public String toString() {

            return  "ID: " + this.id + "\n" +
                    "Title: " + this.title + "\n" +
                    "Author: " + this.author + "\n" +
                    "Pages: " + this.pages + "\n" +
                    "ReleaseDate: " + this.releaseDate + "\n" +
                    "Completed: " + this.completed + "\n" +
                    "Rating: " + this.rating + "\n";
        }
    }
}
