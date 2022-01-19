package week10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * FRANKFURT UAS EXERCISES WEEK 10, WS 21/22
 *
 * Problem: Polygon Area
 * Link: https://open.kattis.com/contests/pvcykt/problems/polygonarea
 * @author Per Austrin
 * @author Thorsten Zieres, 1297197
 * @version 1.2, 01/18/2021
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.18
 */
public class PolygonArea {
    /**
     * >> formula from Presentation p. 33
     * abs can be omitted if the vertices are in
     * counterclockwise order. If the vertices are in
     * clockwise order, the difference evaluates to a
     * negative quantity. Yet, here we can have them
     * also counterclockwise
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            // number of vertices (=vertex is the point where two lines meet to form an angle, e.g. corners of a polygon)
            int n = Integer.parseInt(in.nextLine());

            if (n == 0)
                break;

            List<PolygonVertex> vertices = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] vertex = in.nextLine().split(" ");
                vertices.add(new PolygonVertex(
                                Integer.parseInt(vertex[0]),
                                Integer.parseInt(vertex[1])
                        )
                );
            }

            int sum = 0;
            // use Formula for all points
            for (int i = 0; i < vertices.size()-1; i++) {
                sum += vertices.get(i).distance(vertices.get(i+1));
            }
            // the last point distance first point
            sum += vertices.get(n-1).distance(vertices.get(0));

            // If the vertices are in
            // clockwise order, the difference evaluates to a
            // negative quantity

            double area = 0.5 * Math.abs(sum);
            boolean cw = sum < 0;
            System.out.println(cw ? String.format("CW %.1f", area) : String.format("CCW %.1f", area));
        }
    }

    static class PolygonVertex {
        int x;
        int y;

        public PolygonVertex(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int distance(PolygonVertex vertex) {
            return (this.x * vertex.y)
                    - (vertex.x * this.y);
        }
    }
}
