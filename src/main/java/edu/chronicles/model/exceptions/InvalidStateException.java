package edu.chronicles.model.exceptions;

import edu.chronicles.model.CompletionState;

public class InvalidStateException extends RuntimeException {
    public InvalidStateException(CompletionState state) {
        super("No puede hacerse una valoración estado en el estado " + state);
    }
}
