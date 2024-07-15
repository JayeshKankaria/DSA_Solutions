 import java.util.*;

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> nodes = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();
        
        // Build the parent-child relationship map
        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            boolean isLeft = description[2] == 1;
            nodes.putIfAbsent(parentVal, new TreeNode(parentVal));
            nodes.putIfAbsent(childVal, new TreeNode(childVal));
            TreeNode parentNode = nodes.get(parentVal);
            TreeNode childNode = nodes.get(childVal);
            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            
            children.add(childVal);
        }
        // Find the root node value
        int rootVal = -1;
        for (int parentVal : nodes.keySet()) {
            if (!children.contains(parentVal)) {
                rootVal = parentVal;
                break;
            }
        }
        
        return nodes.get(rootVal);
    }
}
