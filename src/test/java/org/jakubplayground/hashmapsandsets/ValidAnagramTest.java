package org.jakubplayground.hashmapsandsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidAnagramTest {
    private ValidAnagram cut;

    @BeforeEach
    void setUp() {
        cut = new ValidAnagram();
    }

    @Test
    void case1() {
        assertThat(cut.isAnagram("anagram", "nagaram")).isTrue();
    }

    @Test
    void case2() {
        assertThat(cut.isAnagram("cat", "rat")).isFalse();
    }

    @Test
    void case3() {
        assertThat(cut.isAnagram("aacc", "ccac")).isFalse();
    }
}