package org.jakubplayground.hashmapsandsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GroupAnagramsTest {
    private GroupAnagrams cut;

    @BeforeEach
    void setUp() {
        cut = new GroupAnagrams();
    }

    @Test
    void case1() {
        assertThat(cut.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}))
                .hasSize(3)
                .satisfiesOnlyOnce(list -> assertThat(list).containsExactlyInAnyOrder("bat"))
                .satisfiesOnlyOnce(list -> assertThat(list).containsExactlyInAnyOrder("nat", "tan"))
                .satisfiesOnlyOnce(list -> assertThat(list).containsExactlyInAnyOrder("ate", "eat", "tea"));
    }

    @Test
    void case2() {
        assertThat(cut.groupAnagrams(new String[]{""}))
                .hasSize(1)
                .satisfiesOnlyOnce(list -> assertThat(list).containsExactlyInAnyOrder(""));
    }

    @Test
    void case3() {
        assertThat(cut.groupAnagrams(new String[]{"a"}))
                .hasSize(1)
                .satisfiesOnlyOnce(list -> assertThat(list).containsExactlyInAnyOrder("a"));
    }
}