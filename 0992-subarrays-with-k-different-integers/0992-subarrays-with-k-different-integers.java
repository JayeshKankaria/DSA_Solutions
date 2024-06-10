class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) 
    {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) 
    {
        int l = 0, r = 0, count = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (r = 0; r < nums.length; r++) 
        {
            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);
            while (freq.size() > k) 
            {
                freq.put(nums[l], freq.get(nums[l]) - 1);
                if (freq.get(nums[l]) == 0) {
                    freq.remove(nums[l]);
                }
                l++;
            }
            count += r - l + 1;
        }

        return count;
    }
}