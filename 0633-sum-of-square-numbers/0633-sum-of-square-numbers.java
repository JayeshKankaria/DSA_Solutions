class Solution {
    public boolean judgeSquareSum(int c) 
    {
        long a =0;
        long b=(int)Math.sqrt(c);
        //Extreme case 0^2+b^2==c^2
        long sum=0;
        while(a<=b)
        {
            sum=a*a+b*b;
            if(sum==c)
                return true;
            else if(sum<c)
                a++;
            else
                b--;
        }
        return false;
    }
}