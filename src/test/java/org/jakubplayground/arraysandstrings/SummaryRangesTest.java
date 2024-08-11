package org.jakubplayground.arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SummaryRangesTest {
    private SummaryRanges cut;

    @BeforeEach
    void setUp() {
        cut = new SummaryRanges();
    }

    @Test
    void case1() {
        assertThat(cut.summaryRanges(new int[]{0,1,2,4,5,7}))
                .containsExactly("0->2","4->5","7");
    }

    @Test
    void case2() {
        assertThat(cut.summaryRanges(new int[]{0,2,3,4,6,8,9}))
                .containsExactly("0","2->4","6","8->9");
    }
}