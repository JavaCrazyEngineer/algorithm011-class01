import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *合并区间
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {

    /**
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {

        if(intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
            {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {                             // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }


    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        new MergeIntervals().merge(intervals);
    }
}
