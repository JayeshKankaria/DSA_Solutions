class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int nl = nums1.length+nums2.length;
        int nums[]=new int[nl];
        int i =0;
        double ans=0;
        int i1=0,i2=0;
        while(i1<nums1.length && i2<nums2.length)
        {
            if(nums1[i1]<nums2[i2])
            {
                nums[i]= nums1[i1];
                i1++;
            }
            else
            {
                nums[i]=nums2[i2];
                i2++;
            }
            i++;
        }
        while(i1<nums1.length)
        {
            nums[i]= nums1[i1];
            i1++;
            i++;
        }
        while(i2<nums2.length)
        {
            nums[i]= nums2[i2];
            i2++;
            i++;
        }
        // for(int n: nums)
        // {
        //     System.out.println(n);
        // }
        if(nl%2==0)
        {
            int in =nl/2;
            ans=(nums[in]+nums[in-1])/2.0;
        }
        else
        {
            int in =nl/2;
            ans =nums[in];
        }
        return ans;
    } 
}