class Solution {
    public int longestConsecutive(int[] nums) 
    {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) 
        {
            numSet.add(num);
        }
        int max = 0;
        for (int num : numSet) {
            // Only start counting from numbers that are the beginning of a sequence
            if (!numSet.contains(num - 1)) 
            {
                int currentNum = num;
                int count = 1;
                while (numSet.contains(currentNum + 1)) 
                {
                    currentNum++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }
}