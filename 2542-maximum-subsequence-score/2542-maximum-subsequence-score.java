class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
                int n = nums1.length;
        
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        // Sort by nums2 descending
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long maxScore = 0;

        for (int[] p : pairs) {
            minHeap.offer(p[0]);
            sum += p[0];

            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * p[1]);
            }
        }

        return maxScore;
    }
}