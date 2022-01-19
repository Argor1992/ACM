package week1;

import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 1, WS 21/22
 *
 * Problem: Planina
 * Link: https://open.kattis.com/contests/kp9a7t/problems/planina
 * @author Marko Ivanković
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 10/26/2020
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.1
 */
public class Planina {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int iterations = in.nextInt();

        int numberOfEdges = 2;
        int increasingBy = 1;
        for (int i = 0; i < iterations; i++) {
            numberOfEdges += increasingBy;
            increasingBy *= 2;
        }

        System.out.println(numberOfEdges*numberOfEdges);
    }
}


