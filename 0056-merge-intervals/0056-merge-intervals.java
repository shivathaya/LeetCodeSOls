class Solution {
    public int[][] merge(int[][] intervals) {
        
        if (intervals.length <= 1) return intervals;

        // Step 1: Sort intervals by starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // Step 2: Iterate and merge
        int[] current = intervals[0];
        merged.add(current);

        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {
                // Overlapping -> merge
                current[1] = Math.max(current[1], interval[1]);
            } else {
                // Non-overlapping -> add new interval
                current = interval;
                merged.add(current);
            }
        }

        // Step 3: Convert list to array
        return merged.toArray(new int[merged.size()][]);
        
    }
}