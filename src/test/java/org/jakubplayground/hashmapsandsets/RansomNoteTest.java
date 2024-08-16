package org.jakubplayground.hashmapsandsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RansomNoteTest {
    private RansomNote cut;

    @BeforeEach
    void setUp() {
        cut = new RansomNote();
    }

    @Test
    void case1() {
        assertThat(cut.canConstruct("a", "b")).isFalse();
    }

    @Test
    void case2() {
        assertThat(cut.canConstruct("aa", "ab")).isFalse();
    }

    @Test
    void case3() {
        assertThat(cut.canConstruct("aa", "aab")).isTrue();
    }
}