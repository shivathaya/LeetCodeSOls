class Solution {
    public int minReorder(int n, int[][] connections) {
          List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] conn : connections) {
            int from = conn[0], to = conn[1];
            graph.get(from).add(new int[]{to, 1});  // original direction
            graph.get(to).add(new int[]{from, 0});  // reverse direction
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int changes = 0;

        for (int[] neighbor : graph.get(node)) {
            int nextNode = neighbor[0];
            int isOriginalDirection = neighbor[1];

            if (!visited[nextNode]) {
                // If the road is in original direction (away from 0), we need to reverse it
                changes += isOriginalDirection;
                changes += dfs(nextNode, graph, visited);
            }
        }

        return changes;
    }
}