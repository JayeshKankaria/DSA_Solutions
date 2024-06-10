class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int x = helper(nums, goal);
        int y = helper(nums, goal - 1);
        return x - y;
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