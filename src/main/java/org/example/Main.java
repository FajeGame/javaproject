package org.example;

import java.util.ArrayList;
import java.util.List;

// Задание №1
class Button {
    private int clicks = 0;

    public void click() {
        clicks++;
        System.out.println("Number of clicks: " + clicks);
    }
}

// Задание №2
class Balance {
    private int left = 0;
    private int right = 0;

    public void addLeft(int weight) {
        left += weight;
    }

    public void addRight(int weight) {
        right += weight;
    }

    public void result() {
        if (left == right) {
            System.out.println("=");
        } else if (left > right) {
            System.out.println("L");
        } else {
            System.out.println("R");
        }
    }
}

// Задание №3
class Bell {
    private boolean ding = true;

    public void sound() {
        if (ding) {
            System.out.println("ding");
        } else {
            System.out.println("dong");
        }
        ding = !ding;
    }
}

// Задание №4
class OddEvenSeparator {
    private final List<Integer> evenNumbers = new ArrayList<>();
    private final List<Integer> oddNumbers = new ArrayList<>();

    public void addNumber(int number) {
        if (number % 2 == 0) {
            evenNumbers.add(number);
        } else {
            oddNumbers.add(number);
        }
    }

    public void even() {
        System.out.println("Even numbers: " + evenNumbers);
    }

    public void odd() {
        System.out.println("Odd numbers: " + oddNumbers);
    }
}

// Задание №5
class Table {
    private final int[][] data;

    public Table(int rows, int cols) {
        data = new int[rows][cols];
    }

    public int getValue(int row, int col) {
        return data[row][col];
    }

    public void setValue(int row, int col, int value) {
        data[row][col] = value;
    }

    public int rows() {
        return data.length;
    }

    public int cols() {
        return data[0].length;
    }

    public double average() {
        int sum = 0;
        int count = 0;
        for (int[] row : data) {
            for (int cell : row) {
                sum += cell;
                count++;
            }
        }
        return (double) sum / count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : data) {
            for (int cell : row) {
                sb.append(cell).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

// Задание №6 - Пакеты geometry и exceptions
interface Figure {
    double area();
}

// Пакет geometry2d
class Circle implements Figure {
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than zero.");
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle with radius: " + radius;
    }
}

class Rectangle implements Figure {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be greater than zero.");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle with width: " + width + ", height: " + height;
    }
}

// Пакет geometry3d
class Cylinder {
    private final Figure base;
    private final double height;

    public Cylinder(Figure base, double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
        this.base = base;
        this.height = height;
    }

    public double volume() {
        return base.area() * height;
    }

    @Override
    public String toString() {
        return "Cylinder with base: " + base + " and height: " + height;
    }
}

// Пакет exceptions
class InvalidFigureException extends RuntimeException {
    public InvalidFigureException(String message) {
        super(message);
    }
}

class InvalidOperationException extends RuntimeException {
    public InvalidOperationException(String message) {
        super(message);
    }
}

// Демонстрация работы классов
public class Main {
    public static void main(String[] args) {
        // Задание 1: Button
        Button button = new Button();
        button.click();
        button.click();

        // Задание 2: Balance
        Balance balance = new Balance();
        balance.addLeft(10);
        balance.addRight(20);
        balance.result();
        balance.addLeft(10);
        balance.result();

        // Задание 3: Bell
        Bell bell = new Bell();
        bell.sound();
        bell.sound();

        // Задание 4: OddEvenSeparator
        OddEvenSeparator separator = new OddEvenSeparator();
        separator.addNumber(1);
        separator.addNumber(2);
        separator.addNumber(3);
        separator.even();
        separator.odd();

        // Задание 5: Table
        Table table = new Table(2, 2);
        table.setValue(0, 0, 1);
        table.setValue(0, 1, 2);
        table.setValue(1, 0, 3);
        table.setValue(1, 1, 4);
        System.out.println("Table:\n" + table);
        System.out.println("Average: " + table.average());

        // Задание 6: Geometry and exceptions
        try {
            Circle circle = new Circle(5);
            System.out.println(circle);
            System.out.println("Area: " + circle.area());

            Rectangle rectangle = new Rectangle(2, 3);
            System.out.println(rectangle);
            System.out.println("Area: " + rectangle.area());

            Cylinder cylinder = new Cylinder(circle, 10);
            System.out.println(cylinder);
            System.out.println("Volume: " + cylinder.volume());
        } catch (InvalidFigureException e) {
            System.err.println(e.getMessage());
        }
    }
}
