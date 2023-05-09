import java.util.List;

public class ShapeOperations {
    public static double sumAreas(List<Shape> shapes) {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.calculateArea();
        }
        return sum;
    }

    public static Shape getLargestShape(List<Shape> shapes) {
        Shape largestShape = null;
        double largestArea = Double.NEGATIVE_INFINITY;
        for (Shape shape : shapes) {
            double area = shape.calculateArea();
            if (area > largestArea) {
                largestArea = area;
                largestShape = shape;
            }
        }
        return largestShape;
    }

    public static double sumPerimeters(List<Shape> shapes) {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.calculatePerimeter();
        }
        return sum;
    }

    public static double sumCirclePerimeters(List<Shape> shapes) {
        double sum = 0;
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                sum += shape.calculatePerimeter();
            }
        }
        return sum;
    }
}
