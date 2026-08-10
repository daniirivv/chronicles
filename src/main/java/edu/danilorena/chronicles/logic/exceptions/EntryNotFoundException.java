package edu.danilorena.chronicles.logic.exceptions;

import java.util.NoSuchElementException;

public class EntryNotFoundException extends NoSuchElementException {
    public EntryNotFoundException(String message) {
        super(message);
    }
}
