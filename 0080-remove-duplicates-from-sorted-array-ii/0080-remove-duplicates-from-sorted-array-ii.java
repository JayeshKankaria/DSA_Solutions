class Solution 
{
    public int removeDuplicates(int[] arr) 
    {
        int i = 0;
        int c = 1;
        for (int j = 1; j < arr.length; j++) 
        {
            if (arr[i] != arr[j] || c<2) 
            {
                if(arr[i] != arr[j])
                {
                    c=1;
                    //System.out.println(c);
                }
                else
                {
                    c++;
                }
                i++;
                arr[i] = arr[j];
                //System.out.println(arr[j]);
            }
        }
        return i + 1;
    }
}