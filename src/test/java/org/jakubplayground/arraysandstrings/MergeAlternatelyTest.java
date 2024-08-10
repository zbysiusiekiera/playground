package org.jakubplayground.arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MergeAlternatelyTest {

    private MergeAlternately cut;

    @BeforeEach
    public void beforeEach() {
        cut = new MergeAlternately();
    }

    @Test
    void case1() {
        String actual = cut.mergeAlternately("abc", "pqr");
        assertThat(actual).isEqualTo("apbqcr");
    }

    @Test
    void case2() {
        String actual = cut.mergeAlternately("ab", "pqrs");
        assertThat(actual).isEqualTo("apbqrs");
    }

    @Test
    void case3() {
        String actual = cut.mergeAlternately("abcd", "pq");
        assertThat(actual).isEqualTo("apbqcd");
    }
}