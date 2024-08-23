package org.jakubplayground.twopointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SquaresOfASortedArrayTest {
    private SquaresOfASortedArray cut;

    @BeforeEach
    void setUp() {
        cut = new SquaresOfASortedArray();
    }

    @Test
    void case1() {
        assertThat(cut.sortedSquares(new int[]{-4,-1,0,3,10})).containsExactly(0, 1, 9, 16, 100);
    }

    @Test
    void case2() {
        assertThat(cut.sortedSquares(new int[]{-7,-3,2,3,11})).containsExactly(4,9,9,49,121);
    }
}