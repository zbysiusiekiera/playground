package org.jakubplayground.hashmapsandsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumNumberOfBalloonsTest {
    private MaximumNumberOfBalloons cut;

    @BeforeEach
    void setUp() {
        cut = new MaximumNumberOfBalloons();
    }

    @Test
    void case1() {
        int actual = cut.maxNumberOfBalloons("nlaebolko");
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void case2() {
        int actual = cut.maxNumberOfBalloons("loonbalxballpoon");
        assertThat(actual).isEqualTo(2);
    }

    @Test
    void case3() {
        int actual = cut.maxNumberOfBalloons("leetcode");
        assertThat(actual).isEqualTo(0);
    }
}