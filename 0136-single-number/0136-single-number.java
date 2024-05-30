class Solution {
    public int singleNumber(int[] arr) 
    {
        int flag;
        for(int i =0;i<arr.length;i++)
        {
            flag = 0;
            for(int j =0;j<arr.length;j++)
            {
                if(arr[i]==arr[j] && i!=j)
                {
                    flag =1;
                }
            }
            if(flag == 0)
            {
                return arr[i];
            }
        }
        return -1;
    }
}