package week9;

import java.util.*;

public class BigTruck {

    static Graph graph;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // number of locations, from 1.. n; 1 = start, n = end
        int n = Integer.parseInt(in.nextLine());
        graph = new Graph();

        // all the items for the places
        char[] numberOfItems = in.nextLine().toCharArray();

        for (int i = 0; i < numberOfItems.length; i++) {
            graph.addNode(new Node(i+1, numberOfItems[i]));
        }

        // number of roads
        int m = Integer.parseInt(in.nextLine());
        for (int i = 0; i < m; i++) {
            String[] input = in.nextLine().split(" ");
            int numberA = Integer.parseInt(input[0]);
            int numberB = Integer.parseInt(input[1]);
            int distance = Integer.parseInt(input[2]);

            Edge edge1 = new Edge(numberA, numberB, distance);
            Edge edge2 = new Edge(numberB, numberA, distance);
            graph.getNode(numberA).addNeighbor(edge1);
            graph.getNode(numberB).addNeighbor(edge2);
        }

        dijkstra();
    }

    private static void dijkstra() {
        // stores nodes which have to be visited
        PriorityQueue<Node> q = new PriorityQueue<>(); // Edge(nodeNumber, weightFromStart)

        // speichert den Abstand zum Startknoten, Vorgängerknoten muss hier nicht gespeichert werden

        // begin with start node
        graph.getNode(1).distance = 0;
        q.add(graph.getNode(1));
        while (!q.isEmpty()) {
            Node currentNode = q.poll(); // fetch the closest node to start

            for (Edge nxt : currentNode.neighbors) {
                int d = currentNode.distance + nxt.weight;

                if (d < graph.getNode(nxt.from).distance)
                    graph.getNode(nxt.from).distance = d;
                    q.add(graph.getNode(nxt.from));
            }
        }

        System.out.println(graph.getNode(1).distance);
    }

    static class Graph {
        Map<Integer, Node> graph = new HashMap<>();

        public void addNode(Node node) {
            graph.put(node.number, node);
        }

        public Node getNode(int number) {
            return graph.get(number);
        }
    }

    static class Node implements Comparable<Node> {
        List<Edge> neighbors = new ArrayList<>();
        int number;
        int items;
        int distance = Integer.MAX_VALUE;

        public Node(int number, int items) {
            this.number = number;
            this.items = items;
        }

        public void addNeighbor(Edge edge) {
            neighbors.add(edge);
        }

        @Override
        public int compareTo(Node o) {
            return distance - o.distance;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (!(o instanceof TornToPieces.Node)) return false;
//            TornToPieces.Node node = (TornToPieces.Node) o;
//            return name.equals(node.name);
//        }
//
//        @Override
//        public String toString() {
//            return name;
//        }
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }
}
