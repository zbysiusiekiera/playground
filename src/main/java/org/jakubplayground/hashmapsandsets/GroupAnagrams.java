package org.jakubplayground.hashmapsandsets;

import java.util.*;

/**
 * 49. Group Anagrams
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String string : strs) {
            char[] characters = string.toCharArray();
            Arrays.sort(characters);

            anagrams.computeIfAbsent(new String(characters), _ -> new ArrayList<>()).add(string);
        }

        return anagrams.values().stream().toList();
    }
}
