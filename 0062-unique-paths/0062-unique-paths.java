class Solution {
    public int uniquePaths(int m, int n) 
    {
        int[] row = new int[n];
        for (int i = 0; i < n; i++) 
        {
            row[i] = 1;
        }
        for (int i = m-1; i > 0; i--) 
        {
            int[] newRow = new int[n];
            newRow[n - 1] = 1; 
            for (int j = n - 2; j >= 0; j--) {
                newRow[j] = newRow[j + 1] + row[j];
            }
            row = newRow;
        }

        return row[0];
    }
}
