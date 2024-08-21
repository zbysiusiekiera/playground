package org.jakubplayground.hashmapsandsets;

import java.util.HashMap;
import java.util.Map;

/**
 * 1189. Maximum Number of Balloons
 */
public class MaximumNumberOfBalloons {
    private static final String WORD = "balloon";

    public int maxNumberOfBalloons(String text) {
        int count = 0;
        Map<Character, Integer> charIndexOfMap = new HashMap<>();

        boolean balloonLetters;
        do {
            balloonLetters = doHaveBalloonLetters(text, charIndexOfMap);
            if (balloonLetters) {
                count++;
            }
        } while (balloonLetters);

        return count;
    }

    private boolean doHaveBalloonLetters(String text, Map<Character, Integer> charIndexOfMap) {
        for (char b: WORD.toCharArray()) {
            // get last index
            Integer charLastIndexOf = charIndexOfMap.getOrDefault(b, 0);
            int indexOf = text.indexOf(b, charLastIndexOf);

            if (indexOf > -1) {
                charIndexOfMap.put(b, indexOf + 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
