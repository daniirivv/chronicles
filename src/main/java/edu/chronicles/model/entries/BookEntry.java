package edu.chronicles.model.entries;

import edu.chronicles.model.Award;
import edu.chronicles.model.Format;
import edu.chronicles.model.State;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

public class BookEntry extends Entry {

    private String author;
    private Year releaseYear;
    private Format format;
    private Integer pages;
    private State state;
    private List<Award> receivedAwards;

    public BookEntry(String title,
                     String author,
                     Float rating,
                     String comments,
                     Year releaseYear,
                     Format format,
                     Integer pages,
                     State state,
                     List<Award> receivedAwards) {
        super(title, rating, comments);
        this.author = author;
        this.releaseYear = releaseYear;
        this.format = format;
        this.pages = pages;
        this.state = state;
        this.receivedAwards = receivedAwards;
    }

    public BookEntry(String title) {
        super(title);
        this.author = "";
        this.releaseYear = null;
        this.format = null;
        this.pages = null;
        this.state = State.SIN_COMENZAR;
        this.receivedAwards = null;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Award> getReceivedAwards() {
        return receivedAwards;
    }

    public void setReceivedAwards(List<Award> receivedAwards) {
        this.receivedAwards = receivedAwards;
    }

}
