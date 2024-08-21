package org.jakubplayground.hashmapsandsets;

import java.util.HashMap;

/**
 * 169. Majority Element
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        int majorityCount = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            if (counts.merge(nums[i], 1, Integer::sum) > majorityCount) {
                return nums[i];
            }
        }

        return -1;
    }
}
