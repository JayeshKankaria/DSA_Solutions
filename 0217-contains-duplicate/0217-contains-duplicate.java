class Solution {
    public boolean containsDuplicate(int[] nums) 
    {
        HashSet<Integer> st = new HashSet<>();
        for (int i : nums)
        {
            if(st.contains(i))
            {
                return true;
            }
            else
            {
                st.add(i);
            }
        }
        return false;
    }
}