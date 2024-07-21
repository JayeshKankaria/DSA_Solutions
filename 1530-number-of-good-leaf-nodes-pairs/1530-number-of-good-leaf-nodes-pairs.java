// import java.util.ArrayList;

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }
class Solution 
{
    private int pairs;
    public Solution() 
    {
        this.pairs = 0;
    }
    public int countPairs(TreeNode root, int distance) 
    {
        dfs(root, distance);
        return pairs;
    }
    private ArrayList<Integer> dfs(TreeNode node, int distance) 
    {
        if (node == null) 
        {
            return new ArrayList<>();
        }
        if (node.left == null && node.right == null) 
        {
            ArrayList<Integer> leafDistances = new ArrayList<>();
            leafDistances.add(1);
            return leafDistances;
        }

        ArrayList<Integer> leftDist = dfs(node.left, distance);
        ArrayList<Integer> rightDist = dfs(node.right, distance);

        for (int d1 : leftDist) {
            for (int d2 : rightDist) {
                if (d1 + d2 <= distance) {
                    pairs++;
                }
            }
        }

        ArrayList<Integer> allDist = new ArrayList<>(leftDist);
        allDist.addAll(rightDist);
        for (int i = 0; i < allDist.size(); i++) {
            allDist.set(i, allDist.get(i) + 1);
        }

        return allDist;
    }
}
