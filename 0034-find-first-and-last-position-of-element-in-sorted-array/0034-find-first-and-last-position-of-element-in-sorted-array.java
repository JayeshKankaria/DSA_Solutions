public class Solution 
{
    public static int[] searchRange(int[] nums, int target) 
    {
        int[] result = new int[2];
        result[0] = findPosition(nums, target,true);
        result[1] = findPosition(nums, target,false);
            return result;
    }

    private static int findPosition(int[] nums, int target,boolean first) 
    {
        int start = 0;
        int end = nums.length - 1;
        int position = -1;            
        while (start <= end) 
            {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) 
                {
                    position = mid;
                    if (first)
                        end = mid - 1; // keep searching in the left half
                    else
                        start = mid+1 ;// keep searching in the right half
                } 
                else if (nums[mid] < target) 
                {
                    start = mid + 1;
                } 
                else 
                {
                    end = mid - 1;
                }
            }
            return position;
    }
}