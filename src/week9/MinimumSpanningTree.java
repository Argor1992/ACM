package week9;

import java.util.*;

/**
 * FRANKFURT UAS EXERCISES WEEK 9, WS 21/22
 *
 * Problem: Minimum Spanning Tree
 * Link: https://open.kattis.com/contests/rxgmfr/problems/minspantree
 * @author Per Austrin
 * @author Thorsten Zieres, 1297197
 * @version 1.2, 01/16/2021
 * Method : Ad-Hoc
 * Status : Time Limit Exceeded
 * Runtime: > 2.0
 */
public class MinimumSpanningTree {
    /**
     * I use the Kruskal Algorithm:
     * Sort all edged ascending
     * Make a new Graph with all node, but no edges
     * Go through the sorted edges and add them to the new graph if it does not form a cycle
     *
     * The main problem here is the cycle detection. DFS takes too long because we have
     * to check for cycles everytime we add an edge
     * >> Solution Union-find algorithm with disjoint set:
     * Each node is treated as one set. Each time I add an edge it creates no cycle if its nodes
     * are not in the same set. If I can add it, I merge the two node sets
     *
     * https://studyflix.de/informatik/kruskal-algorithmus-1292
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            String[] nAndM = in.nextLine().split(" ");

            // number of nodes
            int n = Integer.parseInt(nAndM[0]);
            // number of edges
            int m = Integer.parseInt(nAndM[1]);

            if (n == 0) {
                break;
            }

            /*
             * If the number of edges is less than number of nodes - 1, read all the edges
             * but output "Impossible" because in this case the spanning tree has not
             * enough edges to connect all nodes (a tree must have n-1 edges). Then, move on to the next case.
             */
            if (m < n - 1) {
                for (int i = 0; i < m; i++) {
                    in.nextLine();
                }
                System.out.println("Impossible");
                continue;
            }

            List<Edge> edges = new ArrayList<>(m);
            for (int i = 0; i < m; i++) {
                String[] values = in.nextLine().split(" ");
                int node1 = Integer.parseInt(values[0]);
                int node2 = Integer.parseInt(values[1]);
                int weight = Integer.parseInt(values[2]);
                // nodes are in ascending order
                edges.add(new Edge(Math.min(node1, node2), Math.max(node1, node2), weight));
            }
            //mergesort for the kruskal algorithm
            edges.sort(Comparator.comparingInt(o -> o.weight));
            kruskalAlgorithm(n, edges);
        }
    }

    private static void kruskalAlgorithm(int n, List<Edge> edges) {
        int costOfTree = 0;
        List<Edge> edgesOfSpanningTree = new ArrayList<>();
        UnionFind unionFind = new UnionFind(n);

        for (Edge edge : edges) {
            if (!unionFind.detectCycle(edge.node1, edge.node2)) {
                costOfTree += edge.weight;
                edgesOfSpanningTree.add(edge);
            }
        }

        if (edgesOfSpanningTree.size() < n - 1) {
            System.out.println("Impossible");
        }

        edgesOfSpanningTree.sort((o1, o2) -> o1.node1 == o2.node1 ? o1.node2 - o2.node2 : o1.node1 - o2.node1);
        System.out.println(costOfTree);

        for (Edge edge : edgesOfSpanningTree) {
            System.out.println(edge.node1 + " " + edge.node2);
        }
    }

    static class Edge {
        int node1;
        int node2;
        int weight;

        public Edge(int node1, int node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }
    }

    static class UnionFind {
        // All sets, initially each node in its own >> therefore each node has itself as parent
        // list index is the node itself  and thus links the node to its parent
        List<DisjointSetInfo> nodes;
        public UnionFind(int totalNodes) {
            nodes = new ArrayList<>(totalNodes);
            for (int i = 0; i < totalNodes; i++) {
                nodes.add(new DisjointSetInfo(i));
            }
        }

        boolean detectCycle(Integer a, Integer b) {
            // if both have the same parent they must be in the same set
            Integer rootA = findParentOfNodeWithPathCompression(a);
            Integer rootB = findParentOfNodeWithPathCompression(b);

            if (rootA.equals(rootB))
                return true;

            unionOfTwoSetsByRank(rootA, rootB);
            return false;
        }

        // node is the index of the list
        // easy way to search, but takes too long because the path can be very long
        Integer findParentOfNode(Integer node) {
            Integer parentOfNode = nodes.get(node).parentNode;
            if (parentOfNode.equals(node)) {
                // this returns the parent of the searched node
                return node;
            } else {
                return findParentOfNode(parentOfNode);
            }
        }

        // each node I visit on the way to the root is part of the same set
        Integer findParentOfNodeWithPathCompression(Integer node) {
            DisjointSetInfo setInfo = nodes.get(node);
            Integer parentOfNode = setInfo.parentNode;

            if (parentOfNode.equals(node)) {
                // this returns the parent of the searched node
                return node;
            } else {
                Integer parentOfParent = findParentOfNode(parentOfNode);
                setInfo.parentNode = parentOfParent;
                return parentOfParent;
            }
        }

        // This can balance a very unbalanced tree which reduces the search time, instead we use a union by rank technique
        void unionOfTwoSets(Integer rootA, Integer rootB) {
            DisjointSetInfo setInfoA = nodes.get(rootA);
            setInfoA.parentNode = rootB;
        }

        void unionOfTwoSetsByRank(Integer rootA, Integer rootB){
            DisjointSetInfo setInfoA = nodes.get(rootA);
            DisjointSetInfo setInfoB = nodes.get(rootB);

            int rankA = setInfoA.rank;
            int rankB = setInfoB.rank;

            if (rankA < rankB) {
                setInfoA.parentNode = rootB;
            } else {
                setInfoB.parentNode = rootA;
                if (rankA == rankB) {
                    setInfoA.rank = rankA + 1;
                }
            }
        }

    }

    /**
     * represents a disjoint set (= set of sets with all nodes, at the beginning each node is its own set)
     *
     */
    static class DisjointSetInfo {
        Integer parentNode;
        int rank = 0;

        public DisjointSetInfo(Integer parentNode) {
            // each node in its own set and has therefore itself as parent
            this.parentNode = parentNode;
        }
    }
}
