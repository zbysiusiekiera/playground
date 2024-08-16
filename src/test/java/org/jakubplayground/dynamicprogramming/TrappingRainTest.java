package org.jakubplayground.dynamicprogramming;

import org.jakubplayground.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class TrappingRainTest {
    private TrappingRain cut;
    static int[] heights;

    static {
        InputStream is = TrappingRainTest.class.getResourceAsStream("/heights.txt");
        String data = null;
        try {
            data = TestUtil.readFromInputStream(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        heights = Arrays.stream(data.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
    }

    @BeforeEach
    void setUp() {
        cut = new TrappingRain();
    }

    @Test
    public void case1() {
        assertThat(cut.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})).isEqualTo(6);
    }

    @Test
    public void case2() {
        assertThat(cut.trap(new int[]{4,2,0,3,2,5})).isEqualTo(9);
    }

    @Test
    public void case3() throws IOException {
        System.out.println(heights.length);
        assertThat(cut.trap(heights)).isEqualTo(174801674);
    }
}