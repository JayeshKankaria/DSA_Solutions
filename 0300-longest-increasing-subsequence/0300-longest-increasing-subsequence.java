class Solution 
{
    public int lengthOfLIS(int[] nums) 
    {
        if (nums.length ==0)
            return 0;
        int lis [] = new int[nums.length];
        Arrays.fill(lis, 1);
        for(int i = 1; i<nums.length;i++)
        {
            for(int j = 0;j<i;j++)
            {
                if (nums[i] > nums[j])
                    lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        } 
        int max=0;
        for(int k:lis)
        {
            max=Math.max(max,k);
        }
        return max;
    }
}