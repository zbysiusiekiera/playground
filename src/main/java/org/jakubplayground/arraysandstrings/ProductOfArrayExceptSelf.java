package org.jakubplayground.arraysandstrings;

/**
 * 238. Product of Array Except Self
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        int totalPrefix = 1;
        int totalSuffix = 1;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (i < nums.length - 1) {
                totalPrefix *= nums[i];
                prefix[i] = totalPrefix;
            }


            if (i != nums.length - 1) {
                totalSuffix *= nums[j];
                suffix[j] = totalSuffix;
            }

        }


        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = suffix[1];
            } else if (i == nums.length - 1) {
                result[i] = prefix[nums.length - 2];
            } else {
                result[i] = prefix[i - 1] * suffix[i + 1];
            }
        }

        return result;
    }
}


