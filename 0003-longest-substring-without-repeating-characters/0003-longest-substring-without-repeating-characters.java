class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int l = 0, r = 0;
        HashSet<Character> set = new HashSet<>();
        while (r < s.length()) 
        {
            if (!set.contains(s.charAt(r))) 
            {
                set.add(s.charAt(r));
                max = Math.max(max, r - l + 1);
                r++;
            } 
            else 
            {
                set.remove(s.charAt(l));
                l++;
            }
        }
        
        return max;
    }
}
