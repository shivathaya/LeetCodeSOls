class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // Step 1: Add all initially rotten oranges to queue and count fresh oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        // If no fresh oranges, return 0
        if (freshCount == 0) return 0;

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int minutes = 0;

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotHappened = false;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // Check boundaries and if the neighbor is fresh
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                        grid[newRow][newCol] == 1) {
                        
                        // Make it rotten
                        grid[newRow][newCol] = 2;
                        freshCount--;
                        rotHappened = true;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }

            // Only increment time if rot spread in this round
            if (rotHappened) minutes++;
        }

        // Step 3: Check if all fresh oranges are rotten
        return freshCount == 0 ? minutes : -1;
    }
}