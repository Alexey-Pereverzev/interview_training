package org.example.lesson_01.task3;

public class Circle extends Figure implements Geometrical {

    private int xCenterCoordinate;
    private int yCenterCoordinate;
    private int radius;

    public int getXCenterCoordinate() {
        return xCenterCoordinate;
    }

    public void setXCenterCoordinate(int xCenterCoordinate) {
        this.xCenterCoordinate = xCenterCoordinate;
    }

    public int getYCenterCoordinate() {
        return yCenterCoordinate;
    }

    public void setYCenterCoordinate(int yCenterCoordinate) {
        this.yCenterCoordinate = yCenterCoordinate;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Circle(int xCenterCoordinate, int yCenterCoordinate, int radius) {
        this.xCenterCoordinate = xCenterCoordinate;
        this.yCenterCoordinate = yCenterCoordinate;
        this.radius = radius;
        this.perimeter = 2*Math.PI*radius;
        this.area = Math.PI*radius*radius;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getSquare() {
        return area;
    }

    @Override
    public void describeMe() {
        System.out.println("Круг с центром (" + xCenterCoordinate + "," + yCenterCoordinate + ")");
        System.out.println("Радиус: " + radius);
        System.out.println("Длина окружности: " + String.format("%.2f", perimeter));
        System.out.println("Площадь: " + String.format("%.2f", area));
    }
}
