package edu.chronicles.state.entries;

import edu.chronicles.state.enums.CompletionState;
import edu.chronicles.state.enums.Format;
import edu.chronicles.state.enums.LiteratureAward;
import edu.chronicles.logic.exceptions.InvalidNumberOfPagesException;
import edu.chronicles.logic.exceptions.InvalidStateException;
import edu.chronicles.state.value_objects.UserRating;

import java.time.Year;
import java.util.Set;

public class BookEntry extends Entry {

    private String bookTitle;
    private String author;
    private Year releaseYear;
    private Format format;
    private Integer pages;
    private CompletionState completionState;
    private Set<LiteratureAward> receivedAwards;

    public BookEntry(
            Long id,
            String bookTitle,
            String author,
            UserRating userRating,
            String comments,
            Year releaseYear,
            Format format,
            Integer pages,
            CompletionState completionState,
            LiteratureAward receivedAwards) {
        super(id, userRating, comments);
        this.bookTitle = bookTitle;
        this.author = author;
        this.releaseYear = releaseYear;
        this.format = format;
        this.pages = pages;
        this.completionState = completionState;
        this.receivedAwards = Set.of(receivedAwards);
    }

    public BookEntry(Long id, String bookTitle) {
        super(id);
        this.bookTitle = bookTitle;
        this.author = "";
        this.releaseYear = null;
        this.format = null;
        this.pages = null;
        this.completionState = CompletionState.PLANEADO;
        this.receivedAwards = null;
    }

    public BookEntry(Long id,
                     String title,
                     String author,
                     Integer pages,
                     Year year,
                     UserRating rating) {
        this(id, title, author, rating, null, year, null, pages, CompletionState.PLANEADO, null);
    }

    @Override
    protected void validateRate() {
        if (completionState != CompletionState.TERMINADO) throw new InvalidStateException(completionState);
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
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

    public Set<LiteratureAward> getReceivedAwards() {
        return this.receivedAwards;
    }

    public void setReceivedAwards(Set<LiteratureAward> receivedAwards) {
        this.receivedAwards = receivedAwards;
    }

}