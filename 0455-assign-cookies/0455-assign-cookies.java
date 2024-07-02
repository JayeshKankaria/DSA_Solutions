class Solution {
    public int findContentChildren(int[] g, int[] s) 
    {
        Arrays.sort(g);
        Arrays.sort(s);
        int sl=0;
        int gl =0;
        int count=0;
        while(sl<s.length && gl<g.length)
        {
            if(s[sl]>=g[gl])
            {
                count++;
                gl++;
            }
            sl++; 
        }
        return count;
    }
}