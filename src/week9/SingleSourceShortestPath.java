package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * FRANKFURT UAS EXERCISES WEEK 9, WS 21/22
 *
 * Problem: Single source shortest path, non-negative weights
 * Link: https://open.kattis.com/problems/shortestpath1
 * @author Per Austrin
 * @author Thorsten Zieres, 1297197
 * @version 1.1, 01/10/2022
 * Status : Accepted
 * Runtime: 0.75
 */
public class SingleSourceShortestPath {
    // each node is described through a list of edges
    private static List<List<Edge>> nodes;

    // stores distances from start node
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = in.readLine();
            if (line.equals("0 0 0 0"))
                break;

            String[] values = line.split(" ");
            int n = Integer.parseInt(values[0]); // number nodes
            int m = Integer.parseInt(values[1]); // number edges
            int q = Integer.parseInt(values[2]); // number queries
            int s = Integer.parseInt(values[3]); // start

            nodes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nodes.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                values = in.readLine().split(" ");
                nodes.get(Integer.parseInt(values[0]))  // from
                        .add(new Edge(
                                Integer.parseInt(values[1]), // to
                                Integer.parseInt(values[2]) // weight
                        ));
            }

            dijkstra(s);

            for (int i = 0; i < q; i++) {
                int goal = Integer.parseInt(in.readLine());
                System.out.println(dist[goal] == Integer.MAX_VALUE ? "Impossible" : dist[goal]);
            }
            System.out.println();
        }
    }

    private static void dijkstra(int start) {
        // stores nodes which have to be visited
        PriorityQueue<Edge> q = new PriorityQueue<>(); // Edge(nodeNumber, weightFromStart)

        // speichert den Abstand zum Startknoten, Vorgängerknoten muss hier nicht gespeichert werden
        dist = new int[nodes.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // begin with start node
        q.add(new Edge(start, 0));
        while (!q.isEmpty()) {
            Edge currentNode = q.poll(); // fetch the closest node to start

            // currentNode.to is the current node, and I iterate through all neighbors
            for (Edge nxt : nodes.get(currentNode.to)) {
                // distance from current node to next node, currentNode.weigth is distance to startNode
                int d = currentNode.weight + nxt.weight; //nxt.weight is the distance from the currentNode to the neighbor

                // is other path shorter?
                if (d < dist[nxt.to])
                    // add all shorter paths to q because I have to visit them later
                    q.add(new Edge(nxt.to, dist[nxt.to] = d));
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    public int weight, to;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    public int compareTo(Edge a) {
        return weight - a.weight;
    }
}