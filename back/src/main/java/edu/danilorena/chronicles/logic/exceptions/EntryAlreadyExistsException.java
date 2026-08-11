package edu.danilorena.chronicles.logic.exceptions;

public class EntryAlreadyExistsException extends RuntimeException {
    public EntryAlreadyExistsException(String message) {
        super(message);
    }
}
