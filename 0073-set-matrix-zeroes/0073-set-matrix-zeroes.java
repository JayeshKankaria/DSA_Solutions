class Solution {
    public void setZeroes(int[][] matrix) 
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int i,j=0;
        ArrayList<Integer> k = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        for (i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if (matrix[i][j] == 0)
                {
                    k.add(i);
                    l.add(j);
                }
            }
        }
        for (i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if ( k.contains(i) || l.contains(j))
                {
                    matrix[i][j]=0;
                }
            }
        }
    }
}