package week5;

import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 4 - DUPLICATE, WS 21/22
 * The submission was after the contest!
 *
 * Problem: Geppetto
 * Link: https://open.kattis.com/problems/geppetto
 * @author Dominik Gleich
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 01/19/2021
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.13
 */
public class Geppetto {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split(" ");
        //number of ingredients
        int n = Integer.parseInt(input[0]);
        //number of NoMixPairs
        int m = Integer.parseInt(input[1]);

        // value 0 means they can be mixed
        int[][] cantMixMatrix = new int[n][n];
        for (int i = 0; i < m; i++) {
            input = in.nextLine().split(" ");
            int firstIngredient = Integer.parseInt(input[0]);
            int secondIngredient = Integer.parseInt(input[1]);

            cantMixMatrix[firstIngredient - 1][secondIngredient - 1] = 1;
            cantMixMatrix[secondIngredient - 1][firstIngredient - 1] = 1;
        }


        int[] pizza = new int[n];
        int possiblePizzas = 1;
        int ingredientNumber = 0;
        boolean canBeMixed;

        while (true) {
            if (pizza[ingredientNumber] < n) {
                if (pizza[ingredientNumber] == 0 && ingredientNumber > 0) {
                    pizza[ingredientNumber] = pizza[ingredientNumber - 1] + 1;
                } else {
                    pizza[ingredientNumber]++;
                }

                canBeMixed = true;
                for (int i = 0; i < ingredientNumber; i++) {
                    if (cantMixMatrix[pizza[i] - 1][pizza[ingredientNumber] - 1] > 0) {
                        canBeMixed = false;
                        break;
                    }
                }

                if (canBeMixed) {
                    possiblePizzas++;
                    if (pizza[ingredientNumber] < n) {
                        ingredientNumber++;
                    }
                }
            } else {
                // backtracking if necessary
                pizza[ingredientNumber] = 0;
                if (ingredientNumber > 0) {
                    ingredientNumber--;
                } else {
                    break;
                }
            }
        }
        System.out.print(possiblePizzas);
    }
}
