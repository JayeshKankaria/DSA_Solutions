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
class Solution 
{
    public void flatten(TreeNode root) 
    {
        Queue<TreeNode> q = new LinkedList<>();
        f(root,q);
        TreeNode newRoot =q.poll();
        while(!q.isEmpty())
        {
            newRoot.left=null;
            newRoot.right=q.poll();
            newRoot=newRoot.right;
        }
        
    }
    public void f(TreeNode root,Queue<TreeNode> q)
    {
        if(root == null)
        {
            return;
        }
        q.add(root);
        f(root.left,q);
        f(root.right,q);
    }
}