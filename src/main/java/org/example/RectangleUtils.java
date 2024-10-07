package org.example;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;


public class RectangleUtils {

    public static double calculateAverageArea(List<Rectangle> rectangles) {
        OptionalDouble average = rectangles.stream()
                .mapToDouble(Rectangle::getArea)
                .average();
        return average.orElse(0);
    }

    public static double findMaxPerimeter(List<Rectangle> rectangles) {
        return rectangles.stream()
                .mapToDouble(Rectangle::getPerimeter)
                .max()
                .orElse(0);
    }

    public static List<Rectangle> sortByArea(List<Rectangle> rectangles) {
        rectangles.sort(Comparator.comparingDouble(Rectangle::getArea));
        return rectangles;
    }
}
