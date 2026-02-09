package edu.chronicles.model.value_objects;

import edu.chronicles.model.exceptions.InvalidRatingException;

public final class Rating {
    private final int value;

    private static final int MIN = 1;
    private static final int MAX = 5;

    private Rating(int value) {
        this.value = value;
    }

    public static Rating of(int value) {
        if (value < MIN || value > MAX) {
            throw new InvalidRatingException(value);
        }
        return new Rating(value);
    }

    public int value() {
        return this.value;
    }
}
