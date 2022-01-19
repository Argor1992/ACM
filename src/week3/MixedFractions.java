package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 3, WS 21/22
 *
 * Problem: Mixed Fractions
 * Link: https://open.kattis.com/contests/qkxmff/problems/mixedfractions
 * @author Michael Zmuda
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 11/10/2020
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.27
 */
public class MixedFractions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split(" ");
        List<String> results = new ArrayList<>();
        while (!input[0].equals("0")) {
            results.add(getMixedFraction(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
            input = in.nextLine().split(" ");
        }

        results.forEach(System.out::println);
    }

    private static String getMixedFraction(int numerator, int denominator) {
        int leading = numerator / denominator;
        numerator %= denominator;

        return String.format("%d %d / %d", leading, numerator, denominator);
    }
}
