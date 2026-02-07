package edu.chronicles;

public class Book extends MediaEntry {
    private int numberOfPages;

    public Book(String name, String creator, int punctuation, int yearSeen, int numberOfPages) {
        super(name, creator, punctuation, yearSeen);
        this.numberOfPages = numberOfPages;
    }

    public Book(String name, String creator, int numberOfPages) {
        super(name, creator);
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return creator;
    }

    public String setAuthor(String author) {
        return this.creator = author;
    }

    public int getYearRead() {
        return yearFinished;
    }

    public void setYearRead(int yearRead) {
        this.yearFinished = yearRead;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
