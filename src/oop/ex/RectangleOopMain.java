package oop.ex;

public class RectangleOopMain {
    public static void main(String[] args) {
        int width = 5;
        int height = 5;

        Rectangle rectangle = new Rectangle();

        rectangle.calculateArea(width, height);
        rectangle.calculatePerimeter(width, height);
        rectangle.isSquare(width, height);
    }
}
