package edu.danilorena.chronicles.logic.models;

public record Rating(Integer value) {

    public static final int MIN_RATING = 1;
    public static final int MAX_RATING = 5;

    // Constructor compacto: no necesita paréntesis ni parámetros
    public Rating {
        if (value != null && (value < MIN_RATING || value > MAX_RATING)) {
            throw new IllegalArgumentException(
                    "La valoración debe estar entre " + MIN_RATING + " y " + MAX_RATING + "."
            );
        }
    }
}