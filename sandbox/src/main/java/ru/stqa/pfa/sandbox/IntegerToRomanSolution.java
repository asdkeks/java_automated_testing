package ru.stqa.pfa.sandbox;

import java.util.HashMap;

public class IntegerToRomanSolution {
    public static String intToRoman(int num) {

        HashMap<Integer,String > romans_and_int = new HashMap<>();
        romans_and_int.put(1, "I");
        romans_and_int.put(2, "II");
        romans_and_int.put(3, "III");
        romans_and_int.put(4, "IV");
        romans_and_int.put(5, "V");
        romans_and_int.put(6, "VI");
        romans_and_int.put(7, "VII");
        romans_and_int.put(8, "VIII");
        romans_and_int.put(9, "IX");
        romans_and_int.put(10,"X");
        romans_and_int.put(20,"XX");
        romans_and_int.put(30,"XXX");
        romans_and_int.put(40,"XL");
        romans_and_int.put(50,"L");
        romans_and_int.put(60,"LX");
        romans_and_int.put(70,"LXX");
        romans_and_int.put(80,"LXXX");
        romans_and_int.put(90,"XC");
        romans_and_int.put(100,"C");
        romans_and_int.put(200,"CC");
        romans_and_int.put(300,"CCC");
        romans_and_int.put(400,"CD");
        romans_and_int.put(500,"D");
        romans_and_int.put(600,"DC");
        romans_and_int.put(700,"DCC");
        romans_and_int.put(800,"DCCC");
        romans_and_int.put(900,"CM");
        romans_and_int.put(1000,"M");
        romans_and_int.put(2000,"MM");
        romans_and_int.put(3000,"MMM");
        romans_and_int.put(4000,"MMMM");

        StringBuilder result = new StringBuilder();
        int k = 1;
        int mid = 0;

        while (num > 0) {
            mid = (int) ((num % 10) * Math.pow(10, k-1));
            num /= 10;
            k++;
            if (mid != 0) result.insert(0,romans_and_int.get(mid));
        }
        return result.toString();
    }
}
