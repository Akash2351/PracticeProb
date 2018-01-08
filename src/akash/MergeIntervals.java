package akash;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by akash on 08-01-2018.
 */
public class MergeIntervals {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    /*Given a collection of intervals, merge all overlapping intervals.

    For example,
    Given [1,3],[2,6],[8,10],[15,18],
            return [1,6],[8,10],[15,18].*/

    public List<Interval> merge(List<Interval> intervals) {

        if (intervals == null || intervals.size() == 1 || intervals.size() == 0)
            return intervals;

        List<Interval> list = new ArrayList<>();
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Iterator<Interval> iterator = list.iterator(); iterator.hasNext(); ) {
            Interval next = iterator.next();
            if (end >= next.start) {
                end = Math.max(end, next.end);
            } else {
                list.add(new Interval(start, end));
                start = next.start;
                end = next.end;
            }
        }
        return list;
    }
}
