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
class BSTIterator {

    private Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        if(root!= null) {
            moveLeft(root);
        }
        
    }

    private void moveLeft(TreeNode root) {
        while(root!= null) {
            stack.push(root);
            root = root.left;
        }
    }
        
    public int next() {
        if(!stack.isEmpty()) {
           TreeNode curNode = stack.pop();
           moveLeft(curNode.right);
           return curNode.val;
        }

        return -1;
    }
    
    public boolean hasNext() {
        if(!this.stack.isEmpty()) return true;     

        return false;  
    }
}


/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */