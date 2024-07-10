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

    public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[2]; // result[0] is count, result[1] is the kth smallest value
        inorder(root, k, result);
        return result[1];
    }

    private void inorder(TreeNode root, int k, int[] result) {
        if (root == null) {
            return;
        }

        inorder(root.left, k, result);

        result[0]++;
        if (result[0] == k) {
            result[1] = root.val;
            return;
        }

        inorder(root.right, k, result);
    }
}
