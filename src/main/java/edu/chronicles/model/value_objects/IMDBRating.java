package edu.chronicles.model.value_objects;

import edu.chronicles.model.exceptions.InvalidIMDBRatingException;

public final class IMDBRating {
    private final float value;

    private static final float MIN = 0;
    private static final float MAX = 10;

    private IMDBRating(float value) {
        this.value = value;
    }

    public static IMDBRating of(float value) {
        if (value < MIN || value > MAX) {
            throw new InvalidIMDBRatingException(value);
        }
        return new IMDBRating(value);
    }

    public float value() {
        return this.value;
    }
}
