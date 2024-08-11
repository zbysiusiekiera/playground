package org.jakubplayground.arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductOfArrayExceptSelfTest {
    private ProductOfArrayExceptSelf cut;

    @BeforeEach
    void setUp() {
        cut = new ProductOfArrayExceptSelf();
    }

    @Test
    void case1_2_3_4() {
        assertThat(cut.productExceptSelf(new int[]{1,2,3,4})).containsExactly(24,12,8,6);
    }

    @Test
    void case2() {
        assertThat(cut.productExceptSelf(new int[]{-1,1,0,-3,3})).containsExactly(0,0,9,0,0);
    }
}