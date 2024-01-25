package static2.ex;

public class Car {
    private String name;
    private static int count;

    public Car(String n) {
        name = n;
        System.out.println("차량 구입, 이름: " + name);
        count++;
    }

    public static void showTotalCars() {
        System.out.println("구매한 차량 수: " + count);
    }
}
