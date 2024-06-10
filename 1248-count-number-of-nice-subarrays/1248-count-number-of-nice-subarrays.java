class Solution {
    public int numberOfSubarrays(int[] nums, int k) 
    {
        int n[] = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2!=0)
                n[i]=1;
            else
                n[i]=0;
        }
        int x =helper(n,k);
        int y=helper(n,k-1);
        return x-y;
    }
        public int helper(int[] nums, int g) {
        if (g < 0) {
            return 0;
        }
        int l = 0;
        int sum = 0;
        int count = 0;

        for (int r = 0; r < nums.length; r++) 
        {
            sum += nums[r];
            while (sum > g && l <= r) 
            {
                sum -= nums[l];
                l++;
            }
            count += r - l + 1;
        }

        return count;
    }
}