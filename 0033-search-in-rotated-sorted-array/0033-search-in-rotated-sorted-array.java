class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            // Determine which side is properly sorted
            if (nums[l] <= nums[mid]) {
                // Left side is sorted
                if (nums[l] <= target && target < nums[mid]) 
                {
                    r = mid - 1;
                } 
                else 
                {
                    l = mid + 1;
                }
            } 
            else 
            {
                // Right side is sorted
                if (nums[mid] < target && target <= nums[r]) 
                {
                    l = mid + 1;
                } 
                else 
                {
                    r = mid - 1;
                }
            }
        }
        
        return -1; // Target not found
    }
}