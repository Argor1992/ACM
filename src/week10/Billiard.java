package week10;

import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 10, WS 21/22
 *
 * Problem: Billiard
 * Link: https://open.kattis.com/problems/billiard
 * @author Gordon V. Cormack
 * @author Thorsten Zieres, 1297197
 * @version 1.1, 01/24/2022
 * Status : Accepted
 * Runtime: 0.15
 */
public class Billiard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // a = horizontal side
        // b = vertical side
        // s = time the ball returns to the middle
        // m = bounces on vertical side
        // n = bounces on horizontal side
        int horizontal, vertical, seconds, verticalBounces, horizontalBounces;

        while (true) {
            String[] input = in.nextLine().split(" ");
            if (input[0].equals("0")) break;
            horizontal = Integer.parseInt(input[0]);
            vertical = Integer.parseInt(input[1]);
            seconds = Integer.parseInt(input[2]);
            verticalBounces = Integer.parseInt(input[3]);
            horizontalBounces = Integer.parseInt(input[4]);

            double distX = horizontal * verticalBounces;
            double distY = vertical * horizontalBounces;

            double dist_total = Math.sqrt(distX * distX + distY * distY);
            double velocity = dist_total / seconds;
            double angle = 180. * Math.acos(distX / dist_total) / Math.PI;

            System.out.printf("%.2f %.2f\n", angle, velocity);
        }
    }
}
