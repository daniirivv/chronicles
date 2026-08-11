package edu.danilorena.chronicles.display.dtos;

import java.time.Year;

public record BookResponseDto(
        Long id,
        String title,
        String author,
        Integer pages,
        Year releaseDate,
        Boolean completed,
        Integer rating
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String title;
        private String author;
        private Integer pages;
        private Year releaseDate;
        private Boolean completed;
        private Integer rating;

        public Builder id(Long id) {
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

        public Builder rating(Integer rating) {
            this.rating = rating;
            return this;
        }

        public BookResponseDto build() {
            return new BookResponseDto(id, title, author, pages, releaseDate, completed, rating);
        }
    }
}