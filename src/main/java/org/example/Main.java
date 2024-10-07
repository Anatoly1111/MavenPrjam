package org.example;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Rectangle> rectangles = RectangleReader.readRectanglesFromExcel("rectangles.xlsx");

            System.out.println("Прямоугольники:");
            rectangles.forEach(System.out::println);

            double averageArea = RectangleUtils.calculateAverageArea(rectangles);
            System.out.println("Средняя площадь: " + averageArea);

            double maxPerimeter = RectangleUtils.findMaxPerimeter(rectangles);
            System.out.println("Максимальный периметр: " + maxPerimeter);

            System.out.println("Сортировка по площади:");
            RectangleUtils.sortByArea(rectangles);
            rectangles.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
