
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class PrimeSpiral {
    public static boolean[] sieve;
    public static final int LENGTH = 10_000;

    public static void main(String[] args) throws IOException {
        sieve = getPrimeNumbers();
        Map<Point, Integer> spiral = new HashMap<>();
        spiral.put(new Point(0, 0), 1);

        boolean addOne = true;
        int numberOfIterations = 1;
        int currentX = 0;
        int currentY = 0;
        for (int i = 2; i <= LENGTH; ) {

            for (int j = 0; j < numberOfIterations && i <= LENGTH; j++, i++) {
                if (addOne) {
                    spiral.put(new Point(++currentX, currentY), i);
                } else {
                    spiral.put(new Point(--currentX, currentY), i);
                }
            }

            for (int j = 0; j < numberOfIterations && i <= LENGTH; j++, i++) {
                if (addOne) {
                    spiral.put(new Point(currentX, ++currentY), i);
                } else {
                    spiral.put(new Point(currentX, --currentY), i);
                }
            }

            numberOfIterations++;
            addOne = !addOne;
        }

        int[][] adjMatrix = new int[LENGTH+1][LENGTH+1];
        spiral.forEach((point, number) -> {
            if (!isPrime(number)) {
                Integer neighbor1 = spiral.get(new Point(point.x + 1, point.y));
                if (neighbor1 != null && !isPrime(neighbor1))
                    adjMatrix[number][neighbor1] = 1;
                Integer neighbor2 = spiral.get(new Point(point.x - 1, point.y));
                if (neighbor2 != null && !isPrime(neighbor2))
                    adjMatrix[number][neighbor2] = 1;
                Integer neighbor3 = spiral.get(new Point(point.x, point.y + 1));
                if (neighbor3 != null && !isPrime(neighbor3))
                    adjMatrix[number][neighbor3] = 1;
                Integer neighbor4 = spiral.get(new Point(point.x, point.y - 1));
                if (neighbor4 != null && !isPrime(neighbor4))
                    adjMatrix[number][neighbor4] = 1;
            }
        });

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> results = new ArrayList<>();
        String input;
        while ((input = in.readLine()) != null && !input.isEmpty()) {
            String[] number = input.split(" ");

            results.add(getShortestPath(adjMatrix, Integer.parseInt(number[0]), Integer.parseInt(number[1])));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case " + (i+1) + ": " + (results.get(i) ));
        }
    }

    private static int getShortestPath(int[][] graph, int start, int end) {
        if (start == end)
            return 0;

        Map<Integer, Node> q = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            q.put(i, new Node(i, Integer.MAX_VALUE, null));
        }

        q.get(start).distance = 0;
        List<Node> s = new ArrayList<>();

        Node currentNode;
        while (!q.isEmpty()) {
            currentNode = getMin(q);

            if (currentNode == null) {
                return -1;
            }

            s.add(currentNode);

            for (int i = 0; i < graph.length; i++) {
                if (graph[currentNode.index][i] == 1) {
                    Node n = q.get(i);
                    if (n != null) {
                        if (n.distance > currentNode.distance) {
                            n.distance = currentNode.distance + 1;
                            n.prevNode = currentNode;
                        }
                    }
                }
            }

            if (currentNode.index == end) {
                break;
            }
        }

        if (s.isEmpty())
            return -1;

        return countPath(s.get(0), s.get(s.size() - 1));
    }

    private static int countPath(Node start, Node end) {
        List<Node> path = new ArrayList<>();

        while (true) {
            if (end == null)
                return -1;
            path.add(end);
            if (end.index == start.index)
                break;
            end = end.prevNode;
        }

        return path.size() - 1;
    }

    private static Node getMin(Map<Integer, Node> q) {
        int minIndex = -1;
        int min = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Node> entry : q.entrySet()) {
            if (entry.getValue().distance < min) {
                minIndex = entry.getKey();
                min = entry.getValue().distance;
            }
        }

        return q.remove(minIndex);
    }

    private static class Node {
        public int index;
        //        public int number;
        public int distance;
        //        public int estimatedDistance;
        public Node prevNode;

//        public Node(int index, int number, int distance, int estimatedDistance, Node prevNode) {
//            this.index = index;
//            this.number = number;
//            this.distance = distance;
//            this.estimatedDistance = estimatedDistance;
//            this.prevNode = prevNode;
//        }


        public Node(int index, int distance, Node prevNode) {
            this.index = index;
            this.distance = distance;
            this.prevNode = prevNode;
        }
    }

    public static boolean isPrime(int number) {
        return sieve[number];
    }

    private static boolean[] getPrimeNumbers() {
        int max = 10_001;
        boolean[] sieve = new boolean[max];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (sieve[i]) {
                for (int j = i * i; j < max; j += i)
                    sieve[j] = false;
            }
        }

        return sieve;
    }
}
