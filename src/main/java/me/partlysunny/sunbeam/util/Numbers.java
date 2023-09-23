package me.partlysunny.sunbeam.util;

import com.google.common.base.Preconditions;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class Numbers {

    public static final Random random = ThreadLocalRandom.current();

    private Numbers() {
        throw new AssertionError("Cannot instantiate Numbers");
    }

    /**
     * Returns a random integer between min and max, inclusive.
     * @param min inclusive
     * @param max inclusive
     * @return a random integer between min and max, inclusive
     */
    public static int randomBetween(int min, int max) {
        Preconditions.checkArgument(min <= max, "min must be less than or equal to max");
        if (min == max) return min;
        if (min < 0 && max < 0) {
            return -randomBetween(-max, -min);
        }
        if (min < 0) {
            return randomBetween(0, -min + max + 1) + min;
        }
        return random.nextInt(max - min + 1) + min;
    }

}
