package week1;

import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 1, WS 21/22
 *
 * Problem: Pot
 * Link: https://open.kattis.com/problems/pot
 * @author Nikola Dmitrović
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 10/26/2021
 * Status : Accepted
 * Runtime: 0.1
 */
public class Pot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        int result = 0;
        for (int i = 0; i < n; i++) {
            int currentNumber = Integer.parseInt(in.nextLine());
            int exponent = currentNumber % 10;
            int base = currentNumber/10;
            result += Math.pow(base, exponent);
        }

        System.out.println(result);
    }
}
