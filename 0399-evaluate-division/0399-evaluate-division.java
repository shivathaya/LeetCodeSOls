class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
               Map<String, List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(A, new ArrayList<>());
            graph.putIfAbsent(B, new ArrayList<>());
            graph.get(A).add(new Pair(B, val));
            graph.get(B).add(new Pair(A, 1.0 / val));
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            Set<String> visited = new HashSet<>();
            results[i] = dfs(graph, start, end, 1.0, visited);
        }

        return results;
    }

    // DFS helper to find the product path from 'start' to 'end'
    private double dfs(Map<String, List<Pair>> graph, String start, String end, double product, Set<String> visited) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) return -1.0;
        if (start.equals(end)) return product;

        visited.add(start);
        for (Pair neighbor : graph.get(start)) {
            if (!visited.contains(neighbor.node)) {
                double result = dfs(graph, neighbor.node, end, product * neighbor.value, visited);
                if (result != -1.0) return result;
            }
        }

        return -1.0;
    }

    // Pair class to hold neighbor and weight
    private static class Pair {
        String node;
        double value;

        Pair(String node, double value) {
            this.node = node;
            this.value = value;
        }
    }
}