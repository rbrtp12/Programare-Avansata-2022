package com.company;

public class Operations {

    public static int digitSum(int a) {
        int sum = 0;
        while (a > 0 || sum > 9) {
            if (a == 0) {
                a = sum;
                sum = 0;
            }
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }
}
