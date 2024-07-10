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
    int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }
    
    private int helper(TreeNode root) {
        if (root == null) 
        {
            return 0;
        }
        int left = Math.max(helper(root.left), 0);
        //Why to take -ve value it will decrease the sum only
        int right = Math.max(helper(root.right), 0);
        
        int currPathSum = root.val + left + right;
        maxSum = Math.max(maxSum, currPathSum);
        
        return root.val + Math.max(left, right);
    }
}