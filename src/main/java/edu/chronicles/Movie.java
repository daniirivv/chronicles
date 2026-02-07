package edu.chronicles;

public class Movie extends AudioVisual {

    public Movie(String name, String creator) {
        super(name, creator);
    }

    public Movie(String name, String creator, int punctuation, int yearSeen) {
        super(name, creator, punctuation, yearSeen);
    }

    public String getDirector() {
        return creator;
    }

    public void setDirector(String director) {
        this.creator = director;
    }
}
