package org.jakubplayground.twopointers;

import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        if (nums.length == 0) {
            return new int[]{};
        }

        int left = 0;
        int right = nums.length - 1;
        int[] sortedSquares = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                sortedSquares[i] = nums[right] * nums[right];
                right--;
            } else {
                sortedSquares[i] = nums[left] * nums[left];
                left++;
            }
        }

        return sortedSquares;
    }

    private int[] streamSolution(int[] nums) {
        return Arrays.stream(nums).map(n -> n * n).sorted().toArray();
    }
}
