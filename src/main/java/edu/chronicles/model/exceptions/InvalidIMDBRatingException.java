package edu.chronicles.model.exceptions;

public class InvalidIMDBRatingException extends RuntimeException {
    public InvalidIMDBRatingException(Float IMDBRating) {
        super(IMDBRating + " no es válido; debe ser un número entre 0 y 10");
    }
}
