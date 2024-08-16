package org.jakubplayground.hashmapsandsets;

import java.util.HashMap;

/**
 * 383. Ransom Note
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineCharacters = new HashMap<>();
        for(char c : magazine.toCharArray()) {
            magazineCharacters.compute(c, (k, count) -> count == null ? 1 : count + 1);
        }


        for(char c : ransomNote.toCharArray()) {
            if (!magazineCharacters.containsKey(c)) {
                return false;
            }

            magazineCharacters.compute(c, (k, count) -> count == 1 ? null : count - 1);
        }

        return true;
    }
}
