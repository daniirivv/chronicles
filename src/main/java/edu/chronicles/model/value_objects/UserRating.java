package edu.chronicles.model.value_objects;

import edu.chronicles.model.exceptions.InvalidRatingException;

public final class UserRating {
    private final int value;

    private static final int MIN = 1;
    private static final int MAX = 5;

    private UserRating(int value) {
        this.value = value;
    }

    public static UserRating of(int value) {
        if (value < MIN || value > MAX) {
            throw new InvalidRatingException(value);
        }
        return new UserRating(value);
    }

    public int value() {
        return this.value;
    }
}
