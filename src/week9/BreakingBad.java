package week9;

import java.util.*;

/**
 * FRANKFURT UAS EXERCISES WEEK 9, WS 21/22
 *
 * Problem: Breaking Bad
 * Link: https://open.kattis.com/problems/breakingbad
 * @author Bjarki Ágúst Guðmundsson
 * @author Thorsten Zieres, 1297197
 * @version 2.2, 01/16/2022
 * Status : Accepted
 * Runtime: 0.85
 */
public class BreakingBad {
    // maps all items and all the items it should not be paired with
    static Map<String, Set<String>> items = new HashMap<>();
    static Set<String> itemsWalter = new HashSet<>();
    static Set<String> itemsJesse = new HashSet<>();
    static List<String> itemNames = new ArrayList<>();
    static boolean possible = true;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // number of items to buy
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String item = in.next();
            items.put(item, new HashSet<>());
            itemNames.add(item);
        }

        // number of items not to pair up
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            String x = in.next();
            String y = in.next();
            items.get(x).add(y);
            items.get(y).add(x);
        }

        // for each item I go through the graph of items which shouldnt be bought together
        for (String itemName : itemNames) {
            depthFirstSearch(itemName);
        }

        if (possible) {
            for (String s : itemsWalter) {
                System.out.print(s + " ");
            }
            System.out.println();
            for (String s : itemsJesse) {
                System.out.print(s + " ");
            }
        } else {
            System.out.println("impossible");
        }

    }

    static void depthFirstSearch(String itemName) {
        if (!itemsWalter.contains(itemName) && !itemsJesse.contains(itemName)) {
            // if both do not have the item, I give it to walter
            itemsWalter.add(itemName);
        }

        for (String neighbor : items.get(itemName)) {
            if (itemsWalter.contains(itemName) && !itemsWalter.contains(neighbor) && !itemsJesse.contains(neighbor)) {
                // Walter hat das aktuelle, dann darf er nicht den Nachbarn kaufen, sondern Jesse muss das tun
                // when I give the item to Jesse I search deeper into the graph from this item on
                itemsJesse.add(neighbor);
                depthFirstSearch(neighbor);
            } else if (itemsJesse.contains(itemName) && !itemsJesse.contains(neighbor) && !itemsWalter.contains(neighbor)) {
                // Jesse hat das aktuelle, dann darf er nicht den Nachbarn kaufen, sondern Walter muss das tun
                itemsWalter.add(neighbor);
                depthFirstSearch(neighbor);
            } else if ((itemsJesse.contains(itemName) && itemsJesse.contains(neighbor)) || (itemsWalter.contains(itemName) && itemsWalter.contains(neighbor))) {
                // as soon as item and neighbor are assigned to one person the distribution is not possible
                possible = false;
                return;
            }
        }
    }
}
