package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * FRANKFURT UAS EXERCISES WEEK 4, WS 21/22
 *
 * Problem: How Many Digits?
 * Link: https://open.kattis.com/problems/howmanydigits
 * @author  Greg Hamerly
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 11/20/2021
 * Status : Accepted
 * Runtime: 0.24
 */
public class HowManyDigits {
    /**
     * Stirlingformel als Näherung der Fakultät: sqrt(2*pi*n)*(n/e)^n
     * Davon kann man dann den log10 nehmen um die Stellen zu ermitteln:
     *
     * k-1 <= log(n!) < k
     * k-1 <= 1/2log(2*pi*n) + nlog(n/e)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> results = new ArrayList<>();
        String input;
        while ((input = in.readLine()) != null && !input.isEmpty()) {
            results.add(getNumberOfDigits(Integer.parseInt(input)));
        }

        results.forEach(System.out::println);
    }

    private static int getNumberOfDigits(int n) {
        if (n == 0 || n == 1)
            return 1;
        double m = 0.5 * Math.log10(2*Math.PI*n) + n * Math.log10(n / Math.E);
        return (int) Math.ceil(m);
    }
}
