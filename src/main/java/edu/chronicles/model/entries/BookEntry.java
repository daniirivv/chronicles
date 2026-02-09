package edu.chronicles.model.entries;

import edu.chronicles.model.LiteratureAward;
import edu.chronicles.model.Format;
import edu.chronicles.model.CompletionState;
import edu.chronicles.model.Rating;
import edu.chronicles.model.exceptions.InvalidNumberOfPagesException;

import java.time.Year;

public class BookEntry extends Entry {

    private String author;
    private Year releaseYear;
    private Format format;
    private Integer pages;
    private CompletionState completionState;
    private LiteratureAward receivedAwards;

    public BookEntry(String title,
                     String author,
                     Rating rating,
                     String comments,
                     Year releaseYear,
                     Format format,
                     Integer pages,
                     CompletionState completionState,
                     LiteratureAward receivedAwards) {
        super(title, rating, comments);
        this.author = author;
        this.releaseYear = releaseYear;
        this.format = format;
        this.pages = pages;
        this.completionState = completionState;
        this.receivedAwards = receivedAwards;
    }

    public BookEntry(String title) {
        super(title);
        this.author = "";
        this.releaseYear = null;
        this.format = null;
        this.pages = null;
        this.completionState = CompletionState.PLANEADO;
        this.receivedAwards = null;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Year getReleaseYear() {
        return this.releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Format getFormat() {
        return this.format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Integer getPages() {
        return this.pages;
    }

    public void setPages(Integer pages) {
        if (pages < 0) throw new InvalidNumberOfPagesException(pages);
        this.pages = pages;
    }

    public CompletionState getState() {
        return this.completionState;
    }

    public void setState(CompletionState completionState) {
        this.completionState = completionState;
    }

    public LiteratureAward getReceivedAwards() {
        return this.receivedAwards;
    }

    public void setReceivedAwards(LiteratureAward receivedAwards) {
        this.receivedAwards = receivedAwards;
    }

}
