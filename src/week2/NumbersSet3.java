package week2;

import java.util.*;

public class NumbersSet3 {
    private static List<Integer> primes;
    private static Map<Integer, List<Integer>> primeFactors = new HashMap<>();

    public static void main(String[] args) {
        primes = getPrimeNumbers(10000);

        Scanner in = new Scanner(System.in);
        int cases = Integer.parseInt(in.nextLine());

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < cases; i++) {
            String[] input = in.nextLine().split(" ");
            results.add(solve(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])));
        }


        int i = 1;
        for (Integer result : results)
            System.out.println("Case #" + (i++) + ": " + result);
    }

    private static int solve(int a, int b, int p) {
        int[] sets = new int[b+1];
        Arrays.fill(sets, -1);

        for (int i = a; i <= b; i++) {
            for (int j = i + 1; j <= b; j++) {
                System.out.println("Values: " + i + " " + j);
                Arrays.stream(sets).forEach(value -> System.out.print(value + " "));
                System.out.println();
                if (havePrimeFactor(i, j, p)) {
                    join(sets, i, j);
                    Arrays.stream(sets).forEach(value -> System.out.print(value + " "));
                    System.out.println();
                }
            }
        }

        int numberOfSets = 0;
        for(int i = a; i <= b; i++) {
            if(sets[i] == -1) {
                numberOfSets++;
            }
        }

        return numberOfSets;
    }

    private static void join(int[] sets, int i, int j) {
        System.out.println("Join: " + i + " " + j);
        int a = find(sets, i);
        int b = find(sets, j);
        if(a == b) return;
        sets[a] = b;
    }

    private static int find(int[] sets, int a) {
        System.out.println("Find: " + a);
        if(sets[a] == -1) {
            System.out.println("Found: " + a);
            return a;
        }
        return sets[a] = find(sets, sets[a]);
    }

    private static boolean havePrimeFactor(int a, int b, int p) {
        List<Integer> factorsA = getPrimeFactors(a);
        List<Integer> factorsB = getPrimeFactors(b);

        for (Integer factor : factorsA)
            if (factor >= p && factorsB.contains(factor))
                return true;

        return false;
    }

    private static List<Integer> getPrimeFactors(int a) {
        if (primeFactors.get(a) != null)
            return primeFactors.get(a);

        List<Integer> result = new ArrayList<>();

        int n = a;
        for (int i = 0; i < primes.size(); i++) {
            if (primes.get(i) > n) {
                primeFactors.put(a, result);
                return result;
            }

            if (n % primes.get(i) == 0) {
                result.add(primes.get(i));
                n /= primes.get(i);
            }
        }

        primeFactors.put(a, result);
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
