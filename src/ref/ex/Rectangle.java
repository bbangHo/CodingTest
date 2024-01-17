package ref.ex;

public class Rectangle {
    int area;
    int perimeter;
    boolean square;

    public void calculateArea(int width, int height) {
        area = width * height;
        System.out.println("넓이: " + area);
    }

    public void calculatePerimeter(int width, int height) {
        perimeter = 2 * (width + height);
        System.out.println("둘레 길이: " + perimeter);
    }

    public void isSquare(int width, int height) {
        square = width == height;
        System.out.println("정사각형 여부: " + square);
    }
}
