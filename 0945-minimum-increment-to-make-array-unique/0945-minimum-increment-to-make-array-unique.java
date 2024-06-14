class Solution {
    public int minIncrementForUnique(int[] nums) 
    {
        Arrays.sort(nums);
        int count=0;
        int min=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<=min)
            {
                count+=min-nums[i]+1;
                min++;
            }
            else
            {
                min=nums[i];
            }
        }
        return count;
    }
}