package org.example;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RectangleReader { public static List<Rectangle> readRectanglesFromExcel(String filePath) throws IOException {
    List<Rectangle> rectangles = new ArrayList<>();
    FileInputStream file = new FileInputStream(filePath);
    Workbook workbook = new XSSFWorkbook(file);
    Sheet sheet = workbook.getSheetAt(0);

    for (Row row : sheet) {
        if (row.getRowNum() == 0) { // Пропускаем заголовок
            continue;
        }
        double width = row.getCell(0).getNumericCellValue();
        double height = row.getCell(1).getNumericCellValue();
        rectangles.add(new Rectangle(width, height));
    }

    workbook.close();
    file.close();
    return rectangles;
}
}
