class Solution {
    public int minSubArrayLen(int target, int[] nums) 
    {
        int l=0;
        int r=0;
        int sum=0,min=Integer.MAX_VALUE;
        while(r<nums.length)
        {
            sum=sum+nums[r];
            if(sum==target)
                min=Math.min(min,r-l+1);
            while(sum>=target)
            {
                min = Math.min(min, r - l + 1);
                sum=sum-nums[l];
                l++;
            }
            r++;
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}