package week8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 8, WS 21/22
 *
 * Problem: Planting Trees
 * Link: https://open.kattis.com/contests/nytf6n/problems/plantingtrees
 * @author Michał Pilipczuk
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 12/19/2020
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.5
 */
public class PlantingTrees {
    /**
     * Example:
     *
     * [1, 2, 3, 3, 4]
     *
     * pick 4 > -4 > [1, 2, 3, 3, 0]
     * pick 3 > -3 > [1, 2, 3, 0, 0]
     * pick 3 > -2 > [1, 2, 1, 0, 0]
     * pick 2 > -1 > [1, 1, 1, 0, 0]
     * pick 1 > -0 > [1, 1, 1, 0, 0] > "growth state" after all trees have been planted
     * >> one day remains
     * >> five planting days + one remaining day + day until party = 7
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfSeeds = sc.nextInt();
        int[] trees = new int[numberOfSeeds];

        for (int i = 0; i < trees.length; i++) {
           trees[i] = sc.nextInt();
        }
        Arrays.sort(trees);

        // Plant trees beginning with the longest growth time to the least growth time
        int plantDay = 1;
        int daysUntilParty = 0;
        for(int i = numberOfSeeds - 1; i >= 0; i--) {
            trees[i] -= (numberOfSeeds - plantDay); // calculates how much the tree has grown during the planting of all trees
            daysUntilParty++;
            plantDay++;
        }

        // check if trees still need time to grow
        int daysLeft = 0;
        for (int i = 0; i < numberOfSeeds; i++) {
            if (trees[i] > daysLeft) {
                daysLeft = trees[i];
            }
        }
        daysUntilParty += daysLeft;
        daysUntilParty++; // add one because Party is on the next day after all trees are fully grown

        System.out.println(daysUntilParty);
    }
}
