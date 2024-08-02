import java.util.HashMap;
import java.util.Map;
class Solution 
{
    private Map<String, Boolean> cache;
    private String s;
    private String p;
    public boolean isMatch(String s, String p) 
    {
        this.cache = new HashMap<>();
        this.s = s;
        this.p = p;
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) 
    {
        String key = i + "," + j;
        if (cache.containsKey(key)) 
        {
            return cache.get(key);
        }
        if (i >= s.length() && j >= p.length()) 
        {
            return true;
        }
        if (j >= p.length()) {
            return false;
        }

        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if ((j + 1) < p.length() && p.charAt(j + 1) == '*') 
        {
            boolean result = dfs(i, j + 2) || (match && dfs(i + 1, j));
            cache.put(key, result);
            return result;
        }
        if (match) 
        {
            boolean result = dfs(i + 1, j + 1);
            cache.put(key, result);
            return result;
        }

        cache.put(key, false);
        return false;
    }
}