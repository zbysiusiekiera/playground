package org.jakubplayground.arraysandstrings;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ClosestNumberTest {

    private ClosestNumber cut;

    @BeforeEach
    public void beforeAll() {
        cut = new ClosestNumber();
    }

    @Test
    void findClosestNumber_case1() {
        int closestNumber = cut.findClosestNumber(new int[]{-4, -2, 1, 4, 8});
        assertThat(closestNumber).isEqualTo(1);
    }

    @Test
    void findClosestNumber_case2() {
        int closestNumber = cut.findClosestNumber(new int[]{2,-1,1});
        assertThat(closestNumber).isEqualTo(1);
    }
}