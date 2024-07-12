class Solution 
{
    public int climbStairs(int n) 
    {
        //System.out.println(f(n));
        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);
        return f(n,dp);
    }
    public int f(int n,int[]dp)
    {
        if( !(n<0) && dp[n]!=-1)
            return dp[n];
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        return dp[n] = f(n-1,dp)+f(n-2,dp);
    }
}