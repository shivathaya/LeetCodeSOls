/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            Node prev = null;

            for(int i=0; i<size; i++){
                Node curr = queue.poll();
                if(prev != null)
                    prev.next = curr;
                prev = curr;

                if(curr.left != null)
                    queue.offer(curr.left);
                if(curr.right != null)
                    queue.offer(curr.right);
                
            }
        }

        return root;
    }
}

/* dfs so;utoion
    public Node connect(Node root) {
      dfs(root);

        return root;
    }

  
    private void dfs(Node node) {

        if (node == null || node.left == null) {
            return;
        }

        // Connect left child to right child
        node.left.next = node.right;

        // Connect right child to next node's left child
        if (node.next != null) {
            node.right.next = node.next.left;
        }

        dfs(node.left);
        dfs(node.right);
    }
*/