class Solution 
{
    public String convert(String s, int nR) 
    {
        int inc=0;
        StringBuilder str = new StringBuilder();
        if (nR==1)
            return s;
        else
        {
            for (int i=0;i<nR;i++)
            {
                inc=2*(nR-1);
                for(int j=i;j<s.length();j+=inc)
                {
                    str.append(s.charAt(j));
                    if(i>0 && i<nR-1 && (j+inc-2*i)<s.length())
                    {
                        str.append(s.charAt((j+inc-2*i)));
                    }
                }
            }
        }
        return str.toString();
    }
}