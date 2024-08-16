package org.jakubplayground.arraysandstrings;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 48. Rotate Image
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        Deque<Integer> queue = new ArrayDeque<>(matrix.length * matrix.length);

        for (int col = 0; col < matrix.length; col++) {
            for (int row = matrix.length - 1; row >= 0 ; row--) {
                queue.addLast(matrix[row][col]);
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = queue.removeFirst();
            }
        }
    }
}
