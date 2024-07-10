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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int r = preorder[0];
        int in =0;
        for(int i =0 ;i<inorder.length;i++)
        {
            if(inorder[i]==r)
            {
                in = i;
                break;
            }
        }
        TreeNode node = new TreeNode(r);
        node.left=buildTree(Arrays.copyOfRange(preorder,1,in+1),Arrays.copyOfRange(inorder,0,in));
        node.right=buildTree(Arrays.copyOfRange(preorder,in+1,preorder.length),Arrays.copyOfRange(inorder,in+1,inorder.length));
        return node;
        
    }
}