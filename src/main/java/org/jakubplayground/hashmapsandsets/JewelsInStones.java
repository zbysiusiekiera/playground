package org.jakubplayground.hashmapsandsets;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 771. Jewels and Stones
 */
public class JewelsInStones {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> jewelKeys = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            jewelKeys.add(c);
        }

        int jewelsCount = 0;
        for (char stone : stones.toCharArray()) {
            if (jewelKeys.contains(stone)) {
                jewelsCount++;
            }
        }

        return jewelsCount;
    }
}
