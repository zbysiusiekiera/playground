package org.jakubplayground.hashmapsandsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MajorityElementTest {
    private MajorityElement cut;

    @BeforeEach
    void setUp() {
        cut = new MajorityElement();
    }

    @Test
    void case1() {
        assertThat(cut.majorityElement(new int[]{3, 2, 3})).isEqualTo(3);
    }

    @Test
    void case2() {
        assertThat(cut.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})).isEqualTo(2);
    }
}