class Solution 
{
    private Map<String, Integer> cache;
    public int change(int amount, int[] coins) 
    {
        cache = new HashMap<>();
        return dfs(0, 0, amount, coins);
    }
    private int dfs(int i, int a, int amount, int[] coins) 
    {
        if (a == amount) 
        {
            return 1;
        }
        if (a > amount) 
        {
            return 0;
        }
        if (i == coins.length) 
        {
            return 0;
        }
        String key = i + "," + a;
        if (cache.containsKey(key)) 
        {
            return cache.get(key);
        }
        int result = dfs(i, a + coins[i], amount, coins) + dfs(i + 1, a, amount, coins);
        cache.put(key, result);
        return result;
    }
}