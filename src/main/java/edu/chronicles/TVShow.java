package edu.chronicles;

public class TVShow extends AudioVisual{

    public TVShow(String name, String creator) {
        super(name, creator);
    }

    public String getTitle(){return super.getName();}

}
