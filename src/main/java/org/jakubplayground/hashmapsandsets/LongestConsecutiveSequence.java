package org.jakubplayground.hashmapsandsets;

import org.assertj.core.util.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 128. Longest Consecutive Sequence
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int longest = 0;
        for (int number : numbers) {
            if (!numbers.contains(number - 1)) {
                int length = 1;
                int numberInSequence = number;
                while (numbers.contains(numberInSequence + 1)) {
                    length++;
                    numberInSequence++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
