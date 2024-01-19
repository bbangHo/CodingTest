package static2.ex;

public class MathArrayUtils {

    private MathArrayUtils(){
        // private로 인스턴스 생성을 막는다
    }
    public static int sum(int[]array){
        int sum = 0;
        for (int i : array) {
            sum +=i;
        }
        return sum;
    }

    public static float average(int[]array){
        float avr = (float)sum(array)/array.length;
        return avr;
    }

    public static int min(int[]array) {
        int min = array[0];
        for (int i : array) {
            if (i < min) {
                min = i;
            }

        }
        return min;
    }

    public static int max(int[]array) {
        int max = array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            }


        }
        return max;
    }


}
