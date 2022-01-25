package week9;

import java.util.*;

/**
 * FRANKFURT UAS EXERCISES WEEK 9, WS 21/22
 *
 * Problem: Torn To Pieces
 * Link: https://open.kattis.com/problems/torn2pieces
 * @author Nathan Backman
 * @author Thorsten Zieres, 1297197
 * @version 1.3, 01/16/2021
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.10
 */
public class TornToPieces {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // number of card pieces
        int n = Integer.parseInt(in.nextLine());

        Graph graph = new Graph();
        for (int i = 0; i < n; i++) {
            String[] station = in.nextLine().split(" ");
            String stationName = station[0];

            // create a Node for the Station
            Node newStation;

            // need to differentiate because in the following step I create all neighbor nodes
            if (!graph.nodeExists(stationName)) {
                newStation = new Node(stationName);
            } else {
                newStation = graph.getNode(stationName);
            }

            if (station.length < 2)
                continue;
            // go through all neighbors
            for (int j = 1; j < station.length; j++) {
                if (graph.nodeExists(station[j])) {
                    // add bidirectional Edge
                    newStation.addNeighbor(graph.getNode(station[j]));
                    graph.getNode(station[j]).addNeighbor(newStation);
                } else {
                    Node neighbor = new Node(station[j]);
                    graph.addNode(neighbor.name, neighbor);
                    newStation.addNeighbor(neighbor);
                    neighbor.addNeighbor(newStation);
                }
            }

            graph.addNode(stationName, newStation);
        }

        // read in start to finish
        String[] path = in.nextLine().split(" ");

        List<Node> result = shortestPath(graph.getNode(path[0]), graph.getNode(path[1]));
        // contains only final node if goal is not reachable
        if (result.size() <= 1) {
            System.out.println("no route found");
        } else {
            System.out.println(result.toString().replace("[", "").replace("]", "").replace(",", ""));
        }
    }

    // uses Breadth First Search
    public static List<Node> shortestPath(Node start, Node finish) {
        if (start == null || finish == null)
            return Collections.emptyList();
        // Nodes which need to be traversed
        Queue<Node> queue = new LinkedList<>();

        // stores the previous Node for each node <Node, previous Node>
        Map<Node, Node> previousNodes = new HashMap<>();

        start.visited = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            Node currentNode = queue.remove(); // removes first element

            if (currentNode.equals(finish)) {
                break;
            } else {
                for (Node neighbor : currentNode.neighbors) {
                    if (!neighbor.visited) {
                        queue.add(neighbor);
                        neighbor.visited = true;
                        previousNodes.put(neighbor, currentNode);
                    }
                }
            }
        }

        List<Node> result = new LinkedList<>();
        // start from the end and get each previous node in the tree, this gives the path from start to finish in reverse
        // result has one element when the end node was not found with BFS
        for (Node currentNode = finish; currentNode != null; currentNode = previousNodes.get(currentNode))
            result.add(currentNode);
        Collections.reverse(result);
        return result;
    }

    static class Graph {
        Map<String, Node> graph = new HashMap<>();

        public void addNode(String name, Node node) {
            graph.put(name, node);
        }

        public Node getNode(String name) {
            return graph.get(name);
        }

        public boolean nodeExists(String name) {
            return graph.get(name) != null;
        }
    }

    static class Node{
        List<Node> neighbors = new ArrayList<>();
        String name;
        boolean visited = false;

        public Node(String name) {
            this.name = name;
        }

        public void addNeighbor(Node node) {
            neighbors.add(node);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return name.equals(node.name);
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
