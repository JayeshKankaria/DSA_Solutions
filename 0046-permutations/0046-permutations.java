class Solution 
{
    public void recurPermute(int index,int[] nums,List<List<Integer>>ans)
    {
        if (index == nums.length)
        {
            List<Integer>db = new LinkedList<>();
            for(int num : nums)
            {
                db.add(num);
            }
            ans.add(db);
            return;
        }
        for(int i = index;i<nums.length;i++)
        {
            swap(i,index,nums);
            recurPermute(index+1,nums,ans);
            swap(index,i,nums);
        }
    }
    public void swap (int i,int j,int arr[])
    {
        int t = arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> ans = new ArrayList<>();
         recurPermute(0,nums,ans);
        return ans;
    }
}