class Solution 
{
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        f(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
    public void f(int[] arr, int i, List<Integer> db, List<List<Integer>> ans)       {
        ans.add(new ArrayList<>(db));  // Add a copy of the current subset
        for (int j = i; j < arr.length; j++) 
        {
            // Skip duplicates
            if (j > i && arr[j] == arr[j - 1]) 
            {
                continue;
            }
            // Include the current element
            db.add(arr[j]);
            f(arr, j + 1, db, ans);
            // Exclude the current element
            db.remove(db.size() - 1);
        }
    }
}
