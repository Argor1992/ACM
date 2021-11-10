import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HowMany0v2 {
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
        long resultN = getPartialResult(n);
        long resultM = getPartialResult(m - 1);

        System.out.println(resultN);
        System.out.println(resultM);

        return resultN - resultM;
    }

    private static long getPartialResult(long n) {
        if (n == 0) {
            return 1;
        }

        if (n % 9 == 0) {
            return betweenOneAnd9(n);
        }

        long result = 0;
        long temp = n;
        for (long i = (long) 9e18; i >= 9; i/=10) {
            while (temp - i > 0) {
                result += betweenOneAnd9(i) + 1;
                temp -= i;
            }
        }

        for (long i = 1; i <= temp; i++) {
            result += getZeros(i);
        }

        return result;
    }

    private static long betweenOneAnd9(long n) {
        if (n <= 9)
            return 0;
        long n2 = (n-9) / 10;
        return 10 * betweenOneAnd9(n2) + n2;
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
