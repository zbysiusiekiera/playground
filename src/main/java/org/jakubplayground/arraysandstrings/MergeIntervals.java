package org.jakubplayground.arraysandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 56. Merge Intervals
 */
public class MergeIntervals {
    private static record Interval(int start, int end) {
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }

        if (intervals.length == 1) {
            return intervals;
        }

        List<Interval> sortedIntervals = Arrays
                .stream(intervals).map(interval -> new Interval(interval[0], interval[1]))
                .sorted(Comparator.comparing(Interval::start))
                .toList();

        int start = sortedIntervals.getFirst().start;
        int end = sortedIntervals.getFirst().end;
        List<Interval> result = new ArrayList<>();
        for (int i = 1; i < sortedIntervals.size(); i++) {
            if (sortedIntervals.get(i).start > end) {
                result.add(new Interval(start, end));
                start = sortedIntervals.get(i).start;
            }

            end = Math.max(end, sortedIntervals.get(i).end);
        }
        result.add(new Interval(start, end));

        int[][] mergedIntervals = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            mergedIntervals[i] = new int[]{result.get(i).start, result.get(i).end};
        }

        return mergedIntervals;
    }
}
