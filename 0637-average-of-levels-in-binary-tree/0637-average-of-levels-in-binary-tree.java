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
    public List<Double> averageOfLevels(TreeNode root) 
    {
        List<Double> ans = new ArrayList<>();
        if (root == null)
        {
            return ans;
        }
        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            long curr_level_sum =0;
            for(int i =0;i<size;i++)
            {
                TreeNode node = queue.poll();
                curr_level_sum+=node.val;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                //System.out.println(curr_level);
            }
            ans.add(1.0*curr_level_sum/size);  
        }
        return ans;
        
    }
}

