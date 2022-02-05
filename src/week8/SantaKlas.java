package week8;

import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 8, WS 21/22
 *
 * Problem: Santa Klas
 * Link: https://open.kattis.com/problems/santaklas
 * @author Oskar Werkelin Ahlin
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 12/19/2021
 * Status : Accepted
 * Runtime: 0.1
 */
public class SantaKlas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        int altitude = Integer.parseInt(inputs[0]);
        int angle = Integer.parseInt(inputs[1]);

        if (angle >= 0 && angle <= 180) {
            System.out.println("safe");
        } else {
            int alpha = 360 - angle;
            System.out.println((int) (altitude/(Math.sin(alpha * Math.PI / 180)))); //degreesToRadians, sin(alpha) = altitude / c
        }
    }
}
