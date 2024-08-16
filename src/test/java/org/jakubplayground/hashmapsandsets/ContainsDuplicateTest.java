package org.jakubplayground.hashmapsandsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ContainsDuplicateTest {
    private ContainsDuplicate cut;

    @BeforeEach
    void setUp() {
        cut = new ContainsDuplicate();
    }

    @Test
    void case1() {
        assertThat(cut.containsDuplicate(new int[]{1,2,3,1})).isTrue();
    }

    @Test
    void case2() {
        assertThat(cut.containsDuplicate(new int[]{1,2,3,4})).isFalse();
    }

    @Test
    void case3() {
        assertThat(cut.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2})).isTrue();
    }
}