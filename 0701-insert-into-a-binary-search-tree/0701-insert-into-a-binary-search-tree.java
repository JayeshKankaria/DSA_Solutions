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
    public TreeNode insertIntoBST(TreeNode root, int val) 
    {
       if (root == null)
        return new TreeNode(val);
        TreeNode ans = root;
        while(true)
        {
            if(ans.val<val)
            {
                if(ans.right == null)
                {
                    ans.right= new TreeNode(val);
                    break;
                }
                else{
                    ans = ans.right;
                }
            }
            else
            {
                if(ans.left == null)
                {
                    ans.left = new TreeNode(val);
                    break;
                }
                else
                {
                    ans=ans.left;
                }
            }
        } 
        return root;
    }
}