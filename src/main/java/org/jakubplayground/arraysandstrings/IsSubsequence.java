package org.jakubplayground.arraysandstrings;

/**
 * 392. Is Subsequence
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        int i = 0;
        for (int j = 0; i < s.length() && j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }

        return i == s.length();
    }
}
