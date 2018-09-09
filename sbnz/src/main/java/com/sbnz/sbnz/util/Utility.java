package com.sbnz.sbnz.util;

public class Utility {
    public static int getPercentage(int a, int b) {
        int percentage = (int) (a / (double) b * 100);
        if (percentage < 100)
            return percentage;
        return percentage + b;
    }
}
