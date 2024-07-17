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
public TreeNode dfs(TreeNode root,Set<Integer> set,List<TreeNode> ans,TreeNode parent, boolean isLeft)
    {
        if(root == null)
            return root;
        if(set.contains(root.val))
        {
            if(parent!=null)
            {
                if(isLeft)
                {
                    parent.left=null;
                }
                else
                {
                    parent.right=null;
                }
            }
            if(root.left!=null && set.contains(root.left.val)==false)
                ans.add(root.left);
            if(root.right!=null && set.contains(root.right.val)==false)
                ans.add(root.right);
        }
        dfs(root.left,set,ans,root,true);
        dfs(root.right,set,ans,root,false);
        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) 
    {
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        //Adding elements to delete in HashSet
        for(int i:to_delete)
            set.add(i);
        if(!set.contains(root.val))
            ans.add(root);
        dfs(root,set,ans,null,false);
        return ans;
    }

}
