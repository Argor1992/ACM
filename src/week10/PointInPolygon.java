package week10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PointInPolygon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            // number of vertices
            int n = Integer.parseInt(in.nextLine());
            if (n == 0) break;

            List<PolygonVertex> vertices = new ArrayList<>();
            for (int i  = 0; i < n; i++) {
                String[] point = in.nextLine().split(" ");
                vertices.add(new PolygonVertex(
                        Integer.parseInt(point[0]),
                        Integer.parseInt(point[1])
                ));
            }

            // points to test
            int m = Integer.parseInt(in.nextLine());
            for (int i = 0; i < m; i++) {
                String[] coordinates = in.nextLine().split(" ");
                PolygonVertex point = new PolygonVertex(
                        Integer.parseInt(coordinates[0]),
                        Integer.parseInt(coordinates[1])
                );

                isPointInOutOrOnPolygon(vertices, point);
            }
        }
    }

    private static void isPointInOutOrOnPolygon(List<PolygonVertex> vertices, PolygonVertex point) {
        // Point is in polygon if a line from the point to infinity crosses the polygon odd times
        boolean odd = false;
        boolean on = false;

        // Starting from first edge to the last
        for (int i = 0, j = vertices.size()-1; i < vertices.size(); i++) {
            if ((vertices.get(i).y >= point.y != vertices.get(j).y >= point.y) && // check if point is above one node and below the other
                    // edge does not cross Y coordinate before the x coordinate (but between our x coordinate and infinity
                    (point.x < (vertices.get(j).x - vertices.get(i).x) * (point.y - vertices.get(i).y) / (vertices.get(j).y - vertices.get(i).y) + vertices.get(i).x)
            ) {
                odd = !odd;
            }

            if (((vertices.get(i).y >= point.y) != (vertices.get(j).y >= point.y)) && // check if point is above one node and below the other
                    // edge does not cross Y coordinate before the x coordinate (but between our x coordinate and infinity
                    (point.x == (vertices.get(j).x - vertices.get(i).x) * (point.y - vertices.get(i).y) / (vertices.get(j).y - vertices.get(i).y) + vertices.get(i).x)

            ) {
                on = !on;
            }
            j = i;
        }

//        if (on && )

        System.out.println(on);
        System.out.println(odd ? "in" : "out");
    }

    static class PolygonVertex {
        int x;
        int y;

        public PolygonVertex(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int distance(PolygonArea.PolygonVertex vertex) {
            return (this.x * vertex.y)
                    - (vertex.x * this.y);
        }
    }
}
