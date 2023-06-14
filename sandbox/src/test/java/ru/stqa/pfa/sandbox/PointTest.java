package ru.stqa.pfa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

    @Test
    public void testPoint() {
        Point point1 = new Point(0,3);
        Point point2 = new Point(4, 0);
        Assert.assertEquals(Point.getDistance(point1, point2), 5.0);
    }
}
