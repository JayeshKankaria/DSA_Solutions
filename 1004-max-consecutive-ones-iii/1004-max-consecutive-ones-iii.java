class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, max = 0, z = 0;
        Deque<Integer> dq = new LinkedList<>();
        for (int r = 0; r < nums.length; r++) 
        {
            if (nums[r] == 0) 
            {
                dq.offerLast(r);
            }
            if (dq.size() > k) 
            {
                l = dq.pollFirst() + 1;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}