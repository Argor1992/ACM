package week1;

import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 1, WS 21/22
 *
 * Problem: Solving for Carrots
 * Link: https://open.kattis.com/contests/kp9a7t/problems/carrots
 * @author Johan Sannemo and Oskar Werkelin Ahlin
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 10/26/2020
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.1
 */
public class SolvingForCarrots {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(input.split(" ")[1]);
    }
}