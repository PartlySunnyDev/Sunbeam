package me.partlysunny.sunbeam;

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
     *
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

    public static float randomBetween(float min, float max) {
        Preconditions.checkArgument(min <= max, "min must be less than or equal to max");
        if (min == max) return min;
        if (min < 0 && max < 0) {
            return -randomBetween(-max, -min);
        }
        if (min < 0) {
            return randomBetween(0, -min + max + 1) + min;
        }
        return random.nextFloat() * (max - min) + min;
    }

    public static double randomBetween(double min, double max) {
        Preconditions.checkArgument(min <= max, "min must be less than or equal to max");
        if (min == max) return min;
        if (min < 0 && max < 0) {
            return -randomBetween(-max, -min);
        }
        if (min < 0) {
            return randomBetween(0, -min + max + 1) + min;
        }
        return random.nextDouble() * (max - min) + min;
    }

    public static long randomBetween(long min, long max) {
        Preconditions.checkArgument(min <= max, "min must be less than or equal to max");
        if (min == max) return min;
        if (min < 0 && max < 0) {
            return -randomBetween(-max, -min);
        }
        if (min < 0) {
            return randomBetween(0, -min + max + 1) + min;
        }
        return random.nextLong() * (max - min) + min;
    }

    public static int randomBetween(int max) {
        return randomBetween(0, max);
    }

    public static String formatComma(String numberString) {
        String[] split = numberString.split("\\.");
        String wholeNumber = split[0];
        String decimal = split.length > 1 ? split[1] : "";
        StringBuilder formatted = new StringBuilder();
        int count = 0;
        for (int i = wholeNumber.length() - 1; i >= 0; i--) {
            formatted.append(wholeNumber.charAt(i));
            count++;
            if (count == 3 && i != 0) {
                formatted.append(",");
                count = 0;
            }
        }
        formatted.reverse();
        if (!decimal.isEmpty()) {
            formatted.append(".").append(decimal);
        }
        return formatted.toString();
    }

    public static String formatComma(int number) {
        return formatComma(String.valueOf(number));
    }
}
