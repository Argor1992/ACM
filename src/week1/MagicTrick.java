package week1;

import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 1, WS 21/22
 *
 * Problem: Magic Trick
 * Link: https://open.kattis.com/problems/magictrick
 * @author ICPC North America
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 10/27/2021
 * Status : Accepted
 * Runtime: 0.1
 */
public class MagicTrick {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        boolean duplicate = false;
        for (int i = 0; i < input.length()-1  && !duplicate; i++) {
            for (int j = i+1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    duplicate = true;
                    break;
                }
            }
        }

        System.out.println(duplicate ? "0" : "1");
    }
}


