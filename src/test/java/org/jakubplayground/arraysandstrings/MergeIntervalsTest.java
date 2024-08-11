package org.jakubplayground.arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {
    private MergeIntervals cut;

    @BeforeEach
    void setUp() {
        cut = new MergeIntervals();
    }

    @Test
    void case1() {
        int[][] input = {{1,3},{2,6},{8,10},{15,18}};
        int[][] output = {{1,6},{8,10},{15,18}};
        assertThat(cut.merge(input)).isDeepEqualTo(output);
    }

    @Test
    void case2() {
        int[][] input = {{1,4},{4,5}};
        int[][] output = {{1,5}};
        assertThat(cut.merge(input)).isDeepEqualTo(output);
    }

    @Test
    void case3() {
        int[][] input = {{1,4}, {0,4}};
        int[][] output = {{0,4}};
        assertThat(cut.merge(input)).isDeepEqualTo(output);
    }

    @Test
    void case4() {
        int[][] input = {{1,4}, {5,6}};
        int[][] output = {{1,4}, {5,6}};
        assertThat(cut.merge(input)).isDeepEqualTo(output);
    }

    @Test
    void case5() {
        int[][] input = {{5,6}, {1,4}};
        int[][] output = {{1,4}, {5,6}};
        assertThat(cut.merge(input)).isDeepEqualTo(output);
    }

    @Test
    void case6() {
        int[][] input = {{1,4}, {2,3}};
        int[][] output = {{1,4}};
        assertThat(cut.merge(input)).isDeepEqualTo(output);
    }


}