package org.jakubplayground.dynamicprogramming;

import java.util.*;

/**
 * 42. Trapping Rain Water
 */
public class TrappingRain {
    public int trap(int[] height) {
        int left = 0;
        int leftMax = height[left];
        int right = height.length - 1;
        int rightMax = height[right];
        int totalWater = 0;
        int currentHeight;

        while (left < right) {
            if (height[left] < height[right]) {
                currentHeight = height[left];
                leftMax = Math.max(currentHeight, leftMax);
                totalWater += leftMax - currentHeight;
                left++;

            } else {
                currentHeight = height[right];
                rightMax = Math.max(currentHeight, rightMax);
                totalWater += rightMax - currentHeight;
                right--;
            }
        }

        return totalWater;
    }

    public int slowTrap(int[] height) {
        if (height.length < 1) {
            return 0;
        }

        // find positions of each height (map<height, list<positions>>)
        Map<Integer, Set<Integer>> heightMap = new TreeMap<>(Comparator.reverseOrder());
        int h;
        for (int i = 0; i < height.length; i++) {
            put(height[i], i, heightMap);
        }

        //printMap(heightMap);

        // sort positions by height, then position desc
        //DONE

        // iterate over sorted map
        int totalWater = 0;

        // pair of positions of currently processed height
        int left, right;

        // get the highest level
        h = heightMap.keySet().iterator().next();

        while (h > 0) {
            System.out.println("Processing height " + h);

            // find matching rightmost position (it can be any height >= leftmost height)
            List<Integer> positions = heightMap.get(h).stream().toList();
            left = positions.getFirst();

            for (int i = 1; i < positions.size(); i++) {
                // found match, since we are checking the highest possible, there is no "mountain" separator between
                // positions
                right = positions.get(i);
                totalWater += right - left - 1;


                // we need to fix left, because that height is already calculated
                heightMap.get(h).remove(left);
                // but it still could be reused as lower height
                if (h > 1) {
                    put(h - 1, left, heightMap);
                }

                // jump from left to right and find another peek at the same height
                left = right;
            }

            // there are no more peeks at the same height to the right
            // we need to fix left, because that height is already calculated
            heightMap.get(h).remove(left);
            // but it still could be reused as lower height
            if (h > 1) {
                put(h - 1, left, heightMap);
            }

            h--;
        }

        return totalWater;
    }

    private static void put(int key, int value, Map<Integer, Set<Integer>> map) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            Set<Integer> heightAtPositions = new TreeSet<>();
            heightAtPositions.add(value);
            map.put(key, heightAtPositions);
        }
    }

    private static void printMap(Map<Integer, Set<Integer>> map) {
        map.forEach((height, positions) -> System.out.println("Height: " + height + " at positions: " + positions.toString()));
    }

}
