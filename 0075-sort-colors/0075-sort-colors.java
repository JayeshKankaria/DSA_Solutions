class Solution {
    public void sortColors(int[] arr) 
    {
        int l = 0;
        int i,j;
        for(i =0;i<3;i++)
        {
            for(j = 0;j<arr.length;j++)
            {
                if(i== arr[j])
                {
                    int temp = arr[l];
                    arr[l]=i;
                    arr[j]=temp;
                    l++;
                }
            }
        }
        for(j = 0;j<arr.length;j++)
        {
            System.out.println(arr[j]);
        }
    }
}