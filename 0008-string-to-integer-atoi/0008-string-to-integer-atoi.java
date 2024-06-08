class Solution {
    public int myAtoi(String s) 
    {
        int ans = 0;
        s = s.trim(); // Remove leading and trailing spaces
        int n = s.length();
        int in = 0;
        int d = 0;
        int sn = 1; // Sign of the number, 1 for positive, -1 for negative
        
        if (n == 0) {
            return 0; // If the string is empty, return 0
        }
        
        // Check for sign at the beginning
        if (s.charAt(in) == '-') {
            sn = -1;
            in++;
        } else if (s.charAt(in) == '+') {
            in++;
        }
        
        // Parse digits and form the number
        while (in < n) {
            if (!Character.isDigit(s.charAt(in))) {
                break; // If not a digit, stop parsing
            }
            d = s.charAt(in) - '0';
            
            // Check for overflow
            if (ans > (Integer.MAX_VALUE - d) / 10) {
                return sn == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            ans = (ans * 10) + d;
            in++;
        }
        
        return sn * ans;
    }
}
