package org.jakubplayground.hashmapsandsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequenceTest {
    private LongestConsecutiveSequence cut;

    @BeforeEach
    void setUp() {
        cut = new LongestConsecutiveSequence();
    }

    @Test
    void case1() {
        assertThat(cut.longestConsecutive(new int[]{100,4,200,1,3,2})).isEqualTo(4);
    }

    @Test
    void case2() {
        assertThat(cut.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1})).isEqualTo(9);
    }
}