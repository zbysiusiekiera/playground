package org.jakubplayground.arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IsSubsequenceTest {
    private IsSubsequence cut;

    @BeforeEach
    void setUp() {
        cut = new IsSubsequence();
    }

    @Test
    void case1() {
        assertThat(cut.isSubsequence("abc", "ahbgdc")).isTrue();
    }

    @Test
    void case2() {
        assertThat(cut.isSubsequence("axc", "ahbgdc")).isFalse();
    }

    @Test
    void case3() {
        assertThat(cut.isSubsequence("aabc", "ahbgdc")).isFalse();
    }

    @Test
    void case4() {
        assertThat(cut.isSubsequence("aabc", "aahbgdc")).isTrue();
    }
}