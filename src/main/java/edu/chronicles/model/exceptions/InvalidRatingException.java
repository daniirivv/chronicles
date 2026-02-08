package edu.chronicles.model.exceptions;

public class InvalidRatingException extends RuntimeException {
    public InvalidRatingException(Integer rating) {
        super("El número " + rating + " no es válido porque la valoración debe ser un número del 1 al 5.");
    }
}
