package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 3, WS 21/22
 *
 * Problem: Perfect Pth Powers
 * Link: https://open.kattis.com/contests/qkxmff/problems/perfectpowers
 * @author Gordon V. Cormack
 * @author Thorsten Zieres, 1297197
 * @version 1.3, 11/10/2020
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.10
 */
public class PerfectPthPower {
    private static final int MAX_POWER = 50;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long input;
        List<Integer> results = new ArrayList<>();
        while ((input = Long.parseLong(in.nextLine())) != 0) {
            results.add(getMaxPower(input));
        }
        results.forEach(System.out::println);
    }

    public static int getMaxPower(long n) {
        boolean negative = false;

        if (n < 1) {
            negative = true;
            n = -n;
        }

        for (int p = MAX_POWER; p >= 1; p--) {
            double x = Math.pow(n, 1./p);

            if (x - Math.floor(x) < 0.001) {
                if (Math.pow(Math.floor(x), p) == n)
                    if (!negative || p%2==1)
                        return p;
            } else if (Math.floor(x) - x < 0.001) {
                if (Math.pow(Math.ceil(x), p) == n)
                    if (!negative || p%2==1)
                        return p;
            }
        }

        return 1;
    }
}
