package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FRANKFURT UAS EXERCISES WEEK 3, WS 21/22
 *
 * Problem: Pig Latin
 * Link: https://open.kattis.com/problems/piglatin
 * @author Jack Rosenthal
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 11/15/2021
 * Status : Accepted
 * Runtime: 0.72
 */
public class PigLatin {
    public static final List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'y');

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        List<String> results = new ArrayList<>();
        String input;
        while ((input = in.readLine()) != null && !input.isEmpty()) {
            results.add(getPigSentence(input));
        }
        results.forEach(System.out::println);
    }

    private static String getPigSentence(String sentence) {
        String[] words = sentence.split(" ");

        StringBuilder result = new StringBuilder(sentence.length());

        Arrays.stream(words).forEach(word -> {
            result.append(getPigWord(word)).append(" ");
        });

        return result.deleteCharAt(result.length() - 1).toString();
    }

    private static String getPigWord(String word) {
        if (vowels.contains(word.charAt(0))) {
            return word + "yay";
        } else {
            StringBuilder beginning = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                if (vowels.contains(word.charAt(i))) {
                    return word.substring(i) + beginning + "ay";
                } else {
                    beginning.append(word.charAt(i));
                }
            }
        }
        return word;
    }
}
