class Solution {
    public int subarraysDivByK(int[] nums, int k) 
    {
        HashMap <Integer,Integer> rC = new HashMap<>();//remainderCount
        int count = 0;//To Count number of divisible subArray
        int sum=0;//to store sum of the subarray
        int r =0;//to store remainder
        rC.put(0,1);
        for(int num:nums)
        {
            sum+=num;
            r=sum%k;
            if(r<0)
            {
                r+=k;
            }
            if(rC.containsKey(r))
            {
                count += rC.get(r);
            }
            rC.put(r,rC.getOrDefault(r,0)+1);
        }
        return count;
    }
}