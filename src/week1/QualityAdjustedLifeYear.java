package week1;

import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 1, WS 21/22
 *
 * Problem: Quality-Adjusted Life-Year
 * Link: https://open.kattis.com/problems/qaly
 * @author Howard Cheng
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 10/26/2021
 * Status : Accepted
 * Runtime: 0.11
 */
public class QualityAdjustedLifeYear {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfPeriods = Integer.parseInt(in.nextLine());

        double result = 0;
        for (int i = 0; i < numberOfPeriods; i++) {
            String input = in.nextLine();
            String[] numbers = input.split(" ");
            result += Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
        }

        System.out.println(result);
    }
}


