package week10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 10, WS 21/22
 *
 * Problem: Closest Pair (Uniform)
 * Link: https://open.kattis.com/problems/closestpair1
 * @author Per Austrin
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 01/24/2022
 * Status : Accepted
 * Runtime: 1.31
 */
public class ClosestPair {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            int n = Integer.parseInt(in.nextLine());

            if (n == 0) break;

            List<Point> points = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] coordinates = in.nextLine().split(" ");
                points.add(new Point(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1])));
            }

            List<Point> result = getClosestPoints(points);

            for (Point p : result)
                System.out.print(p.x + " " + p.y + " ");
            System.out.println();
        }
    }

    private static List<Point> getClosestPoints(List<Point> points) {
        double distance = distance(points.get(0), points.get(1));
        List<Point> result = new ArrayList<>();
        result.add(points.get(0));
        result.add(points.get(1));

        points.sort((o1, o2) -> (int) (o1.x - o2.x));

        for (int i = 1; i < points.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                double value = distance(points.get(i), points.get(j));

                if (Math.abs(points.get(i).x - points.get(j).x) > distance) {
                    break;
                } else if (value < distance) {
                    distance = value;
                    result = new ArrayList<>();
                    result.add(points.get(j));
                    result.add(points.get(i));
                }
            }
        }

        result.sort((o1, o2) -> (int) (o1.x - o2.x));
        return result;
    }

    private static double distance(Point a, Point b) {
        return Math.sqrt(
                Math.pow(a.x - b.x, 2) +
                        Math.pow(a.y - b.y, 2)
        );
    }

    static class Point implements Comparable<Point> {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return (int) (this.x - o.x);
        }
    }
}
