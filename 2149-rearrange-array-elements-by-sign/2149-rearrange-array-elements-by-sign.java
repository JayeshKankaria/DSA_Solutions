class Solution {
    public int[] rearrangeArray(int[] nums) 
    {
        int []ans = new int[nums.length];
        int e =0;
        int o = 1;
        for(int i: nums)
        {
            if(i<0)
            {
                ans[o]=i;
                o+=2;
            }
            else
            {
                ans[e]=i;
                e+=2;
            }
        }
        return ans;
    }
}