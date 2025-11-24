class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
                PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]  // Min-heap based on value
        );

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Extract the k largest elements (but may be unordered)
        List<int[]> list = new ArrayList<>();
        while (!pq.isEmpty()) list.add(pq.poll());

        // Sort by index to keep original order
        list.sort((a, b) -> a[1] - b[1]);

        // Build result
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = list.get(i)[0];
        return res;
    }
}