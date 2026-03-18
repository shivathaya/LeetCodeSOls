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
    List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        /*    if(root == null){
            return result;
        }
        if(root.left != null)
            postorderTraversal(root.left);
        if(root.right != null)
            postorderTraversal(root.right);
        result.add(root.val);
        
        return result; */
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node != null)
                result.add(node.val);

            if (node != null && node.left != null)
                stack.push(node.left);
            if (node != null && node.right != null)
                stack.push(node.right);

        }

        Collections.reverse(result);
        return result;

    }
}