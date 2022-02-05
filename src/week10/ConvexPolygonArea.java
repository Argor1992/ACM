package week10;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 10, WS 21/22
 *
 * Problem: Convex Polygon Area
 * Link: https://open.kattis.com/problems/convexpolygonarea
 * @author  Greg Hamerly
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 01/18/2022
 * Status : Accepted
 * Runtime: 0.17
 */
public class ConvexPolygonArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // test cases
        int n = Integer.parseInt(in.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = in.nextLine().split(" ");

            List<Integer> x = new ArrayList<>();
            List<Integer> y = new ArrayList<>();

            for(int j = 1; j < input.length-1; j++) {
                x.add(Integer.parseInt(input[j]));
                y.add(Integer.parseInt(input[++j]));
            }

            double sum = x.get(x.size() - 1) * y.get(0) - y.get(y.size() - 1) * x.get(0);
            for(int j = 0; j < x.size() - 1; j++) sum += x.get(j) * y.get(j + 1);
            for(int j = 0; j < y.size() - 1; j++) sum -= y.get(j) * x.get(j + 1);

            double area = 0.5 * Math.abs(sum);
            DecimalFormat df = new DecimalFormat("###.#");
            System.out.println(df.format(area));

        }
    }
}