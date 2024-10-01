package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testButtonClicks() {
        Button button = new Button();
        button.click();  // Проверка вывода вручную
        button.click();  // Проверка вывода вручную
    }

    @Test
    void testBalance() {
        Balance balance = new Balance();
        balance.addLeft(10);
        balance.addRight(20);
        balance.result();  // Проверка вывода вручную (должно быть "R")
        balance.addLeft(10);
        balance.result();  // Проверка вывода вручную (должно быть "=")
    }

    @Test
    void testBell() {
        Bell bell = new Bell();
        bell.sound();  // Проверка вывода вручную (должно быть "ding")
        bell.sound();  // Проверка вывода вручную (должно быть "dong")
    }

    @Test
    void testOddEvenSeparator() {
        OddEvenSeparator separator = new OddEvenSeparator();
        separator.addNumber(1);
        separator.addNumber(2);
        separator.addNumber(3);

        separator.even();  // Проверка вывода вручную (должно быть "2")
        separator.odd();   // Проверка вывода вручную (должно быть "1, 3")
    }

    @Test
    void testTable() {
        Table table = new Table(2, 2);
        table.setValue(0, 0, 1);
        table.setValue(0, 1, 2);
        table.setValue(1, 0, 3);
        table.setValue(1, 1, 4);

        assertEquals(1, table.getValue(0, 0));
        assertEquals(4, table.getValue(1, 1));
        assertEquals(2, table.cols());
        assertEquals(2, table.rows());
        assertEquals(2.5, table.average());
    }

    @Test
    void testCircleArea() {
        Circle circle = new Circle(5);
        assertEquals(5 * 5 * Math.PI, circle.area());
    }

    @Test
    void testRectangleArea() {
        Rectangle rectangle = new Rectangle(2, 3);
        assertEquals(6, rectangle.area());
    }

    @Test
    void testCylinderVolume() {
        Circle circle = new Circle(5);
        Cylinder cylinder = new Cylinder(circle, 10);
        assertEquals(5 * 5 * Math.PI * 10, cylinder.volume());
    }
}
