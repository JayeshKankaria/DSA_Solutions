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
    public boolean isSibling(TreeNode root, int x, int y)
    {
        Queue <TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) 
        { 
            TreeNode nd = q.poll();
            if (nd.left != null) 
            { 
                q.add(nd.left); 
                if (nd.left.val == x || nd.left.val == y)
                {
                    if((nd.right != null)&&(nd.right.val == y|| nd.right.val == x))
                        return true;
                    return false;
                } 
            } 
            if (nd.right != null) 
            { 
                q.add(nd.right); 
            } 
        }
        return false;
    } 
    public boolean isCousins(TreeNode root, int x, int y) 
    {
        if (root == null)
        {
            return false;
        }
        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> curr_level=new ArrayList<>();
            for(int i =0;i<size;i++)
            {
                TreeNode node = queue.poll();
                curr_level.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                //System.out.println(curr_level);
            }
            if (curr_level.indexOf(x)!=-1)
            {
                if(curr_level.indexOf(y)!=-1)
                {
                    return !isSibling(root,x,y);
                }
                else
                    return false;
            }
        }
        return false;
    }
}