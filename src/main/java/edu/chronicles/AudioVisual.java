package edu.chronicles;

public class AudioVisual extends MediaEntry {

    public AudioVisual(String name, String creator) {
        super(name, creator);
    }

    public AudioVisual(String name, String creator, int rating, int yearSeen) {
        super(name, creator, rating, yearSeen);
    }

    public int getYearSeen() {
        return yearFinished;
    }

    public void setYearSeen(int yearSeen) {
        this.yearFinished = yearSeen;
    }


}
