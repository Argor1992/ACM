package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * FRANKFURT UAS EXERCISES WEEK 7 - DUPLICATE 6, WS 21/22
 * The submission was after the contest!
 *
 * Problem: Longest Increasing Subsequence
 * Link: https://open.kattis.com/problems/longincsubseq
 * @author Per Austrin
 * @author Thorsten Zieres, 1297197
 * @version 1.6, 01/19/2022
 * Status : Accepted
 * Runtime: 1.04
 */
public class LISubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = in.readLine()) != null && !input.isEmpty()) {
            int n = Integer.parseInt(input);
            List<Integer> sequence = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            printLongestSubsequence(sequence);
        }
    }

    private static void printLongestSubsequence(List<Integer> numbers) {
        int low;
        int high;
        int middle;

        int lis = 0;
        int currentLis;

        int[] subsequence = new int[numbers.size() + 1];
        int[] parent = new int[numbers.size() + 1];
        int[] result = new int[numbers.size() + 1];
        for (int i = 0; i < numbers.size(); i++) {

            // Binary search for the largest positive j ≤ L
            // such that numbers[subsequence[j]] < numbers[i]
            low = 1;
            high = lis;
            while (low <= high) {
                middle = (int) Math.ceil((low + high) / 2.0);

                if (numbers.get(subsequence[middle]) < numbers.get(i))
                    low = middle + 1;
                else
                    high = middle - 1;
            }

            // After searching, low is 1 greater than the length of the longest prefix of numbers[i]
            currentLis = low;

            // The predecessor of numbers[i] is the last index of the subsequence of length currentLis-1
            parent[i] = subsequence[currentLis - 1];
            subsequence[currentLis] = i;

            // If we found a subsequence longer than any we've found yet, update lis
            if (currentLis > lis)
                lis = currentLis;
        }

        // Reconstruct the longest increasing subsequence
        int k = subsequence[lis];
        for (int i = lis - 1; i >= 0; i--) {
            result[i] = k;
            k = parent[k];
        }

        System.out.println(lis);
        for (int i = 0; i < lis - 1; i++)
            System.out.print(result[i] + " ");
        System.out.println(result[lis - 1]);
    }
}
