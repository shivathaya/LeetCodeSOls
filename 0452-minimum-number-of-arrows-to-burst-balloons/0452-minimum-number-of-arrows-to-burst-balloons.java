class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Step 1: Sort intervals by end position
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;  
        int end = points[0][1];  // position of first arrow

        // Step 2: Iterate and shoot arrows greedily
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                // New arrow needed if balloon starts after current arrow end
                arrows++;
                end = points[i][1];
            }
            // else: current arrow at "end" bursts this balloon too
        }

        return arrows;
    }
}