package ru.stqa.pfa.sandbox;

public class SqrtXSolution {

    public int mySqrt(int x) {
        double t;
        double sqrt = (double) x / 2;
        if (x == 0) return 0;
        do {
            t = sqrt;
            sqrt = (t + (x/t)) / 2;
        } while (t - sqrt != 0);

        return (int) sqrt;
    }

}
