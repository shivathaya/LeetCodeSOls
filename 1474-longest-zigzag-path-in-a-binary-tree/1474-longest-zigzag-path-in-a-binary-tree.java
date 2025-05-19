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
    private int maxLength = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null) return 0;

        zigzag(root.left, "left", 1);
        zigzag(root.right, "right", 1);

        return maxLength;
    }

    public void zigzag(TreeNode node, String lr, int length){
        if(node == null) return;
        maxLength = Math.max(maxLength, length);
        if(lr.equals("left")){
            zigzag(node.right, "right", length + 1);
            zigzag(node.left, "left", 1);
        }
        else{
            zigzag(node.left, "left", length + 1);
            zigzag(node.right, "right", 1);
        }
    }
}