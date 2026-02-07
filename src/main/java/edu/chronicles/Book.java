package edu.chronicles;

public class Book {
    private final String name;
    private final String author;
    private int punctuation;
    private int yearLastRead;

    public Book(String name, String author, int puntuation, int yearLastRead) {
        this.name = name;
        this.author = author;
        this.punctuation = puntuation;
        this.yearLastRead = yearLastRead;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPunctuation() {
        return punctuation;
    }

    public int getYearLastRead() {
        return yearLastRead;
    }
}
