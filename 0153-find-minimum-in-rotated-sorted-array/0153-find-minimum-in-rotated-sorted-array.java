class Solution {
    public int findMin(int[] nums) 
    {
        int res=nums[0];
        int l=0;
        int r=nums.length-1;
        int mid;
        while(l<=r)
        {
            mid =l+(r-l)/2;
            res=Math.min(res,nums[mid]);
            if(nums[l]<nums[r])
            {
                res=Math.min(res,nums[l]);
                break;
            }
            if(nums[mid]>=nums[l])
            {
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
        }
        return res;
    }
}