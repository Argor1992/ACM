package week2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 1, WS 21/22
 *
 * Problem: Three Powers
 * Link: https://open.kattis.com/problems/threepowers
 * @author Piotr Rudnicki
 * @author Thorsten Zieres, 1297197
 * @version 1.3, 11/06/2021
 * Status : Accepted
 * Runtime: 0.24
 */
public class ThreePowers {
    /**
     * Number of elements in S: log x = n because n elements result in 2^n subsets
     * > power set
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BigInteger input = new BigInteger(in.nextLine());
        List<BigInteger> inputs = new ArrayList<>();
        BigInteger max = new BigInteger("0");
        while (!input.equals(new BigInteger("0"))) {
            inputs.add(input);
            if (input.compareTo(max) > 0)
                max = input;
            input = new BigInteger(in.nextLine());
        }

        BigInteger[] set = new BigInteger[getSetSize(max)];
        BigInteger base = new BigInteger("3");
        for (int i = 0; i < set.length; i++) {
            set[i] = base.pow(i);
        }

        for (BigInteger pos : inputs) {
            List<BigInteger> subSet = getSubSetAt(set, pos.subtract(new BigInteger("1")));
            System.out.print("{ ");
            for (int i = 0; i < subSet.size() - 1; i++)
                System.out.print(subSet.get(i) + ", ");
            if (!subSet.isEmpty())
                System.out.print(subSet.get(subSet.size()-1) + " ");
            System.out.println("}");
        }
    }

    private static List<BigInteger> getSubSetAt(BigInteger[] set, BigInteger pos) {
        List<BigInteger> result = new ArrayList<>();

        /*
        goes through all combination:
        0000
        0001
        0010
        0011
        and so on
         */
        for (int j = 0; j < set.length; j++) {
            if ((pos.and(new BigInteger("1").shiftLeft(j))).compareTo(new BigInteger("0")) > 0)
                result.add(set[j]);
        }
        return result;
    }

    public static int getSetSize(BigInteger minPowerSetSize) {
        if (minPowerSetSize.compareTo(new BigInteger(String.valueOf(minPowerSetSize.longValue()))) == 0)
            return (int) Math.ceil(Math.log(minPowerSetSize.longValue()) / Math.log(2));
        long split = minPowerSetSize.sqrt().longValue();
        return (int) Math.ceil((Math.log(split) + Math.log(split)) / Math.log(2));
    }
}


