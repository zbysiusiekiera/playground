package org.jakubplayground.arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LargestCommonPrefixTest {
    private LargestCommonPrefix cut;

    @BeforeEach
    void setUp() {
        cut = new LargestCommonPrefix();
    }

    @Test
    void case1() {
        assertThat(cut.longestCommonPrefix(new String[]{"flower","flow","flight"}))
                .isEqualTo("fl");
    }

    @Test
    void case2() {
        assertThat(cut.longestCommonPrefix(new String[]{"dog","racecar","car"}))
                .isEqualTo("");
    }

    @Test
    void case3() {
        assertThat(cut.longestCommonPrefix(new String[]{"ab", "a"}))
                .isEqualTo("a");
    }
}