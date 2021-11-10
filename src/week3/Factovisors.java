package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Factovisors {
    private static List<Integer> primes;

    public static void main(String[] args) throws IOException {
        primes = getPrimeNumbers((int)(Math.ceil(Math.sqrt(Integer.MAX_VALUE))));

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        List<String> results = new ArrayList<>();
        String input;
        while ((input = in.readLine()) != null && !input.isEmpty()) {
            String[] values = input.split(" ");

            int n = Integer.parseInt(values[0]);
            int m = Integer.parseInt(values[1]);
            results.add(isDivisible(n, m) ? String.format("%d divides %d!", m, n) : String.format("%d does not divide %d!", m, n));
        }

        results.forEach(System.out::println);
    }

    private static boolean isDivisible(int n, int m) {
        if (m == 0)
            return false;
        if (n == 0)
            return m == 1;

        List<Integer> primeFactors = getPrimeFactors(m);
        int[] nArray = new int[n-1];
        for (int i = 0; i < nArray.length; i++)
            nArray[i] = n - i;

        for (int i = 0; i < primeFactors.size(); i++) {
            int factor = primeFactors.get(i);
            for (int j = 0; j < nArray.length; j++) {
                if (nArray[j] % factor == 0) {
                    nArray[j] /= factor;
                    primeFactors.set(i, 0);
                    break;
                }
            }
        }
        for (Integer factor : primeFactors) {
            if (factor != 0)
                return false;
        }

        return true;
    }

    private static List<Integer> getPrimeFactors(int number) {
        List<Integer> primeFactors = new ArrayList<>();

        int temp = number;
        for (Integer prime : primes) {
            if (prime > number) {
                return primeFactors;
            }

            while (temp % prime == 0) {
                primeFactors.add(prime);
                temp /= prime;
            }
        }

        return primeFactors;
    }

    private static List<Integer> getPrimeNumbers(int max) {
        int min = 2;
        boolean[] sieve = new boolean[max];
        Arrays.fill(sieve, true);

        for (int i = 2; i * i <= max; i++) {
            if (sieve[i]) {
                for (int j = i * i; j < max; j += i)
                    sieve[j] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = min; i < max; i++) {
            if (sieve[i])
                primes.add(i);
        }

        return primes;
    }
}
