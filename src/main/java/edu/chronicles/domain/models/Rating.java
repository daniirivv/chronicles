package edu.chronicles.domain.models;

public record Rating(int value) {

    public static final int MIN_RATING = 1;
    public static final int MAX_RATING = 5;

    // Constructor compacto: no necesita paréntesis ni parámetros
    public Rating {
        if (value < MIN_RATING || value > MAX_RATING) {
            throw new IllegalArgumentException(
                    "La valoración debe estar entre " + MIN_RATING + " y " + MAX_RATING + "."
            );
        }
    }
}