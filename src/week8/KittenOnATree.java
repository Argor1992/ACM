package week8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 8, WS 21/22
 *
 * Problem: Kitten on a Tree
 * Link: https://open.kattis.com/contests/nytf6n/problems/kitten
 * @author Godmar Back
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 12/19/2020
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.11
 */
public class KittenOnATree {
    /**
     * Map with:
     * <bi, a> thus I know that I can reach from my current node bi the next level closer to the ground a
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String kitten = scan.next();
        scan.nextLine();

        Map<String, String> tree = new HashMap<>();

        while (true) {
            String s = scan.next();

            if (s.equals("-1")) {
                break;
            } else {
                String[] leaf = scan.nextLine().split(" ");
                for (String value : leaf) tree.put(value, s);
            }

        }

        String currentNode = kitten;
        while (true) {
            System.out.print(currentNode);

            if (!tree.containsKey(currentNode)) {
                // reached the end because there is no node further down
                break;
            } else {
                System.out.print(" ");
                // just get the node further down, no matter which one
                currentNode = tree.get(currentNode);
            }
        }
    }
}
