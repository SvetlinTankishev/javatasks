import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Square(4));
        shapes.add(new Rectangle(4, 20));
        shapes.add(new Triangle(4,4,4,6,8));
        shapes.add(new Circle(8));

        System.out.println("Sum of areas: " + ShapeOperations.sumAreas(shapes));
        System.out.println("Largest shape: " + ShapeOperations.getLargestShape(shapes).getClass().getSimpleName());
        System.out.println("Sum of perimeters: " + ShapeOperations.sumPerimeters(shapes));
        System.out.println("Sum of circle Perimeters: " + ShapeOperations.sumCirclePerimeters(shapes));

    }
}