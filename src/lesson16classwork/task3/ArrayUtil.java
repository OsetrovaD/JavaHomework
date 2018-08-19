package lesson16classwork.task3;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ArrayUtil {

    private static final int BOUND_VALUE = 300;
    private static final Random RANDOM = new Random();

    public static int[] createArray(int length) {
        return new int[length];
    }

    public static int[] fillArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = RANDOM.nextInt(BOUND_VALUE) + 1;
        }
        return array;
    }
}
