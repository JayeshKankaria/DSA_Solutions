class Solution {
    public int maxScore(int[] nums, int k) 
    {
        int lsum=0,rsum=0,maxSum=0;
        int i=0,ri=nums.length-1;
        for(i=0;i<k;i++)
            lsum+=nums[i];
        maxSum=lsum;
        for(i=k-1;i>=0;i--)
        {
            lsum-=nums[i];
            rsum+=nums[ri];
            ri--;
            maxSum=Math.max(maxSum,lsum+rsum);
        }
        return maxSum;
    }
}