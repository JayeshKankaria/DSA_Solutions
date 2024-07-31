class Solution 
{
    Map<String,Integer> mp;
    public int change(int amount, int[] coins)
    {
        mp =new HashMap<>();
        return dfs(amount,0,coins);
    }
    public int dfs(int a,int i,int[] coins)
    {
        if (a == 0)
        {
            return 1;
        }
        if(a<0 || i == coins.length) 
        {
            return 0;
        }
        String key = a + "-" + i;
        if (mp.containsKey(key)) 
        {
            return mp.get(key);
        }
        int result = dfs(a-coins[i],i,coins) +dfs(a,i+1,coins);
        mp.put(key,result);
        return result;
    }
}