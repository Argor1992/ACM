package other;

import java.util.Scanner;

/**
 * Andere Probleme
 *
 * Problem: Reverse
 * Link: https://open.kattis.com/problems/ofugsnuid
 * @author Ómar Högni Guðmarsson
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 10/25/2021
 * Status : Accepted
 * Runtime: 0.98
 */
public class Reverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        int[] numbers = new int[number];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = in.nextInt();
        }

        for (int i = numbers.length-1; i >= 0; i--) {
            System.out.println(numbers[i]);
        }
    }
}
