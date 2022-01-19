package week9;

import java.util.Scanner;

public class CoastLength {
    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new char[n][m];

        for (int i = 0; i < n; i++)
            map[i] = sc.next().toCharArray();
    }
}
