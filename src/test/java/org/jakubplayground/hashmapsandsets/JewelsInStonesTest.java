package org.jakubplayground.hashmapsandsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JewelsInStonesTest {
    private JewelsInStones cut;

    @BeforeEach
    void setUp() {
        cut = new JewelsInStones();
    }

    @Test
    void case1() {
        assertThat(cut.numJewelsInStones("aA", "aAAbbbb")).isEqualTo(3);
    }

    @Test
    void case2() {
        assertThat(cut.numJewelsInStones("z", "ZZ")).isEqualTo(0);
    }

}