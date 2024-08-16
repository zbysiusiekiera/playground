package org.jakubplayground.hashmapsandsets;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 217. Contains Duplicate
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> unique = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (unique.contains(nums[i])) {
                return true;
            } else {
                unique.add(nums[i]);
            }
        }
        return false;
    }

    public boolean containsDuplicateSlow(int[] nums) {
        return Arrays.stream(nums).distinct().toArray().length != nums.length;
    }

}
