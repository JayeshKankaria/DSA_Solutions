class Solution 
{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        int i,j;
        int []nge = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();
        for(i=nums2.length-1;i>=0;i--)
        {
            while(!stack.empty() && stack.peek()<=nums2[i%nums2.length])
            {
                stack.pop();
            }
            if(i<nums2.length)
            {
                if(!stack.empty())
                {
                    nge[i]=stack.peek();
                    System.out.println(nge[i]);
                }
                else
                {
                    nge[i]=-1;
                }
            }
            stack.push(nums2[i%nums2.length]);
        }
        int ans[]= new int[nums1.length];
        int l=0;
        for(int i1=0;i1<nums1.length;i1++)
        {
            int n=nums1[i1];
            for(int j1=0;j1<nums2.length;j1++)
            {
                if(n==nums2[j1])
                {
                    ans[l]=nge[j1];
                    l++;
                }
            }
        }
        return ans;
    }
}