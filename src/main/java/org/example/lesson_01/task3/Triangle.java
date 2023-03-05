package org.example.lesson_01.task3;

public class Triangle extends Figure implements Geometrical {

    private int aXCoordinate;
    private int aYCoordinate;
    private int bXCoordinate;
    private int bYCoordinate;
    private int cXCoordinate;
    private int cYCoordinate;

    public int getAXCoordinate() {
        return aXCoordinate;
    }

    public void setAXCoordinate(int aXCoordinate) {
        this.aXCoordinate = aXCoordinate;
    }

    public int getAYCoordinate() {
        return aYCoordinate;
    }

    public void setAYCoordinate(int aYCoordinate) {
        this.aYCoordinate = aYCoordinate;
    }

    public int getBXCoordinate() {
        return bXCoordinate;
    }

    public void setBXCoordinate(int bXCoordinate) {
        this.bXCoordinate = bXCoordinate;
    }

    public int getBYCoordinate() {
        return bYCoordinate;
    }

    public void setBYCoordinate(int bYCoordinate) {
        this.bYCoordinate = bYCoordinate;
    }

    public int getCXCoordinate() {
        return cXCoordinate;
    }

    public void setCXCoordinate(int cXCoordinate) {
        this.cXCoordinate = cXCoordinate;
    }

    public int getCYCoordinate() {
        return cYCoordinate;
    }

    public void setCYCoordinate(int cYCoordinate) {
        this.cYCoordinate = cYCoordinate;
    }

    public Triangle(int aXCoordinate, int aYCoordinate, int bXCoordinate, int bYCoordinate,
                    int cXCoordinate, int cYCoordinate) {
        this.aXCoordinate = aXCoordinate;
        this.aYCoordinate = aYCoordinate;
        this.bXCoordinate = bXCoordinate;
        this.bYCoordinate = bYCoordinate;
        this.cXCoordinate = cXCoordinate;
        this.cYCoordinate = cYCoordinate;
        this.perimeter = tPerimeter(aXCoordinate, aYCoordinate, bXCoordinate, bYCoordinate, cXCoordinate, cYCoordinate);
        this.area = tArea(aXCoordinate, aYCoordinate, bXCoordinate, bYCoordinate, cXCoordinate, cYCoordinate);
    }

    private double tArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5*Math.abs(x1*y2 + x2*y3 + x3*y1 - x2*y1 - x3*y2 - x1*y3);     // Gauss formula
    }

    private double tPerimeter(int x1, int y1, int x2, int y2, int x3, int y3) {
        return  Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)) +                  // Pythagorean theorem
                Math.sqrt((x1-x3)*(x1-x3) + (y1-y3)*(y1-y3)) +
                Math.sqrt((x3-x2)*(x3-x2) + (y3-y2)*(y3-y2));
    }

    @Override
    public void describeMe() {
        System.out.println("Треугольник с вершинами:");
        System.out.println("A: (" + aXCoordinate + "," + aYCoordinate + ")");
        System.out.println("B: (" + bXCoordinate + "," + bYCoordinate + ")");
        System.out.println("C: (" + cXCoordinate + "," + cYCoordinate + ")");
        System.out.println("Периметр: " + String.format("%.2f", perimeter));
        System.out.println("Площадь: " + String.format("%.2f", area));
        System.out.println();
    }
}
