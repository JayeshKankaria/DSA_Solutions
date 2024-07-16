import java.util.LinkedList;
import java.util.Queue;
class Solution 
{
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) 
    {
        if (grid == null || grid.length == 0) 
        {
            return grid;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int originalColor = grid[sr][sc];

        if (originalColor == color) 
        {
            return grid; 
        // No need to change if the original color is the same as the new color
        }

        boolean[][] vis = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        vis[sr][sc] = true;
        grid[sr][sc] = color;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while (!queue.isEmpty()) 
        {
            int[] point = queue.poll();
            for (int j = 0; j < 4; j++) 
            {
                int x = point[0] + dx[j];
                int y = point[1] + dy[j];
                if (x < 0 || y < 0 || x >= rows || y >= cols || vis[x][y] 
                || grid[x][y] != originalColor) 
                {
                    continue;
                }
                queue.offer(new int[]{x, y});
                vis[x][y] = true;
                grid[x][y] = color;
            }
        }
        return grid;
    }
}
