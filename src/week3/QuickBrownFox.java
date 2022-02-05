package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 3, WS 21/22
 *
 * Problem: Quick Brown Fox
 * Link: https://open.kattis.com/problems/quickbrownfox
 * @author  David Sturgill
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 11/15/2021
 * Status : Accepted
 * Runtime: 0.13
 */
public class QuickBrownFox {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = Integer.parseInt(in.nextLine());

        List<String> solutions = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            String input = in.nextLine();

            solutions.add(isPangram(input));
        }
        solutions.forEach(System.out::println);
    }

    private static String isPangram(String input) {
        boolean[] characters = new boolean[26];
        Arrays.fill(characters, false);

        for (int i = 0; i < input.length(); i++) {
            char current = Character.toLowerCase(input.charAt(i));

            if (current <= 'z' && current >= 'a') {
                characters[current-97] = true;
            }
        }

        StringBuilder missing = new StringBuilder(26);
        for (int i = 0; i < characters.length; i++) {
            if (!characters[i])
                missing.append((char) (i + 97));
        }
        if (missing.length() == 0)
            return "pangram";
        else
            return "missing " + missing;
    }
}
