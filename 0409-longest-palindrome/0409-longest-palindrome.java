import java.util.HashMap;
class Solution 
{
    public int longestPalindrome(String s) 
    {
        HashMap<Character, Integer> charCount = new HashMap<>();
        // Count each character's frequency
        for (char c : s.toCharArray()) 
        {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        int length = 0;
        boolean oddOccurred = false;
        // Calculate the length of the longest palindrome
        for (int count : charCount.values()) 
        {
            if (count % 2 == 0) 
            {
                length += count;  // If even, add the whole count
            } 
            else 
            {
                length += count - 1;  // If odd, add the largest even part
                oddOccurred = true;  // Mark that an odd count has occurred
            }
        }
        // If there was any odd count, we can place one odd character in the center
        if (oddOccurred) 
        {
            length += 1;
        }

        return length;
    }
}
