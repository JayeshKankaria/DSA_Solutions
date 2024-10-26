class Solution 
{
    public int strStr(String haystack, String needle) 
    {
        int l = needle.length();
        if(l==haystack.length())
            if(needle.equalsIgnoreCase(haystack))
                return 0;
        for(int i=0;i<haystack.length()-l+1;i++)
        {
            if(needle.equalsIgnoreCase(haystack.substring(i,i+l)))
                return i;
        }
        return -1;
    }
}