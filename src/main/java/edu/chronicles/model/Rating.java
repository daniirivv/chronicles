package edu.chronicles.model;

import edu.chronicles.model.exceptions.InvalidRatingException;

public final class Rating {
    private final int value;

    private static final int MIN = 1;
    private static final int MAX = 5;

    public Rating(int value) {
        if (value < MIN || value > MAX) {
            throw new InvalidRatingException(value);
        }
        this.value = value;
    }

    public int value() {
        return value;
    }
}
