package week10;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 10, WS 21/22
 *
 * Problem: Hitting the Targets
 * Link: https://open.kattis.com/contests/pvcykt/problems/hittingtargets
 * @author Greg Hamerly
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 01/18/2021
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.12
 */
public class HittingTheTargets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = Integer.parseInt(in.nextLine());

        List<Rectangle> rectangles = new ArrayList<>();
        List<Circle> circles = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] target = in.nextLine().split(" ");
            if (target[0].equals("rectangle")) {
                rectangles.add(new Rectangle(
                        new Point(Integer.parseInt(target[1]), Integer.parseInt(target[2])),
                        new Point(Integer.parseInt(target[3]), Integer.parseInt(target[4]))
                ));
            } else {
                circles.add(new Circle(
                        new Point(Integer.parseInt(target[1]), Integer.parseInt(target[2])),
                        Integer.parseInt(target[3])
                ));
            }
        }

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            int hits = 0;
            String[] shot = in.nextLine().split(" ");
            Point point = new Point(Integer.parseInt(shot[0]), Integer.parseInt(shot[1]));

            for (Rectangle rect : rectangles) {
                if (point.x <= rect.point2.x && point.x >= rect.point1.x && point.y <= rect.point2.y && point.y >= rect.point1.y)
                    hits++;
            }

            for (Circle circle : circles) {
                double d = Math.sqrt(
                        Math.pow(Math.abs(point.x - circle.point.x), 2) + Math.pow(Math.abs(point.y - circle.point.y), 2)
                );
                if (d <= circle.radius) {
                    hits++;
                }
            }

            System.out.println(hits);
        }
    }

    static class Rectangle {
        Point point1;
        Point point2;

        public Rectangle(Point point1, Point point2) {
            this.point1 = point1;
            this.point2 = point2;
        }
    }

    static class Circle {
        Point point;
        double radius;

        public Circle(Point point, double radius) {
            this.point = point;
            this.radius = radius;
        }
    }
}
