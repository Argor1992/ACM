package week1;

import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 1, WS 21/22
 *
 * Problem: Tarifa
 * Link: https://open.kattis.com/contests/kp9a7t/problems/tarifa
 * @author Nikola Dmitrović and Nikola Pintarić
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 10/26/2020
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.1
 */
public class Tarifa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int mbPerMonth = Integer.parseInt(in.nextLine());
        int period = Integer.parseInt(in.nextLine());

        int result = mbPerMonth;
        for (int i = 0; i < period; i++) {
            int usedMb = Integer.parseInt(in.nextLine());
            result -= usedMb;
            result += mbPerMonth;
        }

        System.out.println(result);
    }
}
