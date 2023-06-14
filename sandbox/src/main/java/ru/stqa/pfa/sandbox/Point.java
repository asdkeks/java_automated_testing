package ru.stqa.pfa.sandbox;

public class Point {

    double xCoordinate;
    double yCoordinate;
    public Point (double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public static double getDistance(Point point1, Point point2){
        return Math.sqrt(Math.pow((point1.xCoordinate - point2.xCoordinate), 2) + Math.pow((point1.yCoordinate - point2.yCoordinate),2));
    }
}
