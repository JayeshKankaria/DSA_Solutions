class Solution {
    public int numberOfSubstrings(String s) 
    {
        int lastindex[]={-1,-1,-1};
        int count=0;
        for(int i =0;i<s.length();i++)
        {
            lastindex[s.charAt(i)-'a']=i;
            if(lastindex[0]!=-1 && lastindex[1]!=-1 && lastindex[2]!=-1)
                count+= 1+Math.min(lastindex[0],Math.min(lastindex[1],lastindex[2]));
        }
        return count;
    }
}