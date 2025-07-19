package com.paravar.practice.practice10.sealedclasses;

public class TestSealedClass {
    public static void main(String[] args) {

        /*
         Sealed classes:-
           - A sealed class explicitly defines which classes can inherit from it using the permits' keyword.
           - The compiler ensures that no other class outside the specified list can extend the sealed class.

           - A permitted subclass must be one of the following:
                final: No further subclassing is allowed.
                non-sealed: Allows further subclassing.
                sealed: Restricts subclassing further.
        * */
        Shape circle = new Circle(5);
        Shape rectangle = new ColoredRectangle(4, 5, "Red");

        System.out.println("Circle Area: " + circle.area());
        System.out.println("Rectangle Area: " + rectangle.area());
    }
}
// Sealed class
abstract sealed class Shape permits Circle, Rectangle {
    public abstract double area();
}

// Final subclass
 final class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Sealed subclass
 sealed class Rectangle extends Shape permits ColoredRectangle {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

// Permitted subclass of Rectangle
 final class ColoredRectangle extends Rectangle {
    private final String color;

    public ColoredRectangle(double width, double height, String color) {
        super(width, height);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}


