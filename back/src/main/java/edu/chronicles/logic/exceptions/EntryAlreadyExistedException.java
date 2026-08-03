package edu.chronicles.logic.exceptions;

public class EntryAlreadyExistedException extends RuntimeException {
    public EntryAlreadyExistedException(String message) {
        super(message);
    }
}
