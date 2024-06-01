class Solution {
    public void nextPermutation(int[] nums) 
    {
        if (nums == null || nums.length <= 1) 
        {
            return;
        }
        int small=-1;
        int greater=0;
        int i=0;
        int n = nums.length;
        for (i=n-1;i>0;i--)
        {
            if (nums[i]>nums[i-1])
            {
                small =i-1;
                break;
            }
        }
        if(small==-1)
        {
            reverse(nums, 0, n - 1);
            return;
        }
        greater =n-1;
        for(i=n-1;i>=small+1;i--)
        {
            if(nums[i]>nums[small])
            {
                greater=i;
                break;
            }
        }
        swap(nums,small,greater);
        reverse(nums,small+1,n-1);
    }
    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private static void swap(int[] nums, int i, int index) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }
}
