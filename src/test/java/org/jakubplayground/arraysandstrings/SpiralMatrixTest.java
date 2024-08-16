package org.jakubplayground.arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SpiralMatrixTest {
    private SpiralMatrix cut;

    @BeforeEach
    void setUp() {
        cut = new SpiralMatrix();
    }

    @Test
    void case1() {
        int[] row1 = new int[]{1,2,3};
        int[] row2 = new int[]{4,5,6};
        int[] row3 = new int[]{7,8,9};
        int[][] matrix = new int[][]{row1, row2, row3};

        assertThat(cut.spiralOrder(matrix)).containsExactly(1,2,3,6,9,8,7,4,5);
    }

    @Test
    void case2() {
        int[] row1 = new int[]{1,2,3,4};
        int[] row2 = new int[]{5,6,7,8};
        int[] row3 = new int[]{9,10,11,12};
        int[][] matrix = new int[][]{row1, row2, row3};

        assertThat(cut.spiralOrder(matrix)).containsExactly(1,2,3,4,8,12,11,10,9,5,6,7);
    }
}