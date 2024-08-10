package org.jakubplayground.arraysandstrings;

public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        final var mergedWords = new StringBuilder();
        int longerWordLength = Math.max(word1.length(), word2.length());

        for (int i = 0; i < longerWordLength; i++) {
            if (i < word1.length()) {
                mergedWords.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                mergedWords.append(word2.charAt(i));
            }
        }

        return mergedWords.toString();
    }
}
