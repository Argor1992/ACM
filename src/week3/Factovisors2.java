package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Factovisors2 {
    private static List<Integer> primes;
    private static final Map<Long, List<Long>> primeFactors = new HashMap<>();

    public static void main(String[] args) throws IOException {
        primes = getPrimeNumbers((int)(Math.ceil(Math.sqrt(Integer.MAX_VALUE))));

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        List<String> results = new ArrayList<>();
        String input;
        while ((input = in.readLine()) != null && !input.isEmpty()) {
            String[] values = input.split(" ");

            long n = Long.parseLong(values[0]);
            long m = Long.parseLong(values[1]);
            results.add(isDivisible(n, m) ? String.format("%d divides %d!", m, n) : String.format("%d does not divide %d!", m, n));
        }

        results.forEach(System.out::println);
    }

    private static boolean isDivisible(long n, long m) {
        if (m == 0)
            return false;
        if (n == 0)
            return m == 1;

        List<Long> primeFactors = getPrimeFactors(m);
        Map<Long, Long> dividedPlaces = new HashMap<>();

        for (int i = 0; i < primeFactors.size(); i++) {
            long factor = primeFactors.get(i);
            for (long j = 0; j < n; j++) {
                if (dividedPlaces.get(j) == null) {
                    if ((n-j) % factor == 0) {
                        dividedPlaces.put(j, (n-j) / factor);
                        primeFactors.set(i, 0L);
                        break;
                    }
                } else {
                   if (dividedPlaces.get(j) % factor == 0) {
                       dividedPlaces.replace(j, dividedPlaces.get(j) / factor);
                       primeFactors.set(i, 0L);
                       break;
                   }
                }
            }
        }
        for (Long factor : primeFactors) {
            if (factor != 0)
                return false;
        }

        return true;
    }

    private static List<Long> getPrimeFactors(long number) {
        if (primeFactors.get(number) != null)
            return primeFactors.get(number);

        List<Long> result = new ArrayList<>();

        long temp = number;
        for (Integer prime : primes) {
            if (prime > number) {
                primeFactors.put(number, result);
                return result;
            }

            while (temp % prime == 0) {
                result.add((long) prime);
                temp /= prime;
            }
        }

        if (result.isEmpty()) {
            result.add(number);
        }

        primeFactors.put(number, result);
        return result;
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
