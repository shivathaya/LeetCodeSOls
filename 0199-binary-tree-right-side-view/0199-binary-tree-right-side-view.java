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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightVw = new ArrayList<>();
        dfs(root, 0, rightVw);
        return rightVw;
    }

    private void dfs(TreeNode node, int level, List<Integer> rightVw) {
        if (node == null) return;
//first tile at this level
        if (level == rightVw.size()) {
            rightVw.add(node.val);
        }

        // Go right first
        dfs(node.right, level + 1, rightVw);
        dfs(node.left, level + 1, rightVw);
    }
}