package org.jakubplayground.arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MaxProfitTest {
    private MaxProfit cut;

    @BeforeEach
    void setUp() {
        cut = new MaxProfit();
    }


    @Test
    void case1() {
        assertThat(cut.maxProfit(new int[]{7,1,5,3,6,4})).isEqualTo(5);
    }

    @Test
    void case2() {
        assertThat(cut.maxProfit(new int[]{7,6,4,3,1})).isEqualTo(0);
    }

    @Test
    void case3() {
        assertThat(cut.maxProfit(new int[]{2,1,2,1,0,1,2})).isEqualTo(2);
    }

    @Test
    void case4() {
        assertThat(cut.maxProfit(new int[]{1})).isEqualTo(0);
    }
}