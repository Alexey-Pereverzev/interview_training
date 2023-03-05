package org.example.lesson_01.task3;

public class Square extends Figure implements Geometrical {

    private int aXCoordinate;
    private int aYCoordinate;
    private int bXCoordinate;
    private int bYCoordinate;

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

    public Square(int aXCoordinate, int aYCoordinate, int bXCoordinate, int bYCoordinate) {
        this.aXCoordinate = aXCoordinate;
        this.aYCoordinate = aYCoordinate;
        this.bXCoordinate = bXCoordinate;
        this.bYCoordinate = bYCoordinate;
        this.perimeter = squarePerimeter(aXCoordinate, aYCoordinate, bXCoordinate, bYCoordinate);
        this.area = perimeter * perimeter / 16;
    }

    private double squarePerimeter(int x1, int y1, int x2, int y2) {
        return Math.sqrt(8 * ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));
    }

    @Override
    public void describeMe() {
        System.out.println("Квадрат с диагональю (" + aXCoordinate + "," + aYCoordinate + ") " +
                "- ("+ bXCoordinate + "," + bYCoordinate + ")");
        double centerX = ((double)(aXCoordinate + bXCoordinate)) / 2;
        double centerY = ((double)(aYCoordinate + bYCoordinate)) / 2;
        System.out.println("Центр квадрата: (" + String.format("%.1f",centerX) + ", " + String.format("%.1f",centerY) + ")");
        System.out.println("Периметр: " + String.format("%.2f", perimeter));
        System.out.println("Площадь: " + String.format("%.2f", area));
        System.out.println();
    }
}
