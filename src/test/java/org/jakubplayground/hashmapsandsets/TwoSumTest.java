package org.jakubplayground.hashmapsandsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {
    private TwoSum cut;

    @BeforeEach
    void setUp() {
        cut = new TwoSum();
    }

    @Test
    void case1() {
        int[] actual = cut.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertThat(actual).containsExactly(0, 1);
    }

    @Test
    void case2() {
        int[] actual = cut.twoSum(new int[]{3, 2, 4}, 6);
        assertThat(actual).containsExactly(1, 2);
    }

    @Test
    void case3() {
        int[] actual = cut.twoSum(new int[]{3, 3}, 6);
        assertThat(actual).containsExactly(0, 1);
    }
}