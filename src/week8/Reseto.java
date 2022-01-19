package week8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 8, WS 21/22
 *
 * Problem: Reseto
 * Link: https://open.kattis.com/contests/nytf6n/problems/reseto
 * @author Croatian Open Competition in Informatics
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 12/19/2020
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.1
 */
public class Reseto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        System.out.println(getCrossedOutNumber(n, k));
    }

    private static int getCrossedOutNumber(int n, int k) {
        boolean[] sieve = new boolean[n +1];
        Arrays.fill(sieve, true);

        int timesCrossedOut = 0;

        // not i*i <= sieve.length because otherwise the crossing out stops too soon for this problem
        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i]) {
                timesCrossedOut++;

                if (timesCrossedOut == k) {
                    return i;
                }
                for (int j = i * 2; j < sieve.length; j += i) {
                    if (sieve[j]) {
                        sieve[j] = false;
                        timesCrossedOut++;

                        if (timesCrossedOut == k) {
                            return j;
                        }
                    }
                }
            }
        }

        return 0;
    }
}
