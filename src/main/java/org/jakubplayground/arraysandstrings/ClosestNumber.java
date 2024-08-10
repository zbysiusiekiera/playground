package org.jakubplayground.arraysandstrings;

public class ClosestNumber {
    public int findClosestNumber(int[] nums) {
        int closestNumber = nums[0];
        int distance = Math.abs(closestNumber);
        int newDistance;

        for ( int i = 1; i < nums.length; i++ ) {
            newDistance = Math.abs(nums[i]);
            if (newDistance < distance) {
                closestNumber = nums[i];
                distance = newDistance;
            }

            if (newDistance == distance) {
                closestNumber = Math.max(closestNumber, nums[i]);
            }
        }

        return closestNumber;
    }
}
