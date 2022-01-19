package week1;

import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 1, WS 21/22
 *
 * Problem: Two-sum
 * Link: https://open.kattis.com/contests/kp9a7t/problems/twosum
 * @author  Johan Sannemo
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 10/26/2020
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.1
 */

public class TwoSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] numbers = input.split(" ");
        System.out.println(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
    }
}
