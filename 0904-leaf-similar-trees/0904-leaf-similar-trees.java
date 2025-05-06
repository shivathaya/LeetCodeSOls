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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> lfs1 = new ArrayList<>();
        List<Integer> lfs2 = new ArrayList<>();
        getLeafs(root1, lfs1);
        getLeafs(root2, lfs2);

        return lfs1.equals(lfs2);
        
    }

    private void getLeafs(TreeNode root, List<Integer> leafList){
        if(root == null) return;
        if(root.left == null && root.right == null){
            leafList.add(root.val);
        } else{
            getLeafs(root.left, leafList);
            getLeafs(root.right, leafList);
        }

    }
}