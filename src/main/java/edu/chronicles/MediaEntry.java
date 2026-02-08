package edu.chronicles;

public abstract class MediaEntry {
    protected final String name;
    protected final String creator;
    protected int rating;
    protected int yearFinished;

    protected MediaEntry(String name, String creator) {
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
        return this.name;
    }

    public String getCreator() { return this.creator; }

    public int getRating() { return this.rating; }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
