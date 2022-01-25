package week1;

import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 1, WS 21/22
 *
 * Problem: Triangle Area
 * Link: https://open.kattis.com/problems/triarea
 * @author  Johan Sannemo
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 10/26/2020
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.1
 */
public class TriangleArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] heightAndBase = in.nextLine().split(" ");
        System.out.println(0.5 * Integer.parseInt(heightAndBase[0]) * Integer.parseInt(heightAndBase[1]));
    }
}


