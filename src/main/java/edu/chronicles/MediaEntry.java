package edu.chronicles;

public class MediaEntry {
    protected String name;
    protected String creator;
    protected int punctuation;
    protected int yearSeen;

    public MediaEntry(String name, String creator) {
        this.name = name;
        this.creator = creator;
    }

    public MediaEntry(String name, String creator, int punctuation, int yearSeen) {
        this.name = name;
        this.creator = creator;
        this.punctuation = punctuation;
        this.yearSeen = yearSeen;
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
