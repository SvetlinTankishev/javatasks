import java.util.ArrayList;
import java.util.List;

class ShapeOperations {
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

public class Main {
    public static void main(String[] args) {

        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Square(5));
        shapes.add(new Rectangle(5, 10));
        shapes.add(new Triangle(3,4,5,6,7));
        shapes.add(new Circle(5));

        System.out.println("Sum of areas: " + ShapeOperations.sumAreas(shapes));
        System.out.println("Largest shape: " + ShapeOperations.getLargestShape(shapes).getClass().getSimpleName());
        System.out.println("Sum of perimeters: " + ShapeOperations.sumPerimeters(shapes));
        System.out.println("Sum of circle Perimeters: " + ShapeOperations.sumCirclePerimeters(shapes));

    }
}