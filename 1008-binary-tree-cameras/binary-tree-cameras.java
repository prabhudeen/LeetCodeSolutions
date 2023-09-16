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


    public int minCameraCover_(TreeNode root, int cameraCount[]) {
         if(root == null) return 1;

        int lcCount = minCameraCover_(root.left, cameraCount);
        int rcCount = minCameraCover_(root.right, cameraCount);

        if(lcCount == -1 || rcCount == -1) {
            cameraCount[0]++;         
            return 0;
        }

        if(lcCount == 0 || rcCount == 0) return 1;

        return -1;
        
    }
    public int minCameraCover(TreeNode root) {
        int cameraCount[] = {0};
        if(minCameraCover_(root,cameraCount) == -1) cameraCount[0]++;
       
       return cameraCount[0];
    }
}