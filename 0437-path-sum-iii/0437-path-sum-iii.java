/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currSum, int target, Map<Long, Integer> prefixSumCount) {
        if (node == null) return 0;

        currSum += node.val;
        int numPathsToCurr = prefixSumCount.getOrDefault(currSum - target, 0);

        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

        int leftPaths = dfs(node.left, currSum, target, prefixSumCount);
        int rightPaths = dfs(node.right, currSum, target, prefixSumCount);

        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);

        return numPathsToCurr + leftPaths + rightPaths;
    }
}