package org.jakubplayground.arraysandstrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SummaryRanges {
    private static class Range {
        public int start;
        public int end;

        public Range(int start) {
            this.start = start;
            this.end = start;
        }

        public String toString() {
            return start != end ? new StringBuilder().append(start).append("->").append(end).toString() : String.valueOf(start);
        }
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }

        if (nums.length == 1) {
            return Collections.singletonList(String.valueOf(nums[0]));
        }

        List<Range> result = new ArrayList<>(nums.length);
        Range r = new Range(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (r.end + 1 == nums[i]) {
                r.end = nums[i];
            } else {
                result.add(r);
                r = new Range(nums[i]);
            }
        }
        result.add(r);

        return result.stream().map(Range::toString).toList();
    }
}
