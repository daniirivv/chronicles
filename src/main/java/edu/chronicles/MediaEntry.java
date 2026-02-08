package edu.chronicles;

public class MediaEntry {
    protected String name;
    protected String creator;
    protected int rating;
    protected int yearFinished;

    public MediaEntry(String name, String creator) {
        this.name = name;
        this.creator = creator;
    }

    public MediaEntry(String name, String creator, int rating, int yearFinished) {
        this.name = name;
        this.creator = creator;
        this.rating = rating;
        this.yearFinished = yearFinished;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
