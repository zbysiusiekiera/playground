package org.jakubplayground.arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RotateImageTest {
    private RotateImage cut;

    @BeforeEach
    void setUp() {
        cut = new RotateImage();
    }

    @Test
    void case1() {
        int[] row1 = new int[]{1,2,3};
        int[] row2 = new int[]{4,5,6};
        int[] row3 = new int[]{7,8,9};
        int[][] matrix = new int[][]{row1, row2, row3};

        cut.rotate(matrix);

        row1 = new int[]{7,4,1};
        row2 = new int[]{8,5,2};
        row3 = new int[]{9,6,3};
        int[][] expected = new int[][]{row1, row2, row3};
        assertThat(matrix).isDeepEqualTo(expected);
    }

    @Test
    void case2() {
        int[] row1 = new int[]{5, 1, 9, 11};
        int[] row2 = new int[]{2, 4, 8, 10};
        int[] row3 = new int[]{13, 3, 6, 7};
        int[] row4 = new int[]{15, 14, 12, 16};
        int[][] matrix = new int[][]{row1, row2, row3, row4};

        cut.rotate(matrix);

        row1 = new int[]{15, 13, 2, 5};
        row2 = new int[]{14, 3, 4, 1};
        row3 = new int[]{12, 6, 8, 9};
        row4 = new int[]{16, 7, 10, 11};
        int[][] expected = new int[][]{row1, row2, row3, row4};
        assertThat(matrix).isDeepEqualTo(expected);
    }
}