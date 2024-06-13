class Solution {
    public int maxProfit(int[] prices) 
    {
        int l=0,r=1;
        int max=0;
        while(r<prices.length)
        {
            if(prices[l]<prices[r])
            {
                max+=prices[r]-prices[l];
                l=r;
            }
            else
            {
                l++;
            }
            r++;
        }
        return max;
    }
}