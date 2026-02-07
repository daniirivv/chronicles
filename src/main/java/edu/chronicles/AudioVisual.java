package edu.chronicles;

public class AudioVisual extends MediaEntry {

    public AudioVisual(String name, String creator) {
        super(name, creator);
    }

    public AudioVisual(String name, String creator, int punctuation, int yearSeen) {
        super(name, creator, punctuation, yearSeen);
    }

    public int getYearSeen() {
        return yearFinished;
    }

    public void setYearSeen(int yearSeen) {
        this.yearFinished = yearSeen;
    }


}
