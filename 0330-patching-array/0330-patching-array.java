class Solution {
    public int minPatches(int[] nums, int n) 
    {
       long upper=0;
       int cost=0;
       int i=0;
       while (upper<n)
       {
        if(i<nums.length && nums[i]<=upper+1)
        {
            upper+=nums[i];
            i++;
        }
        else
        {
            cost+=1;
            upper+=upper+1;
        }
       }
       return cost;
    }
}