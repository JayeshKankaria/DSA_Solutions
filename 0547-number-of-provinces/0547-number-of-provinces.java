class Solution 
{
    public int findCircleNum(int[][] isConnected) 
    {
        int V = isConnected.length;
        boolean[] vis = new boolean[V];
        int provinceCount = 0;
        for (int i = 0; i < V; i++) 
        {
            if (!vis[i]) 
            {
                bfs(i, isConnected, vis, V);
                provinceCount++;
            }
        }
        return provinceCount;
    }
    private void bfs(int node, int[][] isConnected, boolean[] vis, int V) 
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        while (!q.isEmpty()) 
        {
            int currNode = q.poll();
            for (int i = 0; i < V; i++) 
            {
                if (isConnected[currNode][i] == 1 && !vis[i]) 
                {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
    }
}