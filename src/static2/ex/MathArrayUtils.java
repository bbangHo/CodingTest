package static2.ex;

import java.util.Arrays;

public class MathArrayUtils {
    private MathArrayUtils() {}

    public static int sum(int[] array) {
        int tmp = 0;
        for(int i : array) {
            tmp += i;
        }
        return tmp;
    }

    public static float average(int[] array) {
        return (float) sum(array) / array.length;
    }

    public static int min(int[] array)  {
        int min = array[0];
        for(int i : array) {
            min = min > i ? i : min;
        }
        return min;
    }

    public static int max(int[] array) {
        int max = array[0];
        for(int i : array) {
            max = max < i ? i : max;
        }
        return max;
    }
}
