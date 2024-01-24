package static2.ex;

public class MathArrayUtils {
    //private static int sum;
    //private static int average;
    //private static int min;
    //private static int max;  //클래스 변수를 선언해서 할랬는데 아니였다

    private MathArrayUtils(){} //이렇게 막는 건 생각 못했다

    public static int sum(int[] values){
        int total = 0;
        for(int i = 0; i < values.length; i++){
            total += values[i];
        }
        return total;
    }
    public static double average(int[] values){
        return (double) sum(values) / values.length;
    }
    public static int min(int[] values){
        int minValue = values[0];
        for(int i = 1; i < values.length; i++){ //0부터가 아니고 1부터 돌린다
            if(minValue > values[i]){
                minValue = values[i];
            }
        }
        return minValue;
    }
    public static int max(int[] values){
        int maxValue = values[0];
        for(int i = 1; i < values.length; i++){
            if(maxValue < values[i]){
                maxValue = values[i];
            }
        }
        return maxValue;
    }
}
