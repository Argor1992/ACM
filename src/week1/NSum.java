package week1;

import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 1, WS 21/22
 *
 * Problem: N-sum
 * Link: https://open.kattis.com/problems/nsum
 * @author Johan Sannemo
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 10/26/2020
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.1
 */
public class NSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfIntegers = Integer.parseInt(in.nextLine());
        String[] integers = in.nextLine().split(" ");

        int sum = 0;
        for (int i = 0; i < integers.length; i++) {
            sum += Integer.parseInt(integers[i]);
        }

        System.out.println(sum);
    }
}
