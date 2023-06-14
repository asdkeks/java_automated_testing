package ru.stqa.pfa.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        Point point1 = new Point(0,3);
        Point point2 = new Point(4, 0);
        System.out.println(point2.getDistance(point1, point2));
    }

}