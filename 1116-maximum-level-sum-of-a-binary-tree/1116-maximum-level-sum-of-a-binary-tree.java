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
class Solution {
    public int maxLevelSum(TreeNode root) {
        List<Integer> sumLevel = new ArrayList<>();
        dfs(root, 0, sumLevel);

        int maxSum = Integer.MIN_VALUE;
        int level = 0;

        for (int i = 0; i < sumLevel.size(); i++) {
            if (sumLevel.get(i) > maxSum) {
                maxSum = sumLevel.get(i);
                level = i + 1;
            }
        }

        return level;
    }

    private void dfs(TreeNode node, int depth, List<Integer> sumLevel) {
        if (node == null) return;

        if (depth == sumLevel.size()) {
            sumLevel.add(node.val);
        } else {
            sumLevel.set(depth, sumLevel.get(depth) + node.val);
        }

        dfs(node.left, depth + 1, sumLevel);
        dfs(node.right, depth + 1, sumLevel);
    }
    
}