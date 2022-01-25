package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * FRANKFURT UAS EXERCISES WEEK 4, WS 21/22
 *
 * Problem: Closest Sums
 * Link: https://open.kattis.com/problems/closestsums
 * @author  Piotr Rudnicki
 * @author Thorsten Zieres, 1297197
 * @version 1.4, 11/20/2020
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.26
 */
public class ClosestSums {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        List<String> results = new ArrayList<>();
        String input;
        int cases = 1;
        while ((input = in.readLine()) != null && !input.isEmpty()) {
            results.add("Case " + cases++ + ":");

            int n = Integer.parseInt(input);
            TreeSet<Integer> sortedSet = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                sortedSet.add(Integer.parseInt(in.readLine()));
            }

            List<Integer> sortedList = new ArrayList<>(sortedSet);
            int m = Integer.parseInt(in.readLine());
            for (int i = 0; i < m; i++) {
                results.add(getClosestSum(Integer.parseInt(in.readLine()), sortedList));
            }
        }

        results.forEach(System.out::println);
    }

    private static String getClosestSum(int query, List<Integer> sortedList) {
        String result = "Closest sum to " + query + " is ";

        if (query <= sortedList.get(0)) {
            result += sortedList.get(0) + sortedList.get(1) + ".";
        } else {
            int closest = sortedList.get(0) + sortedList.get(1);
            for(int i = 0; i < sortedList.size(); i++) {
                for(int j = i+1; j < sortedList.size(); j++) {
                    int sum = sortedList.get(i) + sortedList.get(j);
                    if(Math.abs(sum - query) < Math.abs(closest - query)) {
                        closest = sum;
                    }
                }
            }

            result += closest + ".";
        }

        return result;
    }
}
