package other;

import java.util.Scanner;

/**
 * Andere Probleme
 *
 * Problem: FizzBuzz
 * Link: https://open.kattis.com/problems/fizzbuzz
 * @author Darko Aleksic
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 10/25/2020
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.10
 */
public class FizzBuzz {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] numbers = input.split(" ");

        int number1 = Integer.parseInt(numbers[0]);
        int number2 = Integer.parseInt(numbers[1]);
        int maxNumber = Integer.parseInt(numbers[2]);

        for (int i = 1; i <= maxNumber; i++) {
            if (i % number1 == 0 && i % number2 == 0)
                System.out.println("FizzBuzz");
            else if (i % number1 == 0)
                System.out.println("Fizz");
            else if (i % number2 == 0)
                System.out.println("Buzz");
            else
                System.out.println(i);
        }

    }
}
