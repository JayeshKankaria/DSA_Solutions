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
    public boolean isValidBST(TreeNode root) 
    {
        return fun(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean fun(TreeNode node,long min,long max)
    {
        if(node==null)  return true;
        if(node.val>=max || node.val<=min)  return false;
        return (fun(node.left,min,node.val)&& fun(node.right,node.val,max));
    }
}