package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HowMany0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split(" ");
        List<Long> results = new ArrayList<>();
        while (Long.parseLong(input[0]) > -1 && Long.parseLong(input[1]) > -1) {
            results.add(computeResult(Long.parseLong(input[0]), Long.parseLong(input[1])));
            input = in.nextLine().split(" ");
        }
        results.forEach(System.out::println);
    }

    private static long computeResult(long m, long n) {
        long result = 0;
        for (long i = m; i <= n; i++) {
            result += getZeros(i);
        }
        return result;
    }

    private static int getZeros(long number) {
        String s1 = String.valueOf(number);

        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '0')
                count++;
        }
        return count;
    }
}
