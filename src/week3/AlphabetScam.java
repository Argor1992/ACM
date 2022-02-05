package week3;

import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 3, WS 21/22
 *
 * Problem: Alphabet Spam
 * Link: https://open.kattis.com/problems/alphabetspam
 * @author Northwestern Europe Regional Contest (NWERC) 2014 Practice Session
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 11/10/2021
 * Status : Accepted
 * Runtime: 0.19
 */
public class AlphabetScam {
    public static void main(String[] args) {
        int numberWhiteSpace = 0;
        int numberLowerCase = 0;
        int numberUpperCase = 0;
        int numberSymbols = 0;

        Scanner in = new Scanner(System.in);
        String word = in.nextLine();

        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);

            if (current == '_')
                numberWhiteSpace++;
            else if (current >= 'a' && current <= 'z')
                numberLowerCase++;
            else if (current >= 'A' && current <= 'Z')
                numberUpperCase++;
            else
                numberSymbols++;
        }

        System.out.println((double)numberWhiteSpace / word.length());
        System.out.println((double)numberLowerCase / word.length());
        System.out.println((double)numberUpperCase / word.length());
        System.out.println((double)numberSymbols / word.length());
    }
}
