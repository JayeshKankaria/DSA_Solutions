class Solution 
{
    public int[] maxSlidingWindow(int[] a, int k) 
    {
        int n = a.length;
        int r[] = new int[n-k+1];
        int ri=0;
        Deque<Integer> q =  new ArrayDeque<>();
        for(int i = 0;i<n;i++)
        {
            if(!q.isEmpty()&& q.getFirst()==i-k)
            {
                q.pollFirst();
            }
            while(!q.isEmpty()&& a[q.peekLast()]<=a[i])
            {
                q.pollLast();
            }
            q.offerLast(i);
            if(i>=k-1)
            {
                r[ri++]=a[q.peekFirst()];
            }
        }
        return r;
    }
}