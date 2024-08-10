package org.jakubplayground.arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RomanToIntTest {
    private RomanToInt cut;

    @BeforeEach
    void setUp() {
        cut = new RomanToInt();
    }

    @Test
    void case1() {
        assertThat(cut.romanToInt("III")).isEqualTo(3);
    }

    @Test
    void case2() {
        assertThat(cut.romanToInt("LVIII")).isEqualTo(58);
    }

    @Test
    void case3() {
        assertThat(cut.romanToInt("MCMXCIV")).isEqualTo(1994);
    }
}