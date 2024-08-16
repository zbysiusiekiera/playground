package org.jakubplayground.hashmapsandsets;

import java.util.Arrays;

/**
 * 242. Valid Anagram
 */
public class ValidAnagram {
    public boolean isAnagramSlow(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[26];
        int i;
        for (char c : s.toCharArray()) {
            i = t.indexOf(c, letters[c % 26]);
            if (i == -1) {
                return false;
            }
            letters[c % 26] = i + 1;
        }

        return true;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] word1 = s.toCharArray();
        char[] word2 = t.toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);

        return new String(word1).equals(new String(word2));
    }
}
