package week1;

import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 1, WS 21/22
 *
 * Problem: Take Two Stones
 * Link: https://open.kattis.com/contests/kp9a7t/problems/twostones
 * @author  Law Wai Hon
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 10/26/2020
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.1
 */
public class TakeTwoStones {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberStones = Integer.parseInt(in.nextLine());

        if (numberStones % 2 == 0)
            System.out.println("Bob");
        else
            System.out.println("Alice");
    }
}


