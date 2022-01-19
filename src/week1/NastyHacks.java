package week1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * FRANKFURT UAS EXERCISES WEEK 1, WS 21/22
 *
 * Problem: Nasty Hacks
 * Link: https://open.kattis.com/contests/kp9a7t/problems/nastyhacks
 * @author Truls Amundsen Bjørklund
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 10/26/2020
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.12
 */
public class NastyHacks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < numberOfCases; i++) {
            List<Integer> input = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            int withoutAdvertisement = input.get(0);
            int withAdvertisement = input.get(1) - input.get(2);

            if (withAdvertisement < withoutAdvertisement) {
                System.out.println("do not advertise");
            } else if (withAdvertisement > withoutAdvertisement) {
                System.out.println("advertise");
            } else {
                System.out.println("does not matter");
            }
        }
    }
}
