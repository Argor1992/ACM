import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Number of elements in S: log x = n because n elements result in 2^n subsets
 * > power set
 */
public class ThreePowersv1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long input = Long.parseLong(in.nextLine());
        List<Long> inputs = new ArrayList<>();
        long max = 0;
        while (input != 0) {
            inputs.add(input);
            if (input > max)
                max = input;
            input = Long.parseLong(in.nextLine());
        }

        long[] set = new long[getSetSize(max)];
        for (int i = 0; i < set.length; i++) {
            set[i] = (long)Math.pow(3, i);
        }

        List<List<Integer>> powerSet = getPowerSet(set);

        for (Long pos : inputs) {
            List<Integer> subset = powerSet.get(pos.intValue() - 1);
            System.out.print("{ ");
            for (int i = 0; i < subset.size() - 1; i++)
                System.out.print(subset.get(i) + ", ");
            if (!subset.isEmpty())
                System.out.print(subset.get(subset.size()-1) + " ");
            System.out.println("}");
        }
    }

    public static int getSetSize(long minPowerSetSize) {
        return (int) Math.ceil(Math.log(minPowerSetSize) / Math.log(2));
    }

    public static List<List<Integer>> getPowerSet(long[] set) {
        List<List<Integer>> result = new ArrayList<>();
        long powerSetSize = (long) Math.pow(2, set.length);

        /*
        goes through all combination:
        0000
        0001
        0010
        0011
        and so on
         */
        for(int i = 0; i < powerSetSize; i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j < set.length; j++) {
                if ((i & (1 << j)) > 0)
                    result.get(i).add((int)set[j]);
            }
        }
        return result;
    }
}
