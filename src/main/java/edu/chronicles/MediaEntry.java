package edu.chronicles;

public class MediaEntry {
    protected String name;
    protected String creator;
    protected int punctuation;
    protected int yearFinished;

    public MediaEntry(String name, String creator) {
        this.name = name;
        this.creator = creator;
    }

    public MediaEntry(String name, String creator, int punctuation, int yearFinished) {
        this.name = name;
        this.creator = creator;
        this.punctuation = punctuation;
        this.yearFinished = yearFinished;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(int punctuation) {
        this.punctuation = punctuation;
    }
}
