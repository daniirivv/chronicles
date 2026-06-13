package edu.chronicles.state.value_objects;

import edu.chronicles.logic.exceptions.InvalidRatingException;

public final class UserRating {
    private final int value;

    private static final int MIN = 1;
    private static final int MAX = 5;

    public UserRating(int value) {
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
