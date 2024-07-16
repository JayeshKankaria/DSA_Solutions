class Solution 
{
    public boolean isPalindrome(String s) 
    {
        StringBuilder alphaNumeric = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) 
        {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) 
            {
                alphaNumeric.append(Character.toLowerCase(ch));
            }
        }
        
        int l = 0;
        int r = alphaNumeric.length() - 1;
        
        while (l <= r) 
        {
            if (alphaNumeric.charAt(l) != alphaNumeric.charAt(r)) 
            {
                return false;
            }
            l++;
            r--;
        }
        
        return true;
    }
}