package week8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 8, WS 21/22
 *
 * Problem: Kornislav
 * Link: https://open.kattis.com/problems/kornislav
 * @author Croatian Open Competition in Informatics
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 12/19/2022
 * Status : Accepted
 * Runtime: 0.10
 */
public class Kornsislav {
    /**
     * a[0] da eine Seite muss diese Länge (kürzeste) haben damit das Rechteck überhaupt eingeschlossen werden kann
     * a[1] nicht, damit wird die seite gegenüberliegend von a[0] eingeschlossen
     * a[2] ist die längste Seite des Rechteckts, die möglich ist nach dieser Logik
     *
     * Lauf Reihenfolge:
     * längste a[3]
     * kürzeste a[0]
     * zweitlängste a[2]
     * zweitkürzeste >> damit schließen a[0] und a[2] das Rechteck ein
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] steps = new int[4];

        for(int i=0;i<4;i++)
            steps[i]= sc.nextInt();

        Arrays.sort(steps);
        System.out.println(steps[0]*steps[2]);
    }
}
