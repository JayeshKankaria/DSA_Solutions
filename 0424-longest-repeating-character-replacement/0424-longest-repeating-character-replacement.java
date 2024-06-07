class Solution {
    public int characterReplacement(String s, int k) {
        int maxf = 0, maxlen = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxf = Math.max(maxf, map.get(c));
            // If the number of characters to change exceeds k, shrink the window from the left
            while ((right - left + 1) - maxf > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            // Update maxlen if the current window size is larger
            maxlen = Math.max(maxlen, right - left + 1);
        }

        return maxlen;
    }
}
