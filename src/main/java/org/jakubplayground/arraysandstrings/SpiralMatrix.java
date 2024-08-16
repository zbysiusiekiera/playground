package org.jakubplayground.arraysandstrings;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 */
public class SpiralMatrix {
    private static class SpiralWalker {
        int[][] matrix;

        // current pos
        int x = 0;
        int y = 0;

        // boundaries
        int rightLimit;
        int leftLimit = 0;
        int downLimit;
        int upLimit = 1;
        int visits;

        boolean right = true, down = true, horizontal = true;

        public SpiralWalker(int[][] matrix) {
            this.matrix = matrix;
            this.rightLimit = matrix[0].length - 1;
            this.downLimit = matrix.length - 1;
            this.visits = matrix.length * matrix[0].length;
        }

        boolean canWalk() {
            return this.visits > 0;
        }

        int visit() {
            visits--;
            return matrix[y][x];
        }

        public void walk() {
            if (horizontal) {
                walkHorizontal();
            } else {
                walkVertical();
            };
        }

        private void walkVertical() {
            if (down) {
                walkDown();
            } else {
                walkUp();
            }
        }

        private void walkUp() {
            if (y == upLimit) {
                x++;
                right = true;
                horizontal = true;
                upLimit++;
            } else {
                y--;
            }
        }

        private void walkDown() {
            // from current position I want to move down
            if (y == downLimit) {
                // if I can't, switch to left horizontal
                x--;
                right = false;
                horizontal = true;
                downLimit--;
            } else {
                y++;
            }
        }

        private void walkHorizontal() {
            if (right) {
                walkRight();
            } else {
                walkLeft();
            }
        }

        private void walkLeft() {
            if (x == leftLimit) {
                y--;
                horizontal = false;
                down = false;
                leftLimit++;
            } else {
                x--;
            }
        }

        private void walkRight() {
            if (x == rightLimit) {
                y++;
                horizontal = false;
                down = true;
                rightLimit--;
            } else {
                x++;
            }
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        SpiralWalker walker = new SpiralWalker(matrix);
        List<Integer> visited = new ArrayList<>(walker.visits);
        while (walker.canWalk()) {
            visited.add(walker.visit());
            walker.walk();
        }

        return visited;
    }
}
