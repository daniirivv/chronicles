package edu.chronicles.logic.exceptions;

import edu.chronicles.state.enums.CompletionState;

public class InvalidStateException extends RuntimeException {
    public InvalidStateException(CompletionState state) {
        super("No puede hacerse una valoración estado en el estado " + state);
    }
}
