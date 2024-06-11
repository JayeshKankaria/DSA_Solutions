class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        int[] hash = new int[256];
        int count = 0;
        int l = 0, r = 0, minLen = Integer.MAX_VALUE, starti = 0;
        for (char c : t.toCharArray()) {
            hash[c]++;
        }

        char[] chS = s.toCharArray();
        while (r < chS.length) {
            if (hash[chS[r]] > 0) {
                count++;
            }
            hash[chS[r]]--;
            r++;

            while (count == t.length()) {
                if (r - l < minLen) {
                    minLen = r - l;
                    starti = l;
                }

                hash[chS[l]]++;
                if (hash[chS[l]] > 0) {
                    count--;
                }
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : new String(chS, starti, minLen);
    }
}
