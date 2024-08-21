package org.jakubplayground.hashmapsandsets;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // index of the other number
        Integer neededNumberPosition;

        // map of other numbers to position of numbers that require them for target sum
        Map<Integer, Integer> neededNumbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            neededNumberPosition = neededNumbers.get(nums[i]);
            if (neededNumberPosition != null) {
                return new int[]{neededNumberPosition, i};
            } else {
                neededNumbers.put(target - nums[i], i);
            }
        }

        return new int[]{};
    }

    // brute force
    // for each number N in nums
    //     for each number M in nums excluding N
    //         if they sum to target return [N, M]
    private int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }
}
