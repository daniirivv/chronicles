package edu.chronicles.domain.exceptions;

public class EntryAlreadyExistedException extends RuntimeException {
    public EntryAlreadyExistedException(String message) {
        super(message);
    }
}
