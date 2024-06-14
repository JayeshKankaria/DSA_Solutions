class Solution {
    public int maxArea(int[] height) 
    {
        int l=0;
        int r=height.length-1;
        int max=0;
        while(l<r)
        {
           int minh = Math.min(height[l],height[r]);
           int w =  r-l;
           int currentarea = minh*w;
            if(max < currentarea )
            {
                max = currentarea;
            }
            if (height[l] < height[r]) 
            {
                l++;
            } 
            else 
            {
                r--;
            }
        }
        return max;
    }
}