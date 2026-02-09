package edu.chronicles.model.exceptions;

public class InvalidNumberOfPagesException extends RuntimeException {
    public InvalidNumberOfPagesException(Integer numPages) {
        super(numPages + " no es un número de páginas válido; debe ser mayor que 0");
    }
}
