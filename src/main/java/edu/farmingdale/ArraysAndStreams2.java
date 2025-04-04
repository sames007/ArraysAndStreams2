package edu.farmingdale;

// Demonstrating lambdas and streams with an array of Strings.
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {
    public static void main(String[] args) {
        String[] strings =
                {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};

        // Display original strings
        System.out.printf("Original strings: %s%n", Arrays.asList(strings));

        // Strings in uppercase
        System.out.printf("Strings in uppercase: %s%n",
                Arrays.stream(strings)
                        .map(String::toUpperCase)
                        .collect(Collectors.toList()));

        // Strings less than "n" (case insensitive) sorted ascending
        System.out.printf("Strings less than n sorted ascending: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("n") < 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER)
                        .collect(Collectors.toList()));

        // Strings less than "n" (case insensitive) sorted descending
        System.out.printf("Strings less than n sorted descending: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("n") < 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                        .collect(Collectors.toList()));

        // New Feature 1: Filter strings that start with a vowel (case-insensitive)
        List<String> vowelStart = Arrays.stream(strings)
                .filter(s -> {
                    String firstLetter = s.substring(0, 1).toUpperCase();
                    return firstLetter.equals("A") || firstLetter.equals("E") ||
                            firstLetter.equals("I") || firstLetter.equals("O") ||
                            firstLetter.equals("U");
                })
                .collect(Collectors.toList());
        System.out.printf("Strings starting with a vowel: %s%n", vowelStart);

        // New Feature 2: Concatenate all strings into one string, separated by commas
        String concatenated = Arrays.stream(strings)
                .collect(Collectors.joining(", "));
        System.out.printf("Concatenated string: %s%n", concatenated);

        // New Feature 3: Count strings with more than 5 characters (case-insensitive)
        long countLongStrings = Arrays.stream(strings)
                .filter(s -> s.length() > 5)
                .count();
        System.out.printf("Number of strings with more than 5 characters: %d%n", countLongStrings);
    }
}
