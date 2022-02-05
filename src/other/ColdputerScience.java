package other;

import java.util.Scanner;

/**
 * Andere Probleme
 *
 * Problem: Cold-puter Science
 * Link: https://open.kattis.com/problems/cold
 * @author  University of Chicago
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 10/25/2021
 * Status : Accepted
 * Runtime: 0.10
 */
public class ColdputerScience {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfTemperatures = Integer.parseInt(in.nextLine());
        String[] temperatures = in.nextLine().split(" ");

        int count = 0;
        for (int i = 0; i < temperatures.length; i++) {
            if (Integer.parseInt(temperatures[i]) < 0)
                count++;
        }
        System.out.println(count);
    }
}
